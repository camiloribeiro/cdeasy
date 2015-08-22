job("load_test") {

  deliveryPipelineConfiguration('Performance', 'Load Test')

  triggers {
    scm 'H/5 * * * *'
  }
 
  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

