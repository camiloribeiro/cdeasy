package pipeline.build

import com.camiloribeiro.cdeasy.job.JobHelper
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job
import static com.camiloribeiro.cdeasy.support.Support.BuildConditions.SUCCESS

Job code_analisys = JobHelper.createJob(this as DslFactory, "code_analysis")
JobHelper.addStep(code_analisys, "sleep \$((RANDOM%10+5))")
JobHelper.addDownstreamParameterized(code_analisys, ["build_rpm"], SUCCESS)
JobHelper.addDeliveryPipelineConfiguration(code_analisys, 'Build', 'Code Analysis')

Job build_rpm = JobHelper.createJob(this as DslFactory, "build_rpm")
JobHelper.addStep(build_rpm, "sleep \$((RANDOM%10+5))")
JobHelper.addDownstreamParameterized(build_rpm, ["promote_rpm_to_dev"], SUCCESS)
JobHelper.addDeliveryPipelineConfiguration(build_rpm, 'Build', 'Build RPM')
