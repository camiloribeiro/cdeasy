job("running_Ruby_with_Docker") {
  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/camiloribeiro/RestShifter.git")
      }
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull ruby:latest'
    shell 'docker run -v $WORKSPACE/:/icecream -w /icecream ruby:latest  sh -c \'bundle install && RACK_ENV=test rake\''
  }
}

