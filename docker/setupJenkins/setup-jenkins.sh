#!/bin/bash
# From: https://gist.github.com/basmussen/8182784

host=http://jenkins:8080
url=/pluginManager/installNecessaryPlugins

sleep 50

# Download jenkins-cli.jar
curl -o /tmp/jenkins-cli.jar http://jenkins:8080/jnlpJars/jenkins-cli.jar

# jenkis git plugin https://wiki.jenkins-ci.org/display/JENKINS/Git+Plugin
curl -X POST -d '<jenkins><install plugin="git@2.4.0" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 2

# jenkis job dls plugin https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin
curl -X POST -d '<jenkins><install plugin="job-dsl@1.37" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 2

# jenkis docker-plugin https://wiki.jenkins-ci.org/display/JENKINS/Docker+Plugin 
curl -X POST -d '<jenkins><install plugin="docker-plugin@0.11.0" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 2

# jenkis Delivery Pipeline Plugin https://wiki.jenkins-ci.org/display/JENKINS/Delivery+Pipeline+Plugin
curl -X POST -d '<jenkins><install plugin="delivery-pipeline-plugin@0.9.5" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 2

# wait 20 sec
sleep 30

# jenkins safe restart
curl -X POST $host/safeRestart

# wait 20 sec
sleep 20

java -jar /tmp/jenkins-cli.jar -noCertificateCheck -noKeyAuth -s http://jenkins:8080 groovy /tmp/seed.groovy
