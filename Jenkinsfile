#!groovy
pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
          image 'adoptopenjdk/maven-openjdk11:latest'
        }
      }
      steps {
        sh 'mvn clean install test -Pqa5-Apis'
      }
    }
  }
}