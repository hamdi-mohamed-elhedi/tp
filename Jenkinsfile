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

        stage('Deploy') {
            steps {
                sh """
                echo "Stopping old app if exists..."
                pkill -f 'tp-1.0.jar' || true

                echo "Starting app..."
                nohup java -jar target/tp-1.0.jar > app.log 2>&1 &
                """
            }
        }
    }
}
