#!/usr/bin/env bash

# Not for running on your local machine, writes configuration to home directory

echo "> Setting Artifactory credentials in ~/.gradle/gradle.properties"
mkdir -p ~/.gradle
rm -rf ~/.gradle/gradle.properties
cat >~/.gradle/gradle.properties <<-EOF
ARTIFACTORY_USER=${ARTIFACTORY_USER}
ARTIFACTORY_PASSWORD=${ARTIFACTORY_PASSWORD}
EOF
