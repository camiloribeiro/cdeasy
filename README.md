cdeasy - Continuous Delivery Made Easy
========================================
   
                       ##        .
                 ## ## ##       ==            Example of how docker and automation can help you
              ## ## ## ##      ===            to imporove your continuous delivery process.
          /""""""""""""""""\___/ ===
     ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~   This is not a production ready framework or template
          \______ o          __/              to start using in your current project. Please take
            \    \        __/                 this as an inspiration to improve or implement a
             \____\______/                    Continuous Develivey pipeline for your own needs :)
                             <3 Docker <3
   
   
Setting up the environment
===========================

Before clonning this repository you you need docker, docker-compose and git in your machine. 
If you want to try new stuff, than a IDE of your preference could be needed. In any case, it should be able to be edited using only VIM or any other favority text editor

OSX
----
 
If you are new to docker and you want to get some abstraction on the docker machine, please install boot2docker:

    - https://docs.docker.com/installation/mac/

You will also need to install docker-compose:

    - curl -L https://github.com/docker/compose/releases/download/1.3.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
    - chmod +x /usr/local/bin/docker-compose 

For more info please check: http://docs.docker.com/compose/install/

Linux
------
Please check the best way to install in your distribution on http://docs.docker.com/installation/ubuntulinux/

You will also need to install docker-compose:

    - curl -L https://github.com/docker/compose/releases/download/1.3.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
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
      - ./setup

It is all set!

You can access localhost:8080 (or whatever docker host ip you use) and it should be available. 

LICENSE
=======

Copyright 2015 - Camilo Ribeiro camilo@camiloribeiro.com

This file is part of CDEASY.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
