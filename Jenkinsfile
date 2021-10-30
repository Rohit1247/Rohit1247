#!/usr/bin/env groovy
def gv
pipeline {
    agent any

    tools{
    maven 'Maven'
    }
    stages {
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                   gv.buildJar()
                }
            }
        }
         stage('build docker image') {
                    steps {
                        script {
                            gv.buildImage()
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
                    gv.deployApp()
                }
            }
        }
    }
}
