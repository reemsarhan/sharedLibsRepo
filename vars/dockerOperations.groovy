// vars/dockerOperations.groovy

def buildDockerImage(String contextPath, String tag) {
    echo "Building Docker image with context: ${contextPath} and tag: ${tag}"
    sh "docker build -t your-docker-repo/${contextPath}:${tag} ${contextPath}"
}

def pushDockerImage(String tag) {
    echo "Pushing Docker image with tag: ${tag}"
    sh "docker push your-docker-repo:${tag}"
}
