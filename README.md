# Hello! this is Vodofone DevOps Bootcamp Task

Tech: Java,Spring,Mongodb,Maven,Kubernetes,Docker,Git,ArgoCD,Jenkins,

It's simple web application, it's include get and post endpoints.

![bootcamp](https://github.com/yildirim7mustafa/vfBootcamp/assets/72528911/f887cb6b-0043-4b40-8410-05b1d600323b)

## MANUAL

* **Clone the repository**:
    ```bash
    git clone https://github.com/yildirim7mustafa/vfBootcamp.git
    cd vfBootcamp
    ```

For local development you can use mongodb with docker compose. 

* **Run mongodb with docker-compose**:
    ```bash
    docker compose up -d
    ```


*  **Setup Jenkins**:
    ```
    set up somewhere it doesn't matter where its setup, careful for docker socket
    ```

*  **Setup cluster**:
   ```
   minikube start
   ```


*  **Setup ArgoCD**:
   ```
   helm repo add argo https://argoproj.github.io/argo-helm
   helm repo update
   helm install argocd argo/argo-cd
   kubectl create ns argocd
   helm install argocd argo/argo-cd --namespace argocd
   kubectl port-forward svc/argocd-server -n argocd 8080:443
   ```

### Configure Jenkins & ArgoCD

This setup ensures that whenever Jenkins is triggered (manually or automatically), it will build the application, create a Docker image tagged with the commit ID, update the Kubernetes YAML file with the new image tag, and trigger Argo CD to deploy the new version automatically..

### Jenkins pipeline

![image](https://github.com/yildirim7mustafa/vfBootcamp/assets/72528911/89f6887e-e1b5-4ab3-870a-606351ec6182)


### ArgoCD 

![image](https://github.com/yildirim7mustafa/vfBootcamp/assets/72528911/6123185b-5a05-40fa-8dfd-01a41eeaf09a)

### Prometheus Kubernetes Stack

*  **Setup Monitoring**:
   ```
   kubectl create namespace monitoring
   helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
   helm repo update
   helm install kubeprostack --namespace monitoring prometheus-community/kube-prometheus-stack
   ```

*  **Check monitoring tools**:
   ```
   kubectl --namespace monitoring port-forward svc/kubeprostack-kube-promethe-prometheus 9090
   kubectl --namespace monitoring port-forward svc/kubeprostack-kube-promethe-alertmanager 9093
   kubectl --namespace monitoring port-forward svc/kubeprostack-grafana 8080:80
   username: admin
   password: prom-operator
   ```
Prometheus
![image](https://github.com/yildirim7mustafa/vfBootcamp/assets/72528911/e3895507-fcff-4eeb-bcbe-4f924df5fd45)
Grafana
![image](https://github.com/yildirim7mustafa/vfBootcamp/assets/72528911/612ff92d-e088-4e73-a9d5-b499357c1369)






    
