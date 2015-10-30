package com.camiloribeiro.cdeasy.view

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.JobParent
import javaposse.jobdsl.dsl.MemoryJobManagement
import spock.lang.*

@Unroll
class ViewHelperTest extends Specification {

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

    @Override
    void with(Object target, Closure<?> closure) {
        super.with(target, closure)
    }

    def "Should create a view"() {

        given:
        def baseView = new ViewHelper()
        def viewName  = 'Test'
        def viewDescription  = 'Testing'
        def viewRegex  = 'foo.+'

        when:
        def view = baseView.addView(createJobParent(), viewName, viewDescription, viewRegex)

        then:
        with(view.node) {
            view.name == viewName
            view.node.description[0].value() == viewDescription
            view.node.includeRegex[0].value() == viewRegex
        }

    }
}

