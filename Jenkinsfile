ipeline {
    agent any
    tools {
        maven 'maven'
    }
    stage("build") {
    steps {
        echo "building the app"
            sh 'mvn package'
        }
    }
    stage("build image") {
        steps {
            echo "building the image"
            withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                sh 'docker build -t akramexp/my-repo:jma-2.0'
                sh 'docker login -u $USER -p $PWD'
                sh 'docker push akramexp/my-repo:jma-2.0'
            }
        }
    }
    stage("deploy") {
        steps {
            echo "deploying"
        }
    }
}   
