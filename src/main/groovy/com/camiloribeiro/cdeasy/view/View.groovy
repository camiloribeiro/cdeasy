package com.camiloribeiro.cdeasy.view

class View {
    def addView(String name, String descriptino, String regex) {
        listView(name) {
            description(desciption)
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
        }
    }
}
