// vars/dockerOperations.groovy

 def BuildAndPush(String repoDir, String imageTag) {
    dir(repoDir) {
        if (isUnix()) {
            sh "docker build -t reemwaleed/new-deploymentnew-image:${imageTag} ."
            sh "docker push reemwaleed/new-deploymentnew-image:${imageTag}"
            sh "docker rmi -f reemwaleed/new-deploymentnew-image:${imageTag}"
        } else {
            bat "docker build -t reemwaleed/new-deploymentnew-image:${imageTag} ."
            bat "docker push reemwaleed/new-deploymentnew-image:${imageTag}"
            bat "docker rmi -f reemwaleed/new-deploymentnew-image:${imageTag}"
        }
    }
}

def generateDeploymentYAML(imageTag, filePath) {
    sh """
    cat <<EOF > ${filePath}/deployment.yaml
    apiVersion: apps/v1
    kind: Deployment
    metadata:
      name: library-json-deployment
    spec:
      replicas: 1
      selector:
        matchLabels:
          app: library-json
      template:
        metadata:
          labels:
            app: library-json
        spec:
          containers:
            
name: library-json-container
            image: reemwaleed/new-deployment-image:${imageTag}
            resources:
              limits:
                memory: "512Mi"
                cpu: "500m"
              requests:
                memory: "256Mi"
                cpu: "250m"
  EOF"""
}


