# Shared Library for Jenkins Pipeline

This repository contains shared Jenkins library functions for Docker operations and Kubernetes deployment file generation. The functions are located in the `vars` directory in the `dockerOperations.groovy` file.

## Structure

- **vars/dockerOperations.groovy**: This Groovy script contains two main functions:
  - `BuildAndPush(String repoDir, String imageTag)`: Builds and pushes a Docker image.
  - `generateDeploymentYAML(String imageTag, String filePath)`: Generates a Kubernetes deployment YAML file.

## Functions

### `BuildAndPush`

This function builds a Docker image from a specified directory and pushes it to Docker Hub. After pushing, it removes the image locally.

#### Usage:

```groovy
dockerOperations.BuildAndPush('/path/to/repo', 'v1.0')
