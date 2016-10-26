FROM anapsix/alpine-java:jre8

MAINTAINER sklose@next-level-intgegration.com

ADD target/codecamp-2016-user-service*.jar /codecamp-2016-user-service.jar
RUN sh -c 'touch /codecamp-2016-user-service.jar'

EXPOSE 8083

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/codecamp-2016-user-service.jar"]
