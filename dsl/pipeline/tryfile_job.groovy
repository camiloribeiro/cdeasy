pipelineJob('tryfile_pipeline') {
  definition {
    cps {
      script(readFileFromWorkspace('Tryfile'))
      sandbox()
    }
  }
}
