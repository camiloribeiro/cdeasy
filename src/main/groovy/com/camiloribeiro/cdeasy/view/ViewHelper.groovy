package com.camiloribeiro.cdeasy.view

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.MemoryJobManagement
import javaposse.jobdsl.dsl.views.NestedViewsContext

class ViewHelper {

    def addView(String viewName, String viewDescription, String viewegex) {
        JobManagement jm = new MemoryJobManagement()
        def viewFactory = new NestedViewsContext(jm)
        return viewFactory.listView(viewName) {
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
