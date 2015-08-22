job("unit_test") {

  deliveryPipelineConfiguration('Build', 'Unit tests')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

  publishers {
    downstreamParameterized {
      trigger("code_analysis", 'SUCCESS', true, null) {
        currentBuild()
      }
    }
  }
}

