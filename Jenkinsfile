// node {
//     def commit_id
//     stage('Preparation') {
//         checkout scm
//         sh "git rev-parse --short HEAD > .git/commit-id"
//         commit_id = readFile('.git/commit-id').trim()
//     }


//     stage('docker build/push') {
//         docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
//             def app = docker.build('keysoutsourcedocker/docker-nodejs-demo', '.').push()
//         }
//     }
// }

// node {
//     stage('Preparationsss') {
//         checkout scm
//     }

pipeline {
    agent {
        docker { image 'node:alpine' }
    }
    
    environment {
        NAME='Joshua Oguma'
        secret = credentials('TEST')
    }
    parameters {
        string(name: 'Greeting', defaultValue: 'Hello World', description: 'Simple parameter added')
    }
    stages {
        stage('linting') {
            steps {
                sh 'npm install --only=dev'
                sh 'npm run lint'
            }
        }
        stage('test') {
            steps {
                sh 'npm test'
            }
        }
        stage('Build') {
            steps {
                sh 'npm run build'
            }
        }

        stage('Deploy') {
            docker.build('keysoutsourcedocker/docker-nodejs-demo', '.')
        }
    }
}