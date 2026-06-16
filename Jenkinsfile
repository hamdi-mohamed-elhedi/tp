pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh """
                    mvn sonar:sonar \
                        -Dsonar.projectKey=tp \
                        -Dsonar.projectName=tp \
                        -Dsonar.login=admin \
                        -Dsonar.password=Mha12345678!
                    """
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh """
                docker build -t tp-app .
                """
            }
        }

        stage('Docker Run') {
            steps {
                sh """
                echo "Stop old container"
                docker stop tp-container || true
                docker rm tp-container || true

                echo "Run new container"
                docker run -d -p 8088:8088 --name tp-container tp-app
                """
            }
        }
    }
}
