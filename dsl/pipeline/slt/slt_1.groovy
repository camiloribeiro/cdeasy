job("service_level_test_1") {

  deliverypipelineconfiguration('api test', 'service level test 1')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}
