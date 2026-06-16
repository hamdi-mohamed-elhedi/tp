pipeline {
    agent any

    environment {
        SONARQUBE = 'sonarqube' // nom défini dans Jenkins
    }
    
tools {
    maven 'maven'
}


      stages {

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh """

                    mvn clean verify sonar:sonar -Dsonar.projectKey=tp -Dsonar.projectName='tp \
                    
                        -Dsonar.host.url=$SONAR_HOST_URL \
                        -Dsonar.login=$SONAR_AUTH_TOKEN

                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
      }   
}
