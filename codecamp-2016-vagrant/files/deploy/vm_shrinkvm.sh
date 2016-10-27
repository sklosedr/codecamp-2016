#!/bin/bash
sudo dd if=/dev/zero of=/emptyfile bs=1M
sudo rm -rf /emptyfile
