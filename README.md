CDeasy - Continuous Delivery made easy
========================================

[![Build Status](https://travis-ci.org/camiloribeiro/cdeasy.svg?branch=master)](https://travis-ci.org/camiloribeiro/cdeasy)

   
                       ##        .
                 ## ## ##       ==            Example of how Docker and automation can help you
              ## ## ## ##      ===            to improve your continuous delivery process.
          /""""""""""""""""\___/ ===
     ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~   This is not a production ready framework or template
          \______ o          __/              to start using in your current project. Please take
            \    \        __/                 this as an inspiration to improve or implement a
             \____\______/                    Continuous Delivery pipeline for your own needs :)
                             <3 Docker <3
   


About CDeasy
-----------------
 
Here you will find a set of groovy scripts that use job-dsl plugin for jenkins (https://jenkinsci.github.io/job-dsl-plugin), jenkins itself (https://github.com/jenkinsci/jenkins), groovy and spock for testing (https://github.com/spockframework/spock)

By running this example you will be able to setup a jenkins instance with an example of continuous delivey pipeline in your local computer, all instanciated by one simple click ;)
   
Setting up the environment
===========================

Before clonning this repository you you need docker, docker-compose and git in your machine. 
If you want to try new stuff, than a IDE of your preference could be needed. In any case, it should be able to be edited using only VIM or any other favority text editor

OSX
----
 
If you are new to docker and you want to get some abstraction on the docker machine, please install boot2docker:

    - https://docs.docker.com/installation/mac/

You will also need to install docker-compose:

    - curl -L https://github.com/docker/compose/releases/download/1.4.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
    - chmod +x /usr/local/bin/docker-compose 

For more info please check: http://docs.docker.com/compose/install/

Linux
------
Please check the best way to install in your distribution on http://docs.docker.com/installation/ubuntulinux/

You will also need to install docker-compose:

    - curl -L https://github.com/docker/compose/releases/download/1.4.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
    - chmod +x /usr/local/bin/docker-compose 

For more info please check: http://docs.docker.com/compose/install/ 

Windows
-------
This is the link to install boot2docker on Windows. 

    - https://docs.docker.com/installation/windows/

You will also need to use docker-compose here, but I don't know a simple way to do that :( try googling or check this stackoverflow thread:

    - http://stackoverflow.com/questions/29289785/how-to-install-docker-compose-on-windows

In this repo, in the blog post that will follow it and in the presentations there will not have any other reference to windows environments given my lack of experience with it. 

Please consider using another operating system if you are not able to run the full experience at first, then please adapt it later to windows. 
If you see any improvements that these instructions or scripts could have, please consider to pull request :) Credits will be fully given to you

All the shell script used here will also not work in Windows. No Power shell will be provided in our first release :(

Installing Jenkins, its plugins and seed job
-------------------------------------------

Please note that you will need a fast internet connection and you will need to allocate at least 2 GB RAM to your boot2docker machine. More memory, faster results ;)

For it you just need to run the folling commands:

      - git clone https://github.com/camiloribeiro/cdeasy.git
      - cd cdeasy
      - docker-compose build jenkins 
      - docker-compose up

It is all set!

Copy it and go to your local docker host port 8080 and past the token to start. Since we have installed all the plugins needed to run our pipelines, there is no need to install it in the first step. Just click in the upper right X to close without installing anything.

Remember that now jenkins comes with admin account loged by default. Remember to save the hash provided before to use if you need to re logout/restart jenkins and come back later.

The two pipelines
-------------------------------------------

After setting up the environment like shown before, you will run the seed job, just like any other job. 
Please note that you can change the files as you please and rerun the seed job to see the effects, since all the files are shareded from your local to a docker container.

The first pipeline will show up when executing the "unit_test" job and looking into the "Dummy Pipeline Example" view. This is the legacy pipeline (and still more flexible than the new one).
The second pipeline (native for jenkins 2) will be shown when running the job "example_pipeline_jenkins2".

Developing and Helping
-----------------

You can help this repo to get better by adding more tests, adding more language agnostic builds, adding new features, writing better documentation or refactoring the code.

If you change the code, you must run the tests locally and make sure it is all green before pushing a pull request. 

      - ./gradlew check

Remember to replace the repo url to your forked repo in the job example_pipeline_jenkins2 (dsl/pipeline/example_alpha_pipeline.groovy)

Have fun!!!

LICENSE
=======

Copyright 2015 - Camilo Ribeiro camilo@camiloribeiro.com

This file is part of CDEASY.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
