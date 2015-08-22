job("build_rpm") {

  deliveryPipelineConfiguration('Build', 'Build RPM')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

  publishers {
    downstreamParameterized {
      trigger("promote", "SUCCESS") 
    }
  }

}
