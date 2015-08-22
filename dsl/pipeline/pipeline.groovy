deliveryPipelineView('Dummy Pipeline Example') {
  pipelineInstances(5)
    columns(1)
    sorting(Sorting.TITLE)
    updateInterval(10)
    enableManualTriggers(true)
    showAvatars()
    showChangeLog(true)
    pipelines {
      component('Dummy Pipeline Example', 'unit_test')
    }
}
