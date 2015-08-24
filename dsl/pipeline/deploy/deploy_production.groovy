job("deploy_to_production") {

  deliveryPipelineConfiguration('Production', 'Deploy to Production')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

