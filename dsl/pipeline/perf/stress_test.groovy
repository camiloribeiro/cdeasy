job("stress_test") {

  deliveryPipelineConfiguration('Performance', 'Stress Test')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

