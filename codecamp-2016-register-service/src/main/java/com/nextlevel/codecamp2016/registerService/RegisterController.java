/**
 * Fast Lane Platform - Open Source License:
 *
 * "Copyright (C) 2009-2015 Next Level Integration GmbH http://www.next-level-integration.com
 *
 * This file is part of the Fast Lane Platform solution. The Fast Lane Platform is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * The Fast Lane Platform is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with the Fast Lane Platform;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Linking the Fast Lane Platform statically or dynamically with other modules is making a
 * combined work based on the Fast Lane Platform. Thus, the terms and conditions of the
 * GNU General Public License cover the whole combination.
 *
 * In addition, as a special exception, the copyright holders of the Fast Lane Platform give you
 * permission to combine the Fast Lane Platform with code included in the (binary) release of
 * Next Level Integration GmbH Next Level Software under Next Level Integration GmbHs commercial license
 * (or modified versions of such code, with unchanged license). You may copy and distribute such a system
 * following the terms of the GNU GPL for the Fast Lane Platform and the licenses of Next Level Integration GmbH."
 */
package com.nextlevel.codecamp2016.registerService;

import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RegisterController {
	
	@GetMapping("/registration")
	    public String registrationGet(Model model) {
			model.addAttribute("register", new Register());
			return "registration";
	    }
	
	@PostMapping("/registration")
		public String submitRegistration(@RequestBody Register register){
			System.out.println(register.getName());
			Dog dog = new Dog();
			convertToDog(dog, register);
			DogUser user = new DogUser();
			convertToUser(user, register);
			return "success";
		}
		
		private void convertToDog(Dog dog, Register reg){
			dog.setDescription(reg.getDescription());
			dog.setFavoriteToy(reg.getFavoriteToy());
			dog.setGoodDog(reg.isGoodDog());
			dog.setId(reg.getId());
			dog.setName(reg.getName());
		}
		
		private void convertToUser(DogUser user, Register reg){
			user.setUsername(reg.getUsername());
			user.setPassword(reg.getPassword());
			user.setUserRole(reg.getUserRole());
			user.setId(reg.getId());
		}
	
	@RequestMapping(value = "/getRegistrations", method=RequestMethod.GET)
		public List<Register> getRegistrations(){
			List<Register> list =  new ArrayList();
			Register reg = new Register();
			reg.setId(1l);
			reg.setUsername("some_dog");
			reg.setPassword("test");
			reg.setUserRole(UserRole.USER);
			
			list.add(reg);
		
			return list;
		}
}
