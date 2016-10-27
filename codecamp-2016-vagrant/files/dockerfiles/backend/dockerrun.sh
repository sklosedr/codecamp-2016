#!/bin/bash

if [ ! -e backend-webapp ]; then
	mkdir backend-webapp
fi
if [ ! -e service-registry ]; then
	mkdir service-registry
fi
if [ ! -e register-service ]; then
	mkdir register-service
fi
if [ ! -e user-service ]; then
	mkdir user-service
fi
if [ ! -e dog-service ]; then
	mkdir dog-service
fi

cp ../../../../codecamp-2016-webapp/codecamp-2016-backend-webapp/target/*.jar ./backend-webapp/app.jar

docker run -dt --name 'backend-webapp' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-vagrant/files/dockerfiles/backend/backend-webapp:/app backendimage
docker run -dt --name 'service-registry' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-vagrant/files/dockerfiles/backend/service-registry:/app backendimage
docker run -dt --name 'register-service' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-vagrant/files/dockerfiles/backend/register-service:/app backendimage
docker run -dt --name 'user-service' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-vagrant/files/dockerfiles/backend/user-service:/app backendimage
docker run -dt --name 'dog-service' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-vagrant/files/dockerfiles/backend/dog-service:/app backendimage

