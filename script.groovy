    def buildJar(){
    echo "Building the application..."
    sh 'mvn package'
    }
    def buildImage(){

    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t rohit1247/newimage:jma2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push rohit1247/newimage:jma2.0'
    }
    def deployApp(){

        echo "Deploying the application..."
    }
    }
return this
