job("unit_test") {

  deliveryPipelineConfiguration('Build', 'Unit tests')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

  publishers {
    downstreamParameterized {
      trigger("code_analysis", "SUCCESS") 
    }
  }

}

