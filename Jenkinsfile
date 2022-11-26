def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    echo "building the application... "
                    sh 'mvn package'
                }
            }
        }

        stage('build image') {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
                        sh 'docker build -t akramexp/my-repo:jma-2.0 .'
                        sh "docker login -u $USER -p $PWD"
                        sh 'docker push akramexp/my-repo:jma-2.0'
                    }
                }
            }
        }

        stage('test') {
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage('deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
