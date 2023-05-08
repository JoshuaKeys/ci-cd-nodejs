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

// node {
//     stage('Preparationsss') {
//         checkout scm
//     }
// }

pipeline {
    agent {
        docker { image 'node:18.16.0-alpine' }
    }
    
    environment {
        NAME='Joshua Oguma'
        secret = credentials('TEST')
    }
    parameters {
        string(name: 'Greeting', defaultValue: 'Hello World', description: 'Simple parameter added')
    }
    stages {
        stage('Build') {
            steps {
                sh "echo 'My First pipeline'"
                sh '''
                    echo "By the way, I can do more stuff in here "
                    ls -lah
                '''
            }
        }

        stage('Example') {
            steps {
                echo "${params.Greeting}. How are you doing?"
            }
        }

        stage('Test') {
            steps {
                retry(3) {
                    sh "echo 'Testing... ' Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                }
            }
        }

        stage('Test Node.js') {
            steps {
                sh 'node --version'
            }
        }

        stage('Deply') {
            steps {
                timeout(time: 10, unit: 'SECONDS') {
                    sh 'sleep 5'
                }
            }
        }
    }
}