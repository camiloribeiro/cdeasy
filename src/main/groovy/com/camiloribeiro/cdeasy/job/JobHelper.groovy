package com.camiloribeiro.cdeasy.job

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
}

