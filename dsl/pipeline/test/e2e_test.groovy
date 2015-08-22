job("e2e_test") {

  deliveryPipelineConfiguration('Stage Testing', 'End to end Test')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}

