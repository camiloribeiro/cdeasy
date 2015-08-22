listView('Deploys') {
  description('All RPM promotion jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex('promote_rpm.+')
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
