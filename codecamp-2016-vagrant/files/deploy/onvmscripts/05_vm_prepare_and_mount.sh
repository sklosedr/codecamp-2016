#!/bin/bash
. /vagrant/files/deploy/vagrant.conf # source config file
echo -n "Preparing and mounting disks..."

for i in ${VAGRANT_DISKS[@]}; do
drive=$(echo ${i} | cut -d : -f1)
mp=$(echo ${i} | cut -d : -f2)
	if [[ "${1}" == *[0-9] ]]; then
	  echo "Device must not end with a number!"
	  exit 1
	else
		filsystem=$(parted ${drive} print | grep primary | awk '{ print $5 }')
		if [[ {$filesystem} != "ext4" ]]; then
		  parted -s -a optimal ${drive} mklabel gpt -- mkpart primary ext4 1 '-1' \
		  && mkfs -t ext4 ${drive}1
		fi
		if ! [ -d ${mp} ]; then mkdir ${mp}; fi \
		&& mount ${drive}1 ${mp}
	fi
done
