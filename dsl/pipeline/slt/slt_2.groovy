job("service_level_test_2") {

  deliveryPipelineConfiguration('api test', 'service level test 2')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}
