#!/bin/bash
apt-get update
apt-get -y upgrade && apt-get -y distupgrade
apt-get -y install curl grep htop nano ntp unzip vim wget cifs-utils linux-generic
apt-get -y autoremove