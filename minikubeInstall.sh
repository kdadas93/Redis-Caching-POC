kubectl delete -f ./k8s/redis-poc/deployment-redis.yaml
mvn clean install
docker build -t redis-poc:1.0.0 .
docker run --name redis-poc --env=SPRING_PROFILES_ACTIVE=kubernetes -p 50198:8080 -d redis-poc:1.0.0
minikube image load redis-poc:1.0.0
kubectl apply -f ./k8s/redis-poc/deployment-redis.yaml