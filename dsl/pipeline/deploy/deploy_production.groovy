job("deploy_to_production") {

  deliveryPipelineConfiguration('Production', 'Deploy to Production')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}

