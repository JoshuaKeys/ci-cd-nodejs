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
        stage('linting') {
            steps {
                nodejs(nodeJSInstallationName: 'nodejs') {
                    sh 'npm install --only=dev'
                    sh 'npm run lint'
                }

            }
        }
        // stage('test') {
        //     steps {
        //         sh 'npm test'
        //     }
        // }
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