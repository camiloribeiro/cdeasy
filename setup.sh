docker-compose stop
docker-compose rm -v --force
docker-compose build jenkins
docker-compose up -d
