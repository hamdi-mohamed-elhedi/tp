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
                echo "Go to workspace"
                cd /var/lib/jenkins/workspace/test

                echo "Check jar"
                ls -l target/

                echo "Stop old app"
                pkill -f 'tp-1.0.jar' || true

                echo "Start app on port 8088"
                nohup java -jar target/tp-1.0.jar --server.port=8088 > app.log 2>&1 &
                """
            }
        }
    }
}
