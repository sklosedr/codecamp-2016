#!/bin/bash
. /vagrant/files/deploy/vagrant.conf # source config file

if ! [ -e /home/${VAGRANT_USER}/.ssh ]; then # create .ssh dir if missing
  mkdir -p /home/${VAGRANT_USER}/.ssh
fi

# create authorized keys and inject stuff
touch /home/${VAGRANT_USER}/.ssh/authorized_keys
for i in /vagrant/files/deploy/sshkeys/*; do
  echo "Injecting ssh key: ${i}"
  cat ${i} >> /home/${VAGRANT_USER}/.ssh/authorized_keys
  if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; else echo "OK!"; fi
done

echo "Setting permisisons..." # set final permisisons so ssh accepts the keys
chown ${VAGRANT_USER}:${VAGRANT_USER} /home/${VAGRANT_USER}/.ssh
if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; fi
chmod 750 /home/${VAGRANT_USER}/.ssh
if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; fi
chmod 640 /home/${VAGRANT_USER}/.ssh/authorized_keys
if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; else echo "OK!"; fi
echo "SSH provisioning completed!"
exit 0