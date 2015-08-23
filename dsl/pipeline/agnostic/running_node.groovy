job("running_node_with_docker") {
  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/conancat/node-test-examples.git")
      }
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull node:latest'
    shell 'docker run -v $WORKSPACE/:/node -w /node node:latest npm install mocha -g'
  }
}

