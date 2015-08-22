job("code_analysis") {

  deliveryPipelineConfiguration('Build', 'Code Analysis')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

  publishers {
    downstreamParameterized {
      trigger("build_rpm_to_dev", "SUCCESS") 
    }
  }

}

