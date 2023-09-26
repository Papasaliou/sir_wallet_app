pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {
        stage("Source") {
            steps {
                git branch: 'devgroup', url: 'https://github.com/Papasaliou/sir_wallet_app.git'
            }
        }
        stage("Build") {
            steps {
                bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }
        stage("SonarQube Analysis") {
            steps {
                bat 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.30:9000'
            }
        }
        stage('Approve Deployment') {
            input {
                message "Do you want to proceed for deployment?"
            }
            steps {
                bat 'echo "Deploying into Server"'
            }
        }
    }
    post {
        aborted {
            echo "Sending message to agent"
        }
        failure {
            echo "Sending message to agent"
        }
        success {
            echo "Sending message to agent"
        }
    }
}
