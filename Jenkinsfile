pipeline{
    agent{
        label "jenkins"
    }
    tools {
        jdk 'java17'
        maven 'maven3'
    }
    stages{
        stage("cleanup workspace"){
            steps{
                cleanws()
            }
        }
        stage("checkout from SCM"){
            steps{
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/ghisswill/demo-pipeline'
            }
        }
    }
}