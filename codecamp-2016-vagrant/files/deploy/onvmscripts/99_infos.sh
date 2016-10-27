#!/bin/bash

echo "===================================================
    Your interfaces are:"
ifconfig | grep "inet " | grep -o addr:.*
echo "==================================================="