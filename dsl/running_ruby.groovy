job("Running Ruby with Docker") {
  scm {
    github "https://github.com/camiloribeiro/icecream.git"
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull ruby'
    shell 'docker run -v $WORKSPACE/:/icecream -w /icecream ruby bundle && rake'
  }
}

