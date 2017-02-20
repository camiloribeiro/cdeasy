import jenkins.model.*;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;
import javaposse.jobdsl.plugin.*;

project = Jenkins.instance.createProject(FreeStyleProject, "seed")

project.getBuildersList().clear()

executeDslScripts = new ExecuteDslScripts()
executeDslScripts.setTargets("dsl/**/*.groovy")
executeDslScripts.setRemovedJobAction(RemovedJobAction.DELETE)
executeDslScripts.setRemovedViewAction(RemovedViewAction.DELETE)
executeDslScripts.setLookupStrategy(LookupStrategy.JENKINS_ROOT)
executeDslScripts.setAdditionalClasspath("src/main/groovy")

project.getBuildersList().add(executeDslScripts)

project.save()
