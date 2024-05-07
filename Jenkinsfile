pipeline {
  environment {
    imagename = "tambedou/mon-image"
    registryCredential = 'Github'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git([url: 'https://github.com/Mariamatambedou/sabackend.git', branch: 'main', credentialsId: 'key'])

      }
    }
    stage('Building image') {
      steps{
        script {
            def dockerfilePath = 'Dockerfile'
         dockerImage = docker.build(imagename, "-f ${dockerfilePath} .")
        }
      }
    }







      
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push("$BUILD_NUMBER")
             dockerImage.push('latest')

          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $imagename:$BUILD_NUMBER"
         sh "docker rmi $imagename:latest"

      }
    }
  }
}
