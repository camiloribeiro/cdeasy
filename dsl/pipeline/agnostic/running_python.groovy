job("running_python_with_docker") {
  
  scm {
    git {
      remote {
        name ("origin")
        url ("https://github.com/cgoldberg/python-unittest-tutorial.git")
      }
      branch('master')
    }
  }

  steps {
    shell 'docker pull python:latest'
    shell 'docker run -v $WORKSPACE/:/python -w /python python python test_simple.py'
  }

}

