listView('Language agnostic language') {
  description('Language agnostic jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('running.+')
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
