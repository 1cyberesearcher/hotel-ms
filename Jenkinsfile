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

		stage('Sonarqube Code Quality') {
            environment { scannerHome = tool 'qube' }
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh "${scannerHome}/bin/sonar-scanner"
                    sh 'mvn sonar:sonar'}

                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true}
            }
        }

        stage ('creating dockerfile'){
        	steps {
        		script{
        			withCredentials([string(credentialsId:'dockerCred',variables:'dockerCred')]){
        				sh 'docker login -u s3clock -p ${dockerCred}'
        				sh 'docker build -t s3clock/homework .'
        			}
        		}
        	}
        }


	}
}
