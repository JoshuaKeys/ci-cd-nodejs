pipeline {
    agent any;
    
    environment {
        NAME='Joshua Oguma'
        secret = credentials('TEST')
    }
    parameters {
        string(name: 'Greeting', defaultValue: 'Hello World', description: 'Simple parameter added')
    }
    stages {
        stage('setup') {
            steps {
                nodejs(nodeJSInstallationName: 'nodejs') {
                    sh 'npm install --only=dev'
                }
            }
        }
        stage('linting') {
            steps {
                nodejs(nodeJSInstallationName: 'nodejs') {
                    sh 'npm run lint'
                }

            }
        }
        stage('test') {
            steps {
                nodejs(nodeJSInstallationName: 'nodejs') {
                    sh 'npm test'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'docker build -t keysoutsourcedocker/docker-nodejs-demo .'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker push keysoutsourcedocker/docker-nodejs-demo'
            }
        }
    }
}