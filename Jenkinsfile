pipeline{
    agent any
    tools{
        maven: 'Maven'
        jdk: 'jdk1.8'
    }
    parameters {
        booleanParam(name: "Perform release ?", description: '', defaultValue: false)
    }
    stages{
        stage('Initialize'){
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    '''
            }
            stage('Build') {
                steps {
                    sh 'mvn compile'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
        }
    }
}