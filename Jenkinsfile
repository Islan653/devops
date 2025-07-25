pipeline {

    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }

    parameters {
        string(name: 'TAGS', defaultValue: '@login', description: 'Tags cucumber a executar')
    }

    environment {
        MAVEN_OPTS = "-Dcucumber.filter.tags=${params.TAGS}"
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/Islan653/devops.git', branch: 'main'
            }
        }

        stage('Executar testes') {
            steps {
                bat "mvn clean test -Dtest=runner.RunCucumberTest -Dcucumber.filter.tags=${params.TAGS}"
            }
        }

        stage('Publicar Relatório HTML') {
            steps {
                publishHTML(target: [
                    reportDir: 'target',
                    reportFiles: 'Cucumber-report.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }

    }

    post {
        always {
            script {
                try {
                    archiveArtifacts artifacts: 'target/evidencias/**/*.png', fingerprint: true
                } catch(err) {
                    echo "Nenhuma evidência encontrada para arquivar."
                }
            }
        }
    }

}
