job("deploy_to_stage") {

  deliveryPipelineConfiguration('Stage', 'Deploy to Stage')

  triggers {
    scm 'H/5 * * * *'
  }

  steps {
    shell 'true'
  }

}

