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
      trigger("Code_analysis", "SUCCESS") { 
          predefinedProp('ORIGINAL_BUILD_NUMBER', originalBuildNumber)
      }
    }
  }

}

