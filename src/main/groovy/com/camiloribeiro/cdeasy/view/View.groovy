package com.camiloribeiro.cdeasy.view

class View {
    def addView(String name, String descriptino, String regex) {
        listView('Deploys') {
            description('All Deploy jobs')
            filterBuildQueue()
            filterExecutors()
            jobs {
                regex('deploy.+')
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
