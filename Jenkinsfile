pipeline {

	agent any
	tools{
		maven 'maven'
	}

	stages {
		stage ('Compiling the code'){
			steps {
				sh 'mvn clean compile'
			}
		}

		stage ('Packaging the code'){
			steps {
				sh 'mvn clean package'
			}
		}
	}
}