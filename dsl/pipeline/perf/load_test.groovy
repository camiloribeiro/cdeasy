job("load_test") {

  deliveryPipelineConfiguration('Performance', 'Load Test')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

