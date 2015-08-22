job("e2e_test") {

  deliveryPipelineConfiguration('Stage', 'End to end Test')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

}

