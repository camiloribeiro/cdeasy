job("Unit_Test") {
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'true'
  }
}

