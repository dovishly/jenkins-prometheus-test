@Library('shared-lib')

pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                print('Hello World')
                script {
                    send_message("http://localhost:9090/metrics/job/foobar/1", "foobar 1")
                }
            }
        }
    }
}
