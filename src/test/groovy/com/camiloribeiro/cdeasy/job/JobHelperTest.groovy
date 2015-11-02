package com.camiloribeiro.cdeasy.view

import com.camiloribeiro.cdeasy.job.JobHelper
import javaposse.jobdsl.dsl.Job

import static com.camiloribeiro.cdeasy.support.Support.BuildConditions.SUCCESS
import spock.lang.*

import static com.camiloribeiro.cdeasy.support.SupportTestHelper.getJobParent

@Unroll
class JobHelperTest extends Specification {

    def "Should create a job"() {
        when:
        def Job newJob = JobHelper.createJob(getJobParent(), "foo")

        then:
        newJob.name == "foo"
    }

    def "Should add shell commands to a existing job"() {
        given:
        def Job newJob = JobHelper.createJob(getJobParent(), "foo")

        when:
        newJob = JobHelper.addStep(newJob, "echo 'shell'")

        then:
        newJob.node.builders.toString().contains("echo 'shell'")

        when:
        newJob = JobHelper.addStep(newJob, "echo 'new'")

        then:
        newJob.node.builders.toString().contains("echo 'shell'")
        newJob.node.builders.toString().contains("echo 'new'")
    }

    def "Should add a git repository to a job"() {
        given:
        def Job newJob = JobHelper.createJob(getJobParent(), "foo")

        when:
        newJob = JobHelper.addGitRepo(newJob, "git@foo.bar", "master")

        then:
        with(newJob.node.scm) {
            it.branches.'hudson.plugins.git.BranchSpec'.name.text() == "master"
            it.userRemoteConfigs.'hudson.plugins.git.UserRemoteConfig'.url.text() == "git@foo.bar"
        }
    }

    def "Should add join trigger"() {
        given:
        def Job newJob = JobHelper.createJob(getJobParent(), "foo")

        when:
        newJob = JobHelper.addJoinTrigger(newJob, ["jobA", "jobB", "jobC"])

        then:
        with(newJob.node.'publishers'[0].'join.JoinTrigger'[0].'joinPublishers'[0].'hudson.plugins.parameterizedtrigger.BuildTrigger'[0].'configs'[0].'hudson.plugins.parameterizedtrigger.BuildTriggerConfig'[0]) {
            it.'projects'[0].value() == "jobA, jobB, jobC"
        }
    }

    def "Should add parametrized build"() {
        given:
        def Job newJob = JobHelper.createJob(getJobParent(), "foo")

        when:
        newJob = JobHelper.addDownstreamParameterized(newJob, ["jobA", "jobB", "jobC"], SUCCESS)

        then:
        with(newJob.node.'publishers'[0].'hudson.plugins.parameterizedtrigger.BuildTrigger'[0].'configs'[0].'hudson.plugins.parameterizedtrigger.BuildTriggerConfig'[0]) {
            it.'projects'[0].value() == "jobA, jobB, jobC"
            it.'condition'[0].value() == SUCCESS.toString()
        }
    }
}
