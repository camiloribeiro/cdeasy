listView('Service Level Tests') {
  description('All Service Level Tests jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('service_level_test.+')
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
