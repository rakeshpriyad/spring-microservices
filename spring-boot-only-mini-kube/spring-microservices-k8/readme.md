kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
1. mvn clean install
2. 
minikube docker-env
minikube -p minikube docker-env | Invoke-Expression
$ kubectl apply -f kubernetes/mongodb-configmap.yaml
3. 
$ kubectl apply -f kubernetes/mongodb-secret.yaml

kubectl delete -n default deployment mongodb

$ kubectl apply -f kubernetes/mongodb-deployment.yaml

docker image rm piomin/department:1.0
docker image rm piomin/department:1.1
docker image rm piomin/employee:1.0
docker image rm piomin/employee:1.0
docker image rm piomin/organization:1.0
docker image rm piomin/organization:1.1

cd employee-service
$ docker build -t piomin/employee:1.1 .
$ cd ../department-service
$ docker build -t piomin/department:1.1 .
$ cd ../organization-service
$ docker build -t piomin/organization:1.1 .
kubectl get deployments

kubectl delete -n default deployment employee
kubectl delete -n default deployment department
kubectl delete -n default deployment organization
kubectl delete configmap employee
kubectl delete secrets employee
kubectl apply -f kubernetes/employee-configmap.yaml
kubectl apply -f kubernetes/employee-secret.yaml
$ kubectl apply -f kubernetes\employee-deployment.yaml

$ kubectl apply -f kubernetes\department-configmap.yaml
$ kubectl apply -f kubernetes\department-secret.yaml
$ kubectl apply -f kubernetes\department-deployment.yaml

$ kubectl apply -f kubernetes\organization-configmap.yaml
$ kubectl apply -f kubernetes\organization-secret.yaml
$ kubectl apply -f kubernetes\organization-deployment.yaml
$ kubectl apply -f kubernetes\ingress.yaml

kubectl describe ing gateway-ingress
kubectl get svc

https://piotrminkowski.com/2018/08/02/quick-guide-to-microservices-with-kubernetes-spring-boot-2-0-and-docker/