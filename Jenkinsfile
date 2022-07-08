#!groovy
pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
          image 'maven:3.8.1-adoptopenjdk-11'
          args  '--net="springmysql-net"'
        }
      }
      steps {
        sh 'mvn clean install test -Pqa5-Apis'
      }
    }
  }
}