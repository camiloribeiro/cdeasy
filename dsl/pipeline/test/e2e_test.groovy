job("e2e_test") {

  deliveryPipelineConfiguration('Stage Testing', 'End to end Test')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

