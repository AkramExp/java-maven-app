pipeline {
    agent any
    stages {
        stage("build") {
            steps {
                script {
                    echo "building... "
                }
            }
        }
        stage("test") {
            steps {
                script {
                    echo "testing... "
                }
            }
        }
        stage("deploy") {
            environment {
                AWS_ACCESS_KEY_ID = credentials('aws_access_key_id')
                AWS_SECRET_ACCESS_KEY = credentials('aws_secret_key_access')
            }
            steps {
                script {
                    echo "deploying.. "
                    sh 'kubectl create deployment nginx-deployment --image=nginx'
                }
            }
        }
    }   
}
