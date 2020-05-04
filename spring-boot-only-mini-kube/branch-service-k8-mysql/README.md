# SpringBoot : Spring Boot + Hibernate+ Mysql+ docker 


### Deploying SpringBoot Applications

**spring-bank-branch-service-docker**: This module demonstrates running SpringBoot application in Docker container.

#### How to run?

spring-bank-branch-service-docker> mvn spring-boot:run

## Running on Docker container

Build the docker image using maven

spring-bank-branch-service-docker> mvn clean package docker:build

### Running MySQL and Application containers individually


*Run mysql :*

docker run -d --name branch-service -e MYSQL_ROOT_PASSWORD=secret123 -e MYSQL_DATABASE=branch-service -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=secret mysql:latest

*Run application linking to demo-mysql container:*

docker run -d --name spring-bank-branch-service-kubernetes -e "SPRING_PROFILES_ACTIVE=docker" --link branch-service:mysql -p 8080:8080 rkp/spring-bank-branch-service-kubernetes

docker logs -f <first 3 letter of container id>

http://localhost:8080/branch


### Running MySQL and Application using docker-compose


Navigate to the directory where docker-compose.yml file is there.

spring-bank-branch-service-docker> docker-compose up
http://localhost:8080/branch
http://localhost:8080/
http://127.0.0.1:8080/branch

#if ther is issue in starting minikube delete
minikube delete 
#then start otherwise start directly
minikube start
or 
minikube start --vm-driver=virtualbox
minikube start --driver=docker
minikube start --alsologtostderr
minikube config set vm-driver virtualbox
kubectl config use-context minikube
kubectl cluster-info
minikube dashboard

We have to make sure here that we trigger the build process on the Docker host of the Minikube cluster, otherwise, Minikube won't find the images later during deployment. Furthermore, the workspace on our host must be mounted into the Minikube VM:


$> minikube ssh

/g/JAVA/microservices/spring-microservices/spring-boot-only-mini-kube/spring-bank-branch-service-kubernetes
$> cd /g/JAVA/microservices/spring-microservices/spring-boot-only-mini-kube/spring-bank-branch-service-kubernetes
$> docker build --file=Dockerfile --tag=rkp/spring-bank-branch-service-kubernetes:latest --rm=true .
  
kubectl run kube-demo1 --image=rkp/spring-bank-branch-service-kubernetes:latest --port=8080 --image-pull-policy Never
kubectl run kube-demo --image=rkp/spring-bank-branch-service-kubernetes --port=8080