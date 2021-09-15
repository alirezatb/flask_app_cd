pipeline {
    agent any
    options {
        disableConcurrentBuilds()
    }
    stages{
        stage("Build"){
            steps {
                buildApp()
                 }
        }

        stage("Deploy -Dev") {
            steps {
                deploy("dev")
            }
        }
    }
}

// steps
def buildApp() {
    dir("cd_pipeline_python_app") {
        def appImage = docker.build("flask_app/myapp:{BUILD_NUMBER}")
        }
}

def deploy(environment) {
    def containerName = ''
    def port = ''
    if ("${environment}" == 'dev'){
        containerName = "app Dev"
        port = "8888"
    }
    else {
        println "Environment not valid"
        system.exit(0)
    }
    sh "docker ps -f name=${containerName} -q | xargs --no-run-if-empty docker stop"
    sh "docker ps -a -f name=${containerName} -q | xargs -r docker rm"
    sh "docker run -d -p ${port}:5000 --name ${containerName} flask_app/myapp:${BUILD_NUMBER}"
}