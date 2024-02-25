pipeline{
    agent any
    tools {
        jdk 'java17'
        maven 'maven3'
    }
    environment {
        APP_NAME = "demo-pipeline"
        RELEASE = "1.0.0"
        DOCKER_USER = "ghisswill"
        DOCKER_PASS = 'dockerhub'
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
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
        stage("Guality Gate"){
            steps{
                script{
                    waitForQualityGate abortPipeline: 'jenkins-sonarqube-token'
                }
            }
        }
        stage("Build & Push docker image"){
            steps{
                script{
                    docker.withRegistry('', DOCKER_PASS) {
                        docker_image = docker.build "${IMAGE_NAME}"
                    }
                    docker.withRegistry('', DOCKER_PASS) {
                        docker_image.push("${IMAGE_TAG}")
                        docker_image.push("latest")
                    }
                }
            }
        }
    }
}