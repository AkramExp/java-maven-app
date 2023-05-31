def build() {
    echo "building the app"
    sh 'mvn package'
}

def buildImage() {
    echo "building the image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t akramexp/my-repo:jma-2.0 .'
        sh 'docker login -u $USER -p $PASSWORD'
        sh 'docker push akramexp/my-repo:jma-2.0'
    }
}

def deployApp() {
    echo "deploying the application"
}

return this
