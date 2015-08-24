job("promote_rpm_to_stage") {

  deliveryPipelineConfiguration('Stage', 'Promote RPM to stage')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

  publishers {
    downstreamParameterized {
      trigger("deploy_to_stage", 'SUCCESS', true, null) {
        currentBuild()
      }
    }
  }

}

