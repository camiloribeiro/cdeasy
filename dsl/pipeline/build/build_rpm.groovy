job("build_rpm") {

  deliveryPipelineConfiguration('Build', 'Build RPM')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

  publishers {
    downstreamParameterized {
      trigger("promote_rpm_to_dev", "SUCCESS") 
    }
  }

}
