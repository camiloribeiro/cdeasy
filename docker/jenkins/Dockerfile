FROM jenkins

USER root
RUN apt-get update -qq && apt-get install -qqy \
    apt-transport-https \
    ca-certificates \
    curl \
    wget \
    lxc \
    iptables \
    dos2unix

RUN wget -qO- https://get.docker.com/ | sh

RUN curl -L https://github.com/docker/compose/releases/download/1.4.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN dos2unix /usr/share/jenkins/plugins.txt

COPY start.sh /tmp/start.sh
RUN dos2unix /tmp/start.sh
RUN chmod +x /tmp/start.sh

RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

COPY seed.groovy /usr/share/jenkins/ref/init.groovy.d/seed.groovy

RUN touch /var/run/docker.sock

ENTRYPOINT ["/bin/bash", "-c", "/tmp/start.sh"]
