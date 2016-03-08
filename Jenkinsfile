node {
  stage 'First Stage'
    sh 'ls'
    echo 'just an example'

    stage 'Second 2'
    node('master') {
      sh 'pwd'
    }

  stage 'Third 2'
    sh 'ls -la'
}
