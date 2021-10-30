#!/usr/bin/env groovy

pipeline {
    agent none

    tools{
    maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
         stage('build docker image') {
                    steps {
                        script {
                            echo "Building the docker image..."
                            withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER']){
                            sh 'docker build -t rohit1247/newimage:jma2.0 .'
                            sh "echo $PASS | docker login -u $USER --password-stdin"
                            sh 'docker push rohit1247/newimage:jma2.0'
                            }  
                        }
                    }
                }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
