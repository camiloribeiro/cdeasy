service docker start
nohup /usr/bin/docker -d  --selinux-enabled -H tcp://0.0.0.0:4243 -H unix:///var/run/docker.sock  > /dev/null 2>&1 &
sleep 3
docker pull evarga/jenkins-slave
tail -f /dev/null
