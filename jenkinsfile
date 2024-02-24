pipeline{
    agent{
        label "node"
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
        stage("checkout from SCM){
            steps{
                git branch: 'main', credentialsIds: 'github', url: 'https://github.com/ghisswill/demo-pipeline'
            }
        }
    }
}