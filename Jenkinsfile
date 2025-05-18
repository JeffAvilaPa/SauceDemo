pipeline {
    agent any

    parameters {
        string(name: 'TAGS', defaultValue: '@smoke or @regression', description: 'Tags to run')
    }

    tools {
        maven 'Maven 3.9.9' // asegúrate de que esta versión esté configurada en Jenkins
        jdk 'corretto-17'   // asegúrate de tener configurado este JDK con ese nombre
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/JeffAvilaPa/SauceDemo.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh "mvn test -Dcucumber.filter.tags='${params.TAGS}'"
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber Test Report'
                ])
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.html', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
