FROM jenkins

USER root
RUN apt-get update -qq && apt-get install -qqy \
    apt-transport-https \
    ca-certificates \
    curl \
    wget \
    lxc \
    iptables

RUN wget -qO- https://get.docker.com/ | sh

RUN curl -L https://github.com/docker/compose/releases/download/1.4.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY start.sh /tmp/start.sh
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

RUN touch /var/run/docker.sock

ENTRYPOINT ["/bin/bash", "-c", "/tmp/start.sh"]
