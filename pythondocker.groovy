job('python docker example') {
    scm {
        git('https://github.com/alirezatb/flask_app_cd') { node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('ar.t@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('civictb/docker-python-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}