job("promote_rpm_to_dev") {

  deliveryPipelineConfiguration('Build', 'Promote RPM to dev')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}

