pipeline {
    agent any
    environment {
        BRANCH_NAME = 'jenkins-job'
    stages {
        stage("build") {
            when {
                expression {
                    ${BRANCH_NAME} == 'main'
                }
            }
            steps {
                echo "building the application"
            }
        }
        stage("test") {
            steps {
                echo "testing the application"
            }
        }
        stage("deploy") {
            steps {
                echo "deploying the application"
            }
        }
    }   
}
