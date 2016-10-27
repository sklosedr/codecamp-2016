#!/bin/bash
. /vagrant/files/deploy/vagrant.conf # source config file

if  [ $(getent passwd ${VAGRANT_USER}) ]; then
  echo "User ${VAGRANT_USER} already exists!"
  exit 0
else
  echo "Adding user ${VAGRANT_USER}"
  useradd -mU -s /bin/bash ${VAGRANT_USER}
  if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; else echo "OK!"; fi
fi