node {
  stage 'Build'
    parallel (
      "Unit Tests and Linting": {
        echo 'Here goes the unit level tests'
        sh 'sleep 2s'
        echo 'Here goes the code linting'
        sh 'sleep 5s'
      },
      "Packing and publishing": {
        echo 'Here goes the packing'
        sh 'sleep 2s'
        echo 'Here goes the publishing'
        sh 'sleep 2s'
      }
    )

  stage 'Functional Test'
    parallel (
      "Running api tests for market 1": {
        echo 'Here goes the api tests for the first market'
        sh "sleep 1s"
      },
      "Running api tests for market 2": {
        echo 'Here goes the api tests for the second market'
        sh "sleep 2s"
      },
      "Running UI Tests": {
        echo 'Here goes the tests for the gui'
        sh "sleep 7s"
      }
   )

  stage 'Deploy to Integration'
    echo 'Here goes some deployment script'
    sh "sleep 4s"

  stage 'Integration tests'
    parallel (
      "Load Tests": {
        echo 'Here goes the performance tests'
        sh "sleep 5s"
      },
      "Integration Tests": {
        echo 'Here goes the performance tests'
        sh "sleep 3s"
      },
      "Security Tests": {
        echo 'Here goes the Secrurity tests'
        sh "sleep 2s"
      }
    )
        
  stage 'Canary release Phase 1'
    echo 'Here goes a deploy to a controled isolated server'
    sh "sleep 2s"
              
  stage 'Canary release Phase 1: Check'
    parallel (
      "Checking ordinary production": {
        echo 'Here goes a set of production checks to production'
        sh "sleep 4s"
      },
      "Checking production with feature toggle": {
        echo 'Here goes a set of production with the new feature deployed'
        sh "sleep 4s"
      },
      "Checking monitoring system status": {
        echo 'Here goes a set of production checks to production'
        sh "sleep 4s"
      }
    )
        
  stage 'Canary release Phase 2'
    echo 'Here goes the switch off feature tougle'
    sh "sleep 4s"
    
  stage 'Canary release Phase 2: Check'
    parallel (
      "Checking ordinary production": {
        echo 'Here goes a set of production checks to production'
        sh "sleep 4s"
      },
      "Checking monitoring system status": {
        echo 'Here goes a set of production checks to production'
        sh "sleep 4s"
      }
    )
            
  stage 'Deployment complete'
    echo 'Send emails and be happy to have something deployed to production'
}
