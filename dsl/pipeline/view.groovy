listView('Deploys') {
  description('All Deploy jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('.+deploy.+')
    }
  jobFilters {
    status {
      status(Status.UNSTABLE)
    }
  }
  columns {
    status()
      weather()
      name()
      lastSuccess()
      lastFailure()
      lastDuration()
      buildButton()
  }
}
