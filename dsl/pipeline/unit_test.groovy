job("Running_Ruby_with_Docker") {
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'true'
  }
}

