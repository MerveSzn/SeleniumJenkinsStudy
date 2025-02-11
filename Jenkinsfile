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

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
                junit '**/target/surefire-reports/*.xml'  // JUnit XML report
            }
        }

        stage('Publish JUnit Report') {
            steps {
                junit '**/target/surefire-reports/*.xml' // JUnit test results
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML([
                    reportName: 'JUnit HTML Report',
                    reportDir: 'target/surefire-reports',  // Path to the HTML report
                    reportFiles: '**/*.html',  // Tüm .html dosyalarını al
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

      post {
            always {
            archiveArtifacts artifacts: 'target/surefire-reports/test-report.html', fingerprint: true  // Archive the HTML report
            }
        }
}
