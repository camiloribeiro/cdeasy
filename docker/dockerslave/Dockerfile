FROM evarga/jenkins-slave

RUN apt-get update && \
    apt-get install -y curl

ADD start.sh /tmp/start.sh
ENTRYPOINT ["/bin/bash", "-c", "/tmp/start.sh"]
