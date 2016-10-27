#!/bin/bash
echo "Reading configuration..."
. /vagrant/files/deploy/vagrant.conf # source config file
if [ $? -gt 0 ]; then echo " FAIL!" && exit 1; else echo "OK!"; fi

SCRIPARR=($(ls -Al ${VAGRANT_SCRIPTSDIR%*/}/*.sh | awk '{print $9}' | grep -v 00_)) # read scripts to array
echo "Scripts found: ${SCRIPARR[@]}"

for i in ${SCRIPARR[@]}; do
echo "===========================================================
    Running: ${i}
  "
  ${i}
done
echo "
Provisioning complete - may the force be with you!
          _________
          III| |III
        IIIII| |IIIII
       IIIIII| |IIIIII
       IIIIII| |IIIIII
      IIIIIII| |IIIIIII
      IIIIIII\ /IIIIIII
     II (___)| |(___) II
    II  \    /D\    /  II
   II  \ \  /| |\  / /  II
  II    \_\/|| ||\/_/    II
 II     / O-------O \     II
II_____/   \|||||/   \_____II
      /               \
      |_______________|
"
exit 0