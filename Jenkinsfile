pipeline{
    agent any
    tools {
        jdk 'java17'
        maven 'maven3'
    }
    stages{
        stage("cleanup workspace"){
            steps{
                cleanWs()
            }
        }
        stage("checkout from SCM"){
            steps{
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/ghisswill/demo-pipeline'
            }
        }
        stage("build application"){
            steps{
                sh "mvn clean package"
            }
        }
        stage("test application"){
            steps{
                sh "mvn test"
            }
        }
        stage("sonarqube analysis"){
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'jenkins-sonarqube-token'){
                    sh "mvn sonar:sonar"
                }
            }
            }
        }
    }
}