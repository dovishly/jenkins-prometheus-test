@Library('shared-lib@shared-lib') _

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                script {
                    steps.echo('Hello World')
                    Prom prom = new Prom()
                    prom.send_message("http://localhost:9191/metrics/job/foobar/1", "foobar 1")
                }
            }
        }
    }
}
