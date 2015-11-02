job("running_java_with_docker") {

  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/camiloribeiro/cucumber-gradle-parallel.git")
      }
    }
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
