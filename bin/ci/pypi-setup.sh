#!/usr/bin/env bash

# Not for running on your local machine, writes configuration to home directory

echo "> Setting Sanctum Labs package index in ~/.pip/pip.conf"
mkdir -p ~/.pip/
echo -e "[global]\nindex-url = $PIP_INDEX_URL" >~/.pip/pip.conf