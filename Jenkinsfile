#!/usr/bin/env groovy
node {
    stage('SCM') {
        checkout scm
    }

    stage('Build + Unit Tests') {
        script {
            try {
                sh 'ls -alh'
                sh 'chmod +x gradlew'
                sh './gradlew clean build --stacktrace -Dfile.encoding="UTF-8"'
            }
            catch (err) {
                unstable(message: "${STAGE_NAME} is unstable")
            }
            finally {
                // Log test results in Jenkins
            }
        }
    }

    stage('SonarQube Analysis') {
        withSonarQubeEnv() {
            sh "./gradlew test sonarqube -Dsonar.login=${SONARQUBE_TOKEN}"
        }
    }
}
