#!/bin/bash
cd /project/codecamp-2016-vagrant/files/dockerfiles/backend/

./dockerbuild.sh
./dockerrun.sh

cd /project/codecamp-2016-vagrant/files/dockerfiles/frontend/

./dockerbuild.sh
./dockerrun.sh