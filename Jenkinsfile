pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('test') {
            steps {
                echo "testing the application... "
            }
        }

        stage('build') {
            when {
                expression {
                    BRANCH_NAME=='main'
                }
            }
            steps {
                echo "building the application... "
            }
        }

        stage('deploy') {
            when {
                expression {
                    BRANCH_NAME=='main'
                }
            }
            steps {
                echo "deploying the application... "
            }
        }
    }
}
