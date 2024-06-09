pipeline {
    agent any
    tools{
        maven 'maven_3_9_2'
    }
    stages {
       stage("Clean Up"){
            steps{
                deleteDir()
            }
        }
        stage("Clone Repo & build"){
            steps{
               cleanWs()
               sh 'git clone --branch main https://yildirim7mustafa:<my-personal-access-token>@github.com/yildirim7mustafa/vfBootcamp.git'
               echo "Clone repo success"
               dir("vfBootcamp/"){
                    script {
                        sh 'mvn clean install'
                        echo "Build success"
                    }
               }
            }
        }
        stage("Build"){
            steps{
                dir("vfBootcamp/"){
                    script {
                        def commitId = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                        echo "Commit ID: ${commitId}"
                        env.COMMIT_ID = commitId   
                        sh "docker build . -t vfbootcamp:${env.COMMIT_ID}" 
                        echo "build success"
                    }
                }
            }
        }
        stage('PushtoACR') {
            steps {
                script {
                    // Docker login
                    sh 'docker login -u yildirim7mustafa -p "my-dockerhub-password" '
                    sh "docker tag vfbootcamp:${env.COMMIT_ID} yildirim7mustafa/vfbootcamp:${env.COMMIT_ID}"
                    sh "docker push yildirim7mustafa/vfbootcamp:${env.COMMIT_ID}"
                    sh 'docker system prune -af'
                }
            }
        }
        
        stage('Update Deployment YAML') {
            steps {
                
                dir("vfBootcamp"){
                    script {
                       dir("kubernetes-files"){
                           sh "sed -i 's#yildirim7mustafa/vfbootcamp:.*#yildirim7mustafa/vfbootcamp:${env.COMMIT_ID}#' app.yaml"
                       } 
                    sh 'git add kubernetes-files/app.yaml'
                    sh 'git commit -m "image tag updated" '
                    sh 'git checkout main'
                    sh 'git push'
                }
                }
    
            }
        }

    }
        
    }
