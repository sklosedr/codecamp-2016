FROM anapsix/alpine-java:jre8

MAINTAINER sklose@next-level-intgegration.com

ADD target/codecamp-2016-dog-service*.jar /codecamp-2016-dog-service.jar
RUN sh -c 'touch /codecamp-2016-dog-service.jar'

EXPOSE 8084

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/codecamp-2016-dog-service.jar"]
