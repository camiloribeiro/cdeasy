job("promote_rpm_to_production") {

  deliveryPipelineConfiguration('Deploy to Production', 'Promote RPM to production')

  triggers {
    scm 'H/5 * * * *'
  }
  
  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

  publishers {
    buildPipelineTrigger('deploy_to_beta, deploy_to_production')
  }

}
