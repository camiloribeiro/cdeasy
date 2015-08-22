deliveryPipelineView('Dummy Pipeline Example') {
  pipelineInstances(5)
    showAggregatedPipeline()
    columns(1)
    sorting(Sorting.TITLE)
    updateInterval(60)
    enableManualTriggers(true)
    showAvatars()
    showChangeLog(true)
    pipelines {
      component('Dummy Pipeline Example', 'unit_test')
    }
}
