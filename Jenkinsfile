#!usr/bin/env groovy

@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                    buildImage 'akramexp/my-repo:jma-4.0'
                    dockerLogin()
                    dockerPush 'akramexp/my-repo:jma-4.0'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockerCompose = "docker-compose -f docker-compose.yaml up --detach"
                    sshagent(['ec2-user-key']) {
                        sh "scp docker-compose.yaml ec2-user@15.207.85.245:/home/ec2-user"
                        sh " ssh -o StrictHostKeyChecking=no ec2-user@15.207.85.245 ${dockerCompose} "
                    }
                }
            }
        }
    }
}   
