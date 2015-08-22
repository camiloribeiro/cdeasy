job("pen_test") {

  deliveryPipelineConfiguration('Security', 'Penetration Tests')

  triggers {
    scm 'H/5 * * * *'
  }
  
  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

}

