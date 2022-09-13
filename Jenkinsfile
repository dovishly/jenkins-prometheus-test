@Library('shared-lib@shared-lib') _

List envs = ["dev", "qa", "devqa", "sit", "uat", "prod"]
List clients = ["client1", "client2", "client3", "client4", "client5", "client6"]
List version = ["1.0.0-RC4", "10.2.0-RC1", "3.4.0-RC8", "legacy"]
//float parsedVersion = Float.parseFloat(version.replace('.', '').replace("-",".").replace("RC",""))
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
                    for (int i = 0; i < clients.size(); i++) {
                
                    int randEnv = Math.abs(new Random().nextInt() % envs.size() )
                    int randVer = Math.abs(new Random().nextInt() % version.size() )
                    // steps.sh("echo '${clients.get(i)}_metrics{env=\"${envs.get(i)}\",client=\"${clients.get(i)}\",version=\"${version.get(randVer)}\"} ${this.currentBuild.startTimeInMillis}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                        
                    }

                    steps.sh("echo '${clients.get(0)}_metrics{env=\"${envs.get(0)}\",client=\"${clients.get(0)}\",version=\"${version.get(0)},honeycombVersion=4.1.0\"} ${this.currentBuild.startTimeInMillis}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                    steps.sh("echo '${clients.get(1)}_metrics{env=\"${envs.get(1)}\",client=\"${clients.get(1)}\",version=\"${version.get(1)}\",honeycombVersion=\"5.0.0\", jenkinsURL=\"${this.PROJECT_URL}\"} ${this.currentBuild.startTimeInMillis}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                    
                    steps.sh("echo 'failed_builds{env=\"${envs.get(1)}\",client=\"${clients.get(2)}\",version=\"${version.get(2)}\",honeycombVersion=\"4.8.0\", jenkinsURL=\"${this.currentBuild.BUILD_URL}\"} 1' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                    steps.sh("echo 'failed_builds{env=\"${envs.get(5)}\",client=\"${clients.get(2)}\",version=\"${version.get(0)}\",honeycombVersion=\"4.8.0\", jenkinsURL=\"${this.currentBuilc.BUILD_URL}\"} 1' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
                    //steps.sh("echo 'some_metrics{env=\"${envs.get(randEnv)}\",client=\"${clients.get(randClient)}\",version=\"${version.get(randVer)}\"} ${currentBuild.startTimeInMillis}' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")

                    //steps.sh("echo '' | curl --data-binary @- http://host.docker.internal:9091/metrics/job/clients")
    
    //${clients[randClient]}_${envs[randEnv]}_metrics ${version}
    //${version}_metrics ${clients[randClient]}_${envs[randEnv]}
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
