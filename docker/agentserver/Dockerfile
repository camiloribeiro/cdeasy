FROM jpetazzo/dind

RUN apt-get update -qq && apt-get install -qqy \
    openssh-server && \
    mkdir /var/run/sshd && \
    apt-get install -y openjdk-6-jdk 

RUN groupadd jenkins && \
    useradd -g jenkins jenkins && \
    /usr/sbin/sshd

ADD start.sh /tmp/start.sh
#RUN service docker start &&  docker pull jpetazzo/dind
#ENTRYPOINT ["/usr/bin/docker", "-d", "--selinux-enabled", "-H", "tcp://0.0.0.0:4243"]

ENTRYPOINT ["/bin/bash", "-c" ,"/tmp/start.sh"]
