job("running_Java_with_Docker") {
  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/camiloribeiro/cucumber-gradle-parallel.git")
      }
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull niaquinto/gradle:2.5'
    shell 'docker run -v $WORKSPACE/:/gradle -w /gradle niaquinto/gradle:2.5 clean build runInParallel'
  }
  publishers {
    publishHtml {
      report('build/reports/cucumber') {
        reportName('Cucumber Report')
        reportFiles('feature-overview.html')
        keepAll()
        allowMissing()
        alwaysLinkToLastBuild()
      }
    }
  }
}
