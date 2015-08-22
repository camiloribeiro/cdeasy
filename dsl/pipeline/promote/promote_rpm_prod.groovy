job("promote_rpm_to_production") {

  deliveryPipelineConfiguration('Deploy to Production', 'Promote RPM to production')

  triggers {
    scm 'H/5 * * * *'
  }
  
  steps {
    shell 'true'
  }

}
