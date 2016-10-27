#!/bin/bash

docker run -dt --name 'frontend-webapp' --net="host" --cap-add SYS_PTRACE -v /project/codecamp-2016-webapp/codecamp-2016-frontend-webapp:/usr/src/app frontend-webapp

