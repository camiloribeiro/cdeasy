job("unit_test") {

  deliveryPipelineConfiguration('Build', 'Unit tests')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

  publishers {
    downstreamParameterized {
      trigger("code_analysis", "SUCCESS", false)  
    }
  }

}

