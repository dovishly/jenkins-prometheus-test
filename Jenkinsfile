@Library('shared-lib@shared-lib') _

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                script {
                    steps.echo('Hello World')
                    steps.sh("echo 'some_metrics 3.14' | curl --data-binary @- http://localhost:9091/metrics/job/some_job")
                    //Prom prom = new Prom()
                    //prom.send_message("http://host.docker.internal:9091/metrics/job/some_job", "foobar 1")
                }
            }
        }
    }
}
