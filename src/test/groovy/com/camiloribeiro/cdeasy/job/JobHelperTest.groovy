package com.camiloribeiro.cdeasy.view

import com.camiloribeiro.cdeasy.job.JobHelper
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.JobParent
import javaposse.jobdsl.dsl.MemoryJobManagement
import spock.lang.*

@Unroll
class JobHelperTest extends Specification {

    JobParent createJobParent() {
        JobParent jp = new JobParent() {
            @Override
            Object run() {
                return null
            }
        }
        JobManagement jm = new MemoryJobManagement()
        jp.setJm(jm)
        jp
    }

    def "Should create a job"() {
        when:
        def Job newJob = JobHelper.createJob(createJobParent(), "foo")

        then:
        newJob.name == "foo"
    }

    def "Should add a shell command to a existing job"() {
        given:
        def Job newJob = JobHelper.createJob(createJobParent(), "foo")

        when:
        newJob = JobHelper.addStep(newJob, "echo 'shell'")

        then:
        newJob.node.builders.toString().contains("echo 'shell'")
    }
}

