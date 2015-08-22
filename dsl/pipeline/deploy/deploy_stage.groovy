job("deploy_to_stage") {

  deliveryPipelineConfiguration('Stage', 'Deploy to Stage')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

  publishers {
    downstreamParameterized {
      trigger("e2e_test", 'SUCCESS', true, null) {
        currentBuild()
      }
    }
  }

  configure { project -> project / publishers << 'join.JoinTrigger' {
    'joinProjects'{}
    'joinPublishers' {
      'hudson.plugins.parameterizedtrigger.BuildTrigger' {
        'configs' {
          'hudson.plugins.parameterizedtrigger.BuildTriggerConfig' {
            projects('promote_rpm_to_production')
              condition('SUCCESS')
              triggerWithNoParameters('true')
          }
        }
      }
    }
    evenIfDownstreamUnstable('false')}
  }

}

