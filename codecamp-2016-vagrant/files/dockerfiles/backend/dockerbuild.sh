#!/bin/bash

docker build --build-arg PORT=8080-8100 -t 'backendimage' .