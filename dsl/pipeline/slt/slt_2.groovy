job("service_level_test_2") {

  deliveryPipelineConfiguration('api test', 'service level test 2')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}
