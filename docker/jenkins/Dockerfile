FROM jenkinsci/jenkins:2.19

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
RUN touch /var/run/docker.sock

RUN curl -L https://github.com/docker/compose/releases/download/1.7.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose
COPY start.sh /tmp/start.sh

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN dos2unix /usr/share/jenkins/plugins.txt
RUN dos2unix /tmp/start.sh && chmod +x /tmp/start.sh

RUN mkdir /usr/share/jenkins/ref/plugins
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-commons/1.0-alpha-8/blueocean-commons.hpi -O /usr/share/jenkins/ref/plugins/blueocean-commons.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-dashboard/1.0-alpha-8/blueocean-dashboard.hpi -O /usr/share/jenkins/ref/plugins/blueocean-dashboard.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-events/1.0-alpha-8/blueocean-events.hpi -O /usr/share/jenkins/ref/plugins/blueocean-events.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-personalization/1.0-alpha-8/blueocean-personalization.hpi -O /usr/share/jenkins/ref/plugins/blueocean-personalization.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-rest/1.0-alpha-8/blueocean-rest.hpi -O /usr/share/jenkins/ref/plugins/blueocean-restapi.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-rest-impl/1.0-alpha-8/blueocean-rest-impl.hpi -O /usr/share/jenkins/ref/plugins/blueocean-restimpl.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-web/1.0-alpha-8/blueocean-web.hpi -O /usr/share/jenkins/ref/plugins/blueocean-web.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-config/1.0-alpha-8/blueocean-config.hpi -O /usr/share/jenkins/ref/plugins/blueocean-config.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-pipeline-api-impl/1.0-alpha-8/blueocean-pipeline-api-impl.hpi -O /usr/share/jenkins/ref/plugins/blueocean-pipeline-api-impl.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean-analytics-tools/1.0-alpha-7/blueocean-analytics-tools.hpi -O /usr/share/jenkins/ref/plugins/blueocean-analytics-tools.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/pipeline-rest-api/1.8-beta-1/pipeline-rest-api.hpi -O /usr/share/jenkins/ref/plugins/pipeline-rest-api.hpi
RUN wget http://updates.jenkins-ci.org/download/plugins/blueocean/1.0-alpha-8/blueocean.hpi -O /usr/share/jenkins/ref/plugins/blueocean.hpi
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

COPY seed.groovy /usr/share/jenkins/ref/init.groovy.d/seed.groovy

ENTRYPOINT ["/bin/bash", "-c", "/tmp/start.sh"]
