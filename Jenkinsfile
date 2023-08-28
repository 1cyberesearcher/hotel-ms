pipeline {

	agent any
	tools{
		maven 'maven'}

	stages {
		stage ('Compiling the code'){
			steps {
				sh 'mvn clean compile'}
		}

		stage ('Packaging the code'){
			steps {
				sh 'mvn clean package'}
		}

		 steps {
                script {
                    def scannerHome = tool name: 'qube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    def scannerCmd = "${scannerHome}/bin/sonar-scanner"

                    withSonarQubeEnv('SonarQubeServerName') {
                        sh "${scannerCmd}"
                    }
                }
            }
	}
}