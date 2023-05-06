// node {
//     def commit_id
//     stage('Preparation') {
//         checkout scm
//         sh "git rev-parse --short HEAD > .git/commit-id"
//         commit_id = readFile('.git/commit-id').trim()
//     }
//     stage('linting') {
//         nodejs(nodeJSInstallationName: 'nodejs') {
//             sh 'npm install --only=dev'
//             sh 'npm run lint'
//         }
//     }
//     stage('test') {
//         nodejs(nodeJSInstallationName: 'nodejs') {
//             sh 'npm install --only=dev'
//             sh 'npm test'
//         }
//     }
//     stage('docker build/push') {
//         docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
//             def app = docker.build('keysoutsourcedocker/docker-nodejs-demo', '.').push()
//         }
//     }
// }

pipeline {
    agent any
    
    environment {
        NAME='Joshua Oguma'
    }
    stages {
        stage('Build') {
            steps {
                sh "echo 'My First pipeline'"
                sh '''
                    echo "By the way, I can do more stuff in here $NAME"
                    docker ps
                    ls -lah
                '''
            }
        }

        stage('Test') {
            steps {
                retry(3) {
                    echo 'Testing...'
                }
            }
        }

        stage('Deply') {
            steps {
                timeout(time: 3, unit: 'SECONDS') {
                    sh 'sleep 5'
                }
            }
        }
    }
}