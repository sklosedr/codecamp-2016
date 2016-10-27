package com.nextlevel.codecamp.webapp;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.nextlevel.codecamp.webapp.security.AjaxAuthenticationFailureHandler;
import com.nextlevel.codecamp.webapp.security.AjaxAuthenticationSuccessHandler;
import com.nextlevel.codecamp.webapp.security.AjaxLogoutSuccessHandler;
import com.nextlevel.codecamp.webapp.security.Http401UnauthorizedEntryPoint;
import com.nextlevel.codecamp.webapp.security.JsonUserNameAuthenticationFilter;
import com.nextlevel.codecamp.webapp.security.UserAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Inject
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Inject
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Inject
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;
    
    @Inject
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

    @Inject
    private UserAuthenticationProvider userAuthenticationProvider;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(userAuthenticationProvider);
    }
    
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/dogs")
            .antMatchers("/register")
            .antMatchers("/login")
            .antMatchers("/*.{html,css,ico}")
            .antMatchers("/app/**/*.{html,js,css}")
            .antMatchers("/assets/**")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.addFilterBefore(corsFilter(), ChannelProcessingFilter.class)
        	.addFilterBefore(jsonUserNameAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	        .exceptionHandling()	
	        .authenticationEntryPoint(authenticationEntryPoint)
	    .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler(ajaxLogoutSuccessHandler)
            .deleteCookies("NLISESSIONID")
            .permitAll()
        .and()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .authorizeRequests()
//            .antMatchers("/register").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/dogs").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/**").authenticated()
        .and()
        	.csrf().disable();
    }
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
		return new CorsFilter(source);
    }

    @Bean
    public CorsConfiguration corsConfig() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		return config;
	}

    @Bean
    public JsonUserNameAuthenticationFilter jsonUserNameAuthenticationFilter() throws Exception {
    	JsonUserNameAuthenticationFilter jsonFilter = new JsonUserNameAuthenticationFilter();
    	jsonFilter.setAuthenticationManager(authenticationManager());
    	jsonFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler);
    	jsonFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler);
        return jsonFilter;
    }
}