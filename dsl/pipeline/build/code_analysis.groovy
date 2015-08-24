job("code_analysis") {

  deliveryPipelineConfiguration('Build', 'Code Analysis')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

  publishers {
    downstreamParameterized {
      trigger("build_rpm", 'SUCCESS', true, null) {
        currentBuild()
      }
    }
  }

}

