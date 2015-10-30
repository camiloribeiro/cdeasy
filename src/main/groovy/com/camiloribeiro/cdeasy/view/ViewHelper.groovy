package com.camiloribeiro.cdeasy.view

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.JobParent
import javaposse.jobdsl.dsl.MemoryJobManagement

class ViewHelper {

    static JobManagement jm = new MemoryJobManagement()
    static JobParent jp = new JobParent() {
        @Override
        Object run() {
            return null
        }
    }

    def static addView(String viewName, String viewDescription, String viewegex) {
        jp.listView(viewName) {
            setName(viewName)
            description(viewDescription)
            filterBuildQueue()
            filterExecutors()
            jobs {
                regex(viewegex)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
            }
        }
    }
}

