@Library('shared-lib@shared-lib') _

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                script {
                    int num = Math.abs(new Random().nextInt() % 100) + 1
                    steps.echo('Hello World')
                    steps.sh("echo 'some_metrics ${num}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/some_job")
                    //Prom prom = new Prom()
                    //prom.send_message("http://host.docker.internal:9091/metrics/job/some_job", "foobar 1")
                }
            }
        }
        stage('Stage 2') {
            steps {
                script {
                    steps.sleep(Math.abs(new Random().nextInt() % 10) + 1)
                    //Prom prom = new Prom()
                    //prom.send_message("http://host.docker.internal:9091/metrics/job/some_job", "foobar 1")
                }
            }
        }
    }
}
