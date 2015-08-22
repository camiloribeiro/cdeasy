job("pen_test") {

  deliveryPipelineConfiguration('Security', 'Penetration Tests')

  triggers {
    scm 'H/5 * * * *'
  }
  
  steps {
    shell 'true'
  }

}

