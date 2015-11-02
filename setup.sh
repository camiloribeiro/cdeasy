docker-compose stop
docker-compose rm -v --force

if [ "$(uname)" == "Darwin" ]; then
  VBoxManage controlvm boot2docker-vm natpf1 delete "jenkins" &>/dev/null
  VBoxManage controlvm boot2docker-vm natpf1 "jenkins,tcp,127.0.0.1,8080,,8080" &>/dev/null
fi

docker-compose build jenkins 
docker-compose up -d
