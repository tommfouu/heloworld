pipeline {​​​​​​​
    agent any
    tools {​​​​​​​
        maven 'Maven'
        jdk 'jdk1.8'
    }​​​​​​​
    parameters {​​​​​​​
        booleanParam(name: "Perform release ?", description: '', defaultValue: false)
    }​​​​​​​
    stages {​​​​​​​
        stage('Initialize') {​​​​​​​
            steps {​​​​​​​
                bat '''
                    echo "PATH = ${​​​​​​​PATH}​​​​​​​"
                    echo "M2_HOME = ${​​​​​​​M2_HOME}​​​​​​​"
                '''
            }​​​​​​​
        }​​​​​​​
        stage('Build') {​​​​​​​
            steps {​​​​​​​
                bat 'mvn compile'
            }​​​​​​​
        }​​​​​​​

        stage('Test') {​​​​​​​
            steps {​​​​​​​
                bat 'mvn test'
            }​​​​​​​
        }​​​​​​​}​​​​​​}​​​​​​