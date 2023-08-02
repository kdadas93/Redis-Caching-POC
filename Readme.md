Uruchomienie redis



docker build -t redis-poc .		buduje obraz dockera
docker build -t redis-poc:2.0.0 .

docker images

minikube image load redis-poc	ładuje obraz z dockera do minikube
minikube image load redis-poc:2.0.0

minikube image ls

kubectl apply -f deployment-redis.yaml



'kubectl apply -f postgres.yaml'
'kubectl apply -f pgadmin.yaml'
Na macu należy otworzyć tunel: https://minikube.sigs.k8s.io/docs/handbook/accessing/

minikube service redis-poc --url

Sprawdzić port: ps -ef | grep docker@127.0.0.1

kubectl scale --replicas=2 deployment.apps/redis-poc

LOAD BALANCER:
W yaml  	externalIPs:
- 192.168.49.2 (minikube ip)

minikube tunnel





