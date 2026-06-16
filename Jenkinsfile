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

                    mvn clean verify sonar:sonar -Dsonar.projectKey=tp -Dsonar.projectName=tp \
                    
                    -Dsonar.login=admin \
                        -Dsonar.password=Mha12345678!

                    

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
