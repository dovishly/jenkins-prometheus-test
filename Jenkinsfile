@Library('shared-lib@shared-lib') _

List envs = ["dev", "clientqa", "prod"]
List clients = ["client1", "client2", "client3"]
String version = "1.0.0-RC4"

pipeline {
    agent any 
    options {
        disableConcurrentBuilds()
    }
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
                    steps.sleep(Math.abs(new Random().nextInt() % 180) + 1)
                    //Prom prom = new Prom()
                    //prom.send_message("http://host.docker.internal:9091/metrics/job/some_job", "foobar 1")
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    int randClient = Math.abs(new Random().nextInt() % clients.size())
                    int randEnv = Math.abs(new Random().nextInt() % envs.size())
                    steps.sh("echo '${clients[randClient]}_${envs[randEnv]}_metrics ${version}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                    steps.sh("echo '\'${version}_metrics\' ${clients[randClient]}_${envs[randEnv]}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
    

                    //Prom prom = new Prom()
                    //prom.send_message("http://host.docker.internal:9091/metrics/job/some_job", "foobar 1")
                }
            }
        }
    }
        post {
            always {
                    script{
                        int dur = this.currentBuild.duration
                        steps.sh("echo 'build_duration ${dur}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/some_job")
                    }
            }
        }
}
