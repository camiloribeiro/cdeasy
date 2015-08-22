job("stress_test") {

  deliveryPipelineConfiguration('Performance', 'Stress Test')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}

