node('build-slave') {

    // Project name will be passed in as a parameter
    def project = "${GCP_PROJECT_NAME}"
    def appName = 'cc'

    // BUILD_DATE_TIME defined as a build parameter in Jenkins
    def imageTag = "eu.gcr.io/${project}/${appName}:${BUILD_DATE_TIME}"

    // Mark the code checkout 'stage'....
    stage 'Checkout'

    // Checkout the code
    checkout scm

    // Mark the code build 'stage'....
    stage 'Compile'
    // Run the maven build
    sh "mvn clean compile"

    // Test and Package
    stage 'Test and Package'
    sh "mvn package"
    
    stage 'Bake Docker Image'
    sh("docker build -t ${imageTag}-sr codecamp-2016-service-registry")
    sh("docker build -t ${imageTag}-ds codecamp-2016-dog-service")
    sh("docker build -t ${imageTag}-rs codecamp-2016-register-service")
    sh("docker build -t ${imageTag}-us codecamp-2016-user-service")
    sh("docker build -t ${imageTag}-web codecamp-2016-webapp/codecamp-2016-backend-webapp")

    stage 'Push images to GCR'
    sh("gcloud auth activate-service-account --key-file /opt/config/gcloud-svc-account.json")
    sh("gcloud config set project ${project}")
    sh("gcloud docker push ${imageTag}-sr")
    sh("gcloud docker push ${imageTag}-ds")
    sh("gcloud docker push ${imageTag}-rs")
    sh("gcloud docker push ${imageTag}-us")
    sh("gcloud docker push ${imageTag}-web")
    
    stage 'Deploy latest version'
    sh("sed -i.bak 's#eu.gcr.io/GCP_PROJECT/APP_NAME:1.0.0#${imageTag}#' k8s.deployments/app-deployment.yaml")
    sh("kubectl apply -f k8s.deployments/app-deployment.yaml")
    sh("kubectl apply -f k8s.services/app-service.yaml")
    
    
}
