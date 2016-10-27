FROM anapsix/alpine-java:jre8

MAINTAINER sklose@next-level-intgegration.com

ARG PORT=8080

#ADD app.jar /app.jar
RUN mkdir /app
RUN touch /app/test

EXPOSE ${PORT}

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
