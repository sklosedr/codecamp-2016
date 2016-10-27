#!/bin/bash
#Installing Docker in VM
apt-get update
#
#get pgp key and certificate
apt-get install apt-transport-https ca-certificates
#
apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
#
#get repos
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" > /etc/apt/sources.list.d/docker.list
apt-get update
#install
apt-get install -y linux-image-extra-$(uname -r) linux-image-extra-virtual
apt-get install -y docker-engine
#
#docker run hello-world