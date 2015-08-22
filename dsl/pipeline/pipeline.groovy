deliveryPipelineView('dummy_pipeline_example') {
  pipelineInstances(5)
    showAggregatedPipeline()
    columns(2)
    sorting(Sorting.TITLE)
    updateInterval(60)
    enableManualTriggers()
    showAvatars()
    showChangeLog()
    pipelines {
      component('Dummy Pipeline Example', 'unit_test')
    }
}
