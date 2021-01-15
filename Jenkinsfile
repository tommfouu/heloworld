pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk-11'
    }
    parameters {
        booleanParam(name: "Perform release ?", description: '', defaultValue: false)
    }
    stages {
        stage('Initialize'){
            steps {
                bat '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Deploy') { 
            steps {
                withMaven(mavenSettingsConfig: 'maven-config', globalMavenSettingsConfig: 'global-config') {
                    bat "mvn deploy"
                }  
            }
        }
        stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn clean package sonar:sonar'
              }
            }
         }
        stage('Release') {
        when { expression { params['Perform release ?']} }
            steps {

            withCredentials([usernamePassword(credentialsId: 'd07af407-b171-49db-bd1c-f23f65c965fd', passwordVariable: 'PASSWORD_VAR', usernameVariable: 'USERNAME_VAR')]){
                bat 'git config --global user.email "tom.mfou.1710@gmail.com"'
                bat 'git config --global user.name "tommfouu"'
                bat 'git branch release/'+pom.version.replace("-SNAPSHOT","")
                bat 'git push origin release/'+pom.version.replace("-SNAPSHOT","")
                bat 'mvn release:prepare -s C:/Users/tmfouou/.m2/settings.xml -B -Dusername=$USERNAME_VAR -Dpassword=$PASSWORD_VAR'
                bat 'mvn release:perform -s C:/Users/tmfouou/.m2/settings.xml -B -Dusername=$USERNAME_VAR -Dpassword=$PASSWORD_VAR'

            }
            }
        }


}
}
