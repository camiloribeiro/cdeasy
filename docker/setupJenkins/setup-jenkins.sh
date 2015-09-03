#!/bin/bash
# From: https://gist.github.com/basmussen/8182784

host=http://jenkins:8080
url=/pluginManager/installNecessaryPlugins

sleep 120

# Download jenkins-cli.jar
curl -o /tmp/jenkins-cli.jar http://jenkins:8080/jnlpJars/jenkins-cli.jar

# Jenkins green balls https://wiki.jenkins-ci.org/display/JENKINS/Green+Balls 
curl -X POST -d '<jenkins><install plugin="greenballs@1.14" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# Jenkins Html publisher https://wiki.jenkins-ci.org/display/JENKINS/HTML+Publisher+Plugin
curl -X POST -d '<jenkins><install plugin="htmlpublisher@1.6" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# Jenkins Job Config History https://wiki.jenkins-ci.org/display/JENKINS/JobConfigHistory+Plugin
curl -X POST -d '<jenkins><install plugin="jobConfigHistory@2.12" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# Jenkins Build Pipeline plugin https://wiki.jenkins-ci.org/display/JENKINS/Build+Pipeline+Plugin
curl -X POST -d '<jenkins><install plugin="build-pipeline-plugin@1.4.7" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# Jenkins Parametrized trigger https://wiki.jenkins-ci.org/display/JENKINS/Parameterized+Trigger+Plugin
curl -X POST -d '<jenkins><install plugin="parameterized-trigger@2.28" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# Jenkins Join trigger plugin https://wiki.jenkins-ci.org/display/JENKINS/Join+Plugin
curl -X POST -d '<jenkins><install plugin="join@1.16" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# jenkis git plugin https://wiki.jenkins-ci.org/display/JENKINS/Git+Plugin
curl -X POST -d '<jenkins><install plugin="git@2.4.0" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# jenkis job dsl plugin https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin
curl -X POST -d '<jenkins><install plugin="job-dsl@1.37" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20

# jenkis docker-plugin https://wiki.jenkins-ci.org/display/JENKINS/Docker+Plugin 
curl -X POST -d '<jenkins><install plugin="docker-plugin@0.13.0" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 20 

# Jenkins workflow aggregator https://wiki.jenkins-ci.org/display/JENKINS/Workflow+Plugin
curl -X POST -d '<jenkins><install plugin="workflow-aggregator@1.10" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 10

# jenkis Delivery Pipeline Plugin https://wiki.jenkins-ci.org/display/JENKINS/Delivery+Pipeline+Plugin
curl -X POST -d '<jenkins><install plugin="delivery-pipeline-plugin@0.9.7" /></jenkins>' --header 'Content-Type: text/xml' $host$url
sleep 10

# wait 20 sec
sleep 100

# jenkins safe restart
curl -X POST $host/safeRestart

# wait 20 sec
sleep 50

java -jar /tmp/jenkins-cli.jar -noCertificateCheck -noKeyAuth -s http://jenkins:8080 groovy /tmp/seed.groovy
