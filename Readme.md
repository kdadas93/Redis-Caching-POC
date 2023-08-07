Uruchomienie redis

docker run --name redis_persist -p 6379:6379 -d redis redis-server --save 60 1 --loglevel warning

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

docker run --hostname=15679f1b71de --mac-address=02:42:ac:11:00:06 --env=SPRING_PROFILES_ACTIVE=kubernetes --env=PATH=/opt/openjdk-17/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --env=JAVA_HOME=/opt/openjdk-17 --env=JAVA_VERSION=17-ea+14 --workdir=/app -p 8080 --runtime=runc -d redis-poc:2.0.0





