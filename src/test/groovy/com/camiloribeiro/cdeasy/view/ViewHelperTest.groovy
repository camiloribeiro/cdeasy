package com.camiloribeiro.cdeasy.view

import spock.lang.*

@Unroll
class ViewHelperTest extends Specification {


    def "Should create a view"() {

        given:
        def baseView = new ViewHelper()
        def viewName  = 'Test'
        def viewDescription  = 'Testing'
        def viewRegex  = 'foo.+'

        when:
        def view = baseView.addView(viewName, viewDescription, viewRegex)

        then:
        with(view.node) {
            name() == 'hudson.model.ListView'
        }


    }
}

