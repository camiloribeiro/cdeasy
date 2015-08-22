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
      trigger("promote_rpm_to_dev", 'SUCCESS', true, null) {
        currentBuild()
      }
    }
  }

}
