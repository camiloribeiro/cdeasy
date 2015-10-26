package com.camiloribeiro.cdeasy.viewHelper

import javaposse.jobdsl.dsl.ViewFactory

class ViewHelper {
    def dslFactory = this as ViewFactory

    def addView(String name, String description, String regex) {
        dslFactory.listView(name)
                /* {
            description(description)
            filterBuildQueue()
            filterExecutors()
            jobs {
                regex(regex)
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
        }*/
    }
}
