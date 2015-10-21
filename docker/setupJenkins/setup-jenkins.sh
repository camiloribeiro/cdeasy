#!/bin/bash

sleep 30
java -jar /tmp/jenkins-cli.jar -noCertificateCheck -noKeyAuth -s http://jenkins:8080 groovy /tmp/seed.groovy
