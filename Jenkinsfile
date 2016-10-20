node('build-slave') {

    // Project name will be passed in as a parameter
    def project = "${GCP_PROJECT_NAME}"
    def appName = 'app3'

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

}
