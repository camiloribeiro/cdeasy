job("deploy_to_beta") {

  deliveryPipelineConfiguration('Beta', 'Deploy to Beta')

  steps {
    shell 'sleep $((RANDOM%10+5))'
  }

}

