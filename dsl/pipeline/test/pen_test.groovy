job("pen_test") {

  deliveryPipelineConfiguration('Security', 'Penetration Tests')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

