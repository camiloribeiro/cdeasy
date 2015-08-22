job("service_level_test_1") {

  deliveryPipelineConfiguration('api test', 'service level test 1')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}
