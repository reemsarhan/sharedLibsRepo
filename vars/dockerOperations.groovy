// vars/dockerOperations.groovy

def call(String repoName, String tag) {
    // Default implementation can go here
}

def buildDockerImage(String repoName, String tag) {
    sh "docker build -t ${repoName}:${tag} ."
}

def pushDockerImage(String repoName, String tag) {
    sh "docker push ${repoName}:${tag}"
}

