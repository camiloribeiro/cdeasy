job("running_compose_with_docker") {

  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/b00giZm/docker-compose-nodejs-examples.git")
      }
    }
  }

  steps {
    shell 'cd 02-express-redis-nodemon && docker-compose up -d'
    shell 'sleep 5 && curl http://localhost:3030'
  }

}

