@Library('shared-lib@shared-lib') _

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                script {
                    steps.echo('Hello World')
                    Prom prom = new Prom()
                    prom.send_message("http://0.0.0.0:9191/prometheus", "foobar 1")
                }
            }
        }
    }
}
