#!/usr/bin/groovy

// pipeline {
//     agent any
//
//     options {
//         disableConcurrentBuilds()
//     }
//     environment {
//         PYTHONPATH = "${WORKSPACE}/flask_dev_jen"
//     }
//
//     stages {
//         stage("Test - Unit Test") {
//             steps(runUnitTests())
//         }
//
// //         stage("Build") {
// //             steps { buildApp() }
// // 		}
// //
// //         stage("Deploy - Dev") {
// //             steps { deploy('dev') }
// // 		}
// // 		stage("Test UAT Dev") {
// // 		    steps{ runUAT(8888)}
// // 		}
// //         stage("deploy Stage") {
// //             steps { runUAT(88)}
// //         }
//
// 	}
// }


// steps
// def buildApp() {
// // 	dir ('flask_dev_jen' ) {
// // 		def appImage = docker.build("flask_dev/myapp:${BUILD_NUMBER}")
// // 	}
//     def appImage = docker.build("flask_dev/myapp:${BUILD_NUMBER}")
// }
//
// def deploy(environment) {
//
// 	def containerName = ''
// 	def port = ''
//
// 	if ("${environment}" == 'dev') {
// 		containerName = "app_dev"
// 		port = "8888"
// 	}
// 	else if ("${environment}" == 'stage') {
// 	    containerName = "app_stage"
// 	    port = "88"
// 	}
// 	else {
// 		println "Environment not valid"
// 		System.exit(0)
// 	}
//
// 	sh "docker ps -f name=${containerName} -q | xargs --no-run-if-empty docker stop"
// 	sh "docker ps -a -f name=${containerName} -q | xargs -r docker rm"
// 	sh "docker run -d -p ${port}:5000 --name ${containerName} flask_dev/myapp:${BUILD_NUMBER}"
//
// }

// def runUnitTests() {
//     sh "pip3 install --no-cache-dir -r ./flask_dev_jen/requirements.txt"
//     sh "python3 flask_dev_jen/tests/test_flask_app.py"
// }

// def runUAT(port){
//     sh "flask_dev_jen/tests/runUAT.sh ${port}"
// }
pipeline{
    agent any
    environment {
        artifactory_credentials_id = credentials("artifactory")
    }
    stages {
        stage {
            steps {
              script {
                docker.withRegistry("https://civicusydrepo.jfrog.io", artifactory_credentials_id)
                {
                  def dockerImage = docker.build("flask_dev/myapp:${BUILD_NUMBER}")
                  dockerImage.push()
                }
              }
           }
        }
    }
}