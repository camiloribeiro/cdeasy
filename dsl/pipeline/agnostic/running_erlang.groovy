job("running_erlang_with_docker") {
  scm {
    git {
      remote {
        name('origin')
        url ("https://github.com/ferd/recon.git")
      }
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull correl/erlang:latest'
    shell 'docker run -v $WORKSPACE/:/erlang -w /erlang correl/erlang ./rebar compile'
  }
}

