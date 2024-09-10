def call(String repoDir, String imageTag) {
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
