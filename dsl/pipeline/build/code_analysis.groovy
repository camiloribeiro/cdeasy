job("code_analysis") {

  deliveryPipelineConfiguration('Build', 'Code Analysis')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

  publishers {
    downstreamParameterized {
      trigger("build_rpm", "SUCCESS") 
    }
  }

}

