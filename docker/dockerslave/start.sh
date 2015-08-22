curl -sSL https://get.docker.com/ | sh
curl -L https://github.com/docker/compose/releases/download/1.4.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose

service docker start
/usr/bin/docker -d  --selinux-enabled -H tcp://0.0.0.0:4243 -H unix:///var/run/docker.sock
