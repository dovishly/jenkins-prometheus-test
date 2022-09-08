@Library('shared-lib@shared-lib')

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                script {
                    steps.print('Hello World')
                    Prom prom = new Prom()
                    prom.send_message("http://localhost:9090/metrics/job/foobar/1", "foobar 1")
                }
            }
        }
    }
}
