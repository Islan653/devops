pipeline{
	
	//define que o pipeline pode ser executado em qualquer agente
	agent any
	
	tools{
		jdk 'JAVA_HOME'
		maven 'MAVEN_HOME'
	}
	
	parameters{
		
		String(name: 'TAGS', defaultValue: '@login', description: 'Tags cucumber a executar')
		
		
	}
	
	enviroment{
		Maven_OPTS = "-Dcucumber.filter.tags=${params.TAGS}"
		
		
	}
	
	stage('Checkout'){
		steps{
			git url: '', branch: 'main'
		}
	}
	
	stage('Executar testes'){
		steps{
			"mvn clean test -Dtest=runner.RunCucumberTest -Dcucumber.filter.tags=${params.TAGS}"
		}
	}
	
	stage('Public Relatório HTML'){
		steps{
			publishHTML(target:[
				reportDir: 'target',
				repotFiles: 'Cucumber-report.html',
				reportName: 'Cucumber Report'
				])
		}
	}
	
	post{
		always{
			script{
				try{
					archiveArtifacts artifacts: 'target/evidencias/**/*.png', fingerprint: true
				} cath(err){
					echo "Nenhuma evidência encontrada para arquivar."
				}
			}
		}
	}
	
	
	
	
	
	
}