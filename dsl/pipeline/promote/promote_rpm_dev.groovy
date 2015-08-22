job("promote_rpm_to_dev") {

  deliveryPipelineConfiguration('Build', 'Promote RPM to dev')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

  publishers {
    downstreamParameterized {
      trigger("service_level_test_1,service_level_test_2,pen_test,stress_test,load_test", "SUCCESS") 
    }
  }
  
  configure { project -> project / publishers << 'join.JoinTrigger' {
    'joinProjects'{}
    'joinPublishers' {
      'hudson.plugins.parameterizedtrigger.BuildTrigger' {
        'configs' {
          'hudson.plugins.parameterizedtrigger.BuildTriggerConfig' {
            projects('promote_rpm_to_stage')
              condition('SUCCESS')
              triggerWithNoParameters('true')
          }
        }
      }
    }
    evenIfDownstreamUnstable('false')}
  }

}

