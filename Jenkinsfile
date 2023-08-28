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

		stage ('Checking code quality'){
			withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn clean package sonar:sonar'}
		}
	
		stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true}
            }
        }
	}
}