#!/bin/bash
. /vagrant/files/deploy/vagrant.conf # source config file

sed 's/iface eth1 .*/iface eth1 inet dhcp/g' -i /etc/network/interfaces # set eth1 to dhcp
sed -e '/address 192.168.56.254/,+1d' -i /etc/network/interfaces # remove address and subnet
ifdown eth1 > /dev/null 2>&1
ifup eth1 > /dev/null 2>&1
sleep 1
ifdown eth1 > /dev/null 2>&1
ifup eth1 > /dev/null 2>&1
