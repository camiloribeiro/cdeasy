deliveryPipelineView('Dummy Pipeline Example') {
  pipelineInstances(5)
    showAggregatedPipeline()
    columns(2)
    sorting(Sorting.TITLE)
    updateInterval(60)
    enableManualTriggers(true)
    showAvatars()
    showChangeLog()
    pipelines {
      component('Dummy Pipeline Example', 'unit_test')
    }
}
