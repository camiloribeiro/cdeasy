job("promote_rpm_to_dev") {

  deliveryPipelineConfiguration('Build', 'Promote RPM to dev')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

  publishers {
    downstreamParameterized {
      trigger("service_level_test_1,service_level_test_2,pen_test,stress_test,load_test", "SUCCESS") 
    }
  }

}

