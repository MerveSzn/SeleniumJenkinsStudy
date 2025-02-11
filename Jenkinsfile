pipeline {
    agent any
   tools {
        maven 'Maven'
    }
    environment {
        GIT_CREDENTIALS_ID = 'github-credentials'  // Jenkins'te tanımladığın credential ID
        REPO_URL = 'https://github.com/MerveSzn/SeleniumJenkinsStudy'
        BRANCH_NAME = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH_NAME}",
                    credentialsId: "${GIT_CREDENTIALS_ID}",
                    url: "${REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                withMaven(maven: 'Maven') {
                    sh 'mvn clean install'
                }
            }
        }

      /*   stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
                junit '**//* target/surefire-reports *//*.xml'  // Test sonuçlarını raporla
            }
        } */
        stage('Build & Test') {
            steps {
                sh 'mvn clean test surefire-report:report-only' // Testleri çalıştır ve raporları oluştur
            }
        }


         stage('Publish JUnit Report') {
            steps {
                junit '**//* target/surefire-reports *//*.xml' // JUnit test sonuçlarını al
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML([
                    reportName: 'JUnit HTML Report',
                    reportDir: 'target/site',
                    reportFiles: 'surefire-report.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

      post {
            always {
                archiveArtifacts artifacts: 'target/site/surefire-report.html', fingerprint: true
            }
        }
}
