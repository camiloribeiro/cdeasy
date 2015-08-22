job("deploy_to_beta") {

  deliveryPipelineConfiguration('Beta', 'Deploy to Beta')

  triggers {
    scm 'H/5 * * * *'
  }
  
  steps {
    shell 'sleep $[ ( $RANDOM % 10 )  + 1 ]s'
  }

  publishers {
    downstreamParameterized {
      trigger("deploy_to_production", "SUCCESS") 
    }
  }

}

