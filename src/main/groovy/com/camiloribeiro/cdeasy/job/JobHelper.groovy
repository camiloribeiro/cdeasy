package com.camiloribeiro.cdeasy.job

import com.camiloribeiro.cdeasy.support.Support
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

class JobHelper {

    public static Job createJob(DslFactory dslFactory, String name) {
        def Job job = dslFactory.job(name)
        job
    }

    public static Job addStep(Job job, String command) {
        job.steps() {
            shell(command)
        }
        job
    }

    public static Job addGitRepo(Job job, String repo, String repoBranch) {
        job.scm {
            git {
                remote {
                    name('origin')
                    url(repo)
                }
                branch(repoBranch)
            }
        }
        job
    }

    static Job addJoinTrigger(Job job, ArrayList<String> jobs) {
        job.publishers {
            joinTrigger {
                publishers {
                    downstreamParameterized {
                        trigger(jobs.join(", ")) {
                            currentBuild()
                        }
                    }
                }
            }
        }
        job
    }

    static Job addDownstreamParameterized(Job job, ArrayList<String> jobs, Support.BuildConditions buildConditions) {
        job.publishers {
            downstreamParameterized {
                trigger(jobs.join(", ")) {
                    condition(buildConditions.toString())
                    parameters {
                        currentBuild()
                    }
                }
            }
        }
        job
    }

    static Job addDeliveryPipelineConfiguration(Job job, String buildStage, String stepName) {
        job.deliveryPipelineConfiguration(buildStage, stepName)
        job
    }
}

