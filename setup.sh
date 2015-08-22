docker-compose stop
docker-compose rm -v --force

if [ "$(uname)" == "Darwin" ]; then
  VBoxManage controlvm docker natpf1 delete "jenkins" &>/dev/null
  VBoxManage controlvm docker natpf1 delete "agentserver" &>/dev/null
  VBoxManage controlvm docker natpf1 "jenkins,tcp,127.0.0.1,8080,,8080" &>/dev/null
  VBoxManage controlvm docker natpf1 "agentserver,tcp,127.0.0.1,4243,,4243" &>/dev/null
fi

docker-compose build jenkins 
docker-compose up -d
