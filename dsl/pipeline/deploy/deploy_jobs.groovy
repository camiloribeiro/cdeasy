package pipeline.deploy

import com.camiloribeiro.cdeasy.job.JobHelper
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

Job deploy_to_beta = JobHelper.createJob(this as DslFactory, "deploy_to_beta")
JobHelper.addStep(deploy_to_beta, "sleep \$((RANDOM%10+5))")
JobHelper.addDeliveryPipelineConfiguration(deploy_to_beta, 'Beta', 'Deploy to Beta')

Job deploy_to_prod = JobHelper.createJob(this as DslFactory, "deploy_to_prod")
JobHelper.addStep(deploy_to_prod, "sleep \$((RANDOM%10+5))")
JobHelper.addDeliveryPipelineConfiguration(deploy_to_prod, 'Production', 'Deploy to Production')


Job deploy_to_stage = JobHelper.createJob(this as DslFactory, "deploy_to_beta")
JobHelper.addStep(deploy_to_stage, "sleep \$((RANDOM%10+5))")
JobHelper.addDownstreamParameterized(deploy_to_stage, ["promote_rpm_to_production"], "SUCCESS")
JobHelper.addDeliveryPipelineConfiguration(deploy_to_stage, 'Stage', 'Deploy to Stage')
