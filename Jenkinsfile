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
                    def dockerCmd = "docker run -p 8080:8080 -d akramexp/my-repo:jma-1.0"
                    sshagent(['ec2-user-key']) {
                        sh " ssh -o StrictHostKeyChecking=no ec2-user@15.207.85.245 ${dockerCmd} "
                    }
                }
            }
        }
    }
}   
