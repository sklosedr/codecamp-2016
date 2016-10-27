#!/bin/bash
. /vagrant/files/deploy/vagrant.conf # source config file

# adjusting timezones
echo -n "Adjusting timezone..."
echo "Europe/Berlin" > /etc/timezone
dpkg-reconfigure -f noninteractive tzdata > /dev/null 2>&1

# console mods
echo -n "Setting console colors..."
sed -i 's/^#\(force_color_prompt\)/\1/g' /root/.bashrc /etc/skel/.bashrc

# nano mods
echo -n "Setting nano syntax highlights..."
sed 's/\\.sh\$/\\.(sh|conf)\$/g' -i /usr/share/nano/sh.nanorc
find /usr/share/nano/*.nanorc -exec echo -e "include {}" \; | tee ~/.nanorc /etc/skel/.nanorc >/dev/nul