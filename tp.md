# Installation de WSL — Guide rapide

## Étape 1 — Ouvrir PowerShell en administrateur
Clique droit sur le menu Démarrer → Windows PowerShell (Admin) ou Terminal Windows (Admin).

## Étape 2 — Activer manuellement WSL
```powershell
PS C:\WINDOWS\system32> dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart

Outil Gestion et maintenance des images de déploiement
Version : 10.0.26100.5074

Version de l’image : 10.0.26200.7171

Activation de la ou des fonctionnalités
[==========================100.0%==========================]
L’opération a réussi.

PS C:\WINDOWS\system32> dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart

Outil Gestion et maintenance des images de déploiement
Version : 10.0.26100.5074

Version de l’image : 10.0.26200.7171

Activation de la ou des fonctionnalités
[==========================100.0%==========================]
L’opération a réussi.
PS C:\WINDOWS\system32>

## Étape 3 — Installer WSL
C:\Users\Admin>wsl.exe --list --online
Sous-système Windows pour Linux devez être mis à jour vers la dernière version pour continuer. Vous pouvez effectuer une mise à jour en exécutant « wsl.exe --update ».
Pour plus d’informations, visitez https://aka.ms/wslinstall

Appuyez sur une touche pour installer Sous-système Windows pour Linux.
Appuyez sur CTRL-C ou fermez cette fenêtre pour annuler.
Cette invite expirera dans 60 secondes.
L’opération demandée nécessite une élévation.
Téléchargement en cours : Sous-système Windows pour Linux 2.6.2
Installation en cours : Sous-système Windows pour Linux 2.6.2
Sous-système Windows pour Linux 2.6.2 a été installé.
L’opération a réussi.

Voici la liste des distributions valides qui peuvent être installées.
Installez à l’aide de 'wsl.exe --install <Distro>'.

NAME                            FRIENDLY NAME
Ubuntu                          Ubuntu
Ubuntu-24.04                    Ubuntu 24.04 LTS
openSUSE-Tumbleweed             openSUSE Tumbleweed
openSUSE-Leap-16.0              openSUSE Leap 16.0
SUSE-Linux-Enterprise-15-SP7    SUSE Linux Enterprise 15 SP7
SUSE-Linux-Enterprise-16.0      SUSE Linux Enterprise 16.0
kali-linux                      Kali Linux Rolling
Debian                          Debian GNU/Linux
AlmaLinux-8                     AlmaLinux OS 8
AlmaLinux-9                     AlmaLinux OS 9
AlmaLinux-Kitten-10             AlmaLinux OS Kitten 10
AlmaLinux-10                    AlmaLinux OS 10
archlinux                       Arch Linux
FedoraLinux-43                  Fedora Linux 43
FedoraLinux-42                  Fedora Linux 42
Ubuntu-20.04                    Ubuntu 20.04 LTS
Ubuntu-22.04                    Ubuntu 22.04 LTS
OracleLinux_7_9                 Oracle Linux 7.9
OracleLinux_8_10                Oracle Linux 8.10
OracleLinux_9_5                 Oracle Linux 9.5
openSUSE-Leap-15.6              openSUSE Leap 15.6
SUSE-Linux-Enterprise-15-SP6    SUSE Linux Enterprise 15 SP6

C:\Users\Admin>wsl --install -d Ubuntu-24.04
Téléchargement : Ubuntu 24.04 LTS
Installation : Ubuntu 24.04 LTS
La distribution a été installée. Il peut être lancé via 'wsl.exe -d Ubuntu-24.04'
Lancement : Ubuntu-24.04...
Provisioning the new WSL instance Ubuntu-24.04
This might take a while...
Create a default Unix user account: hamdi
New password:
Retype new password:
passwd: password updated successfully
To run a command as administrator (user "root"), use "sudo <command>".
See "man sudo_root" for details.
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$

Minikube standalone (pour CKAD rapide)
1. Mise à jour du système
sudo apt update && sudo apt upgrade -y # Mise à jour des dépôts et packages
sudo apt autoremove #Nettoyage des anciens paquets obsolètes
## Installation Docker
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo apt install -y docker.io && sudo usermod -aG docker $USER && newgrp docker
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done

# Basculer iptables en mode legacy

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo update-alternatives --set iptables /usr/sbin/iptables-legacy
update-alternatives: using /usr/sbin/iptables-legacy to provide /usr/sbin/iptables (iptables) in manual mode
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo update-alternatives --set ip6tables /usr/sbin/ip6tables-legacy
update-alternatives: using /usr/sbin/ip6tables-legacy to provide /usr/sbin/ip6tables (ip6tables) in manual mode
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo service docker restart

# Minikube + kubectl
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd6
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   206  100   206    0     0   1013      0 --:--:-- --:--:-- --:--:--  1019

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo install minikube-linux-amd6 /usr/local/bin/minikube

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ curl -LO "https://dl.k8s.io/release/$(curl -L -
https://cdn.dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
curl: option -: is unknown
curl: try 'curl --help' or 'curl --manual' for more information
bash: https://cdn.dl.k8s.io/release/stable.txt: No such file or directory
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   138  100   138    0     0    728      0 --:--:-- --:--:-- --:--:--   726
100   238  100   238    0     0    573      0 --:--:-- --:--:-- --:--:--   573

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ sudo install kubectl /usr/local/bin/kubectl
# Start
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ minikube start --driver=docker --cpus=2 --memory=4096
😄  minikube v1.37.0 on Ubuntu 24.04 (kvm/amd64)
✨  Using the docker driver based on existing profile
👍  Starting "minikube" primary control-plane node in "minikube" cluster
🚜  Pulling base image v0.0.48 ...
🏃  Updating the running docker "minikube" container ...
❗  Failing to connect to https://registry.k8s.io/ from inside the minikube container
💡  To pull new external images, you may need to configure a proxy: https://minikube.sigs.k8s.io/docs/reference/networking/proxy/
🐳  Preparing Kubernetes v1.34.0 on Docker 28.4.0 ...
🔎  Verifying Kubernetes components...
    ▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
🌟  Enabled addons: default-storageclass, storage-provisioner
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ kubectl get nodes
NAME       STATUS   ROLES           AGE     VERSION
minikube   Ready    control-plane   7m48s   v1.34.0

3. Alias CKAD (essentiels)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ echo 'alias k="kubectl"' >> ~/.bashrc
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ echo 'alias kk="kubectl config set-context --current --namespace"' >> ~/.bashrc
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ echo 'alias km="minikube"' >> ~/.bashrc
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ source ~/.bashrc
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k version --client
Client Version: v1.34.2
Kustomize Version: v5.7.1

# Minikube fonctionne 
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ minikube status
minikube
type: Control Plane
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Configured

# kubectl fonctionne
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k version --client
Client Version: v1.34.2
Kustomize Version: v5.7.1

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get nodes
NAME       STATUS   ROLES           AGE   VERSION
minikube   Ready    control-plane   13m   v1.34.0
LUNDI 3 — Fondamentaux + Pods + Deployments + Services (2h)
1. Pods impératifs (20 min)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k run nginx --image=nginx --restart=Never
pod/nginx created

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get pods -o wide
NAME    READY   STATUS    RESTARTS   AGE   IP           NODE       NOMINATED NODE   READINESS GATES
nginx   1/1     Running   0          27s   10.244.0.6   minikube   <none>           <none>

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k describe pod nginx
Name:             nginx
Namespace:        default
Priority:         0
Service Account:  default
Node:             minikube/192.168.49.2
Start Time:       Sun, 07 Dec 2025 22:17:09 +0100
Labels:           run=nginx
Annotations:      <none>
Status:           Running
IP:               10.244.0.6
IPs:
  IP:  10.244.0.6
Containers:
  nginx:
    Container ID:   docker://a265368b5690e1ddbf7c4dc65b93c870bc7457bdaeadb9c23e2dd55beb8e3dda
    Image:          nginx
    Image ID:       docker-pullable://nginx@sha256:553f64aecdc31b5bf944521731cd70e35da4faed96b2b7548a3d8e2598c52a42
    Port:           <none>
    Host Port:      <none>
    State:          Running
      Started:      Sun, 07 Dec 2025 22:17:20 +0100
    Ready:          True
    Restart Count:  0
    Environment:    <none>
    Mounts:
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-8gvmn (ro)
Conditions:
  Type                        Status
  PodReadyToStartContainers   True
  Initialized                 True
  Ready                       True
  ContainersReady             True
  PodScheduled                True
Volumes:
  kube-api-access-8gvmn:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    Optional:                false
    DownwardAPI:             true
QoS Class:                   BestEffort
Node-Selectors:              <none>
Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Type    Reason     Age   From               Message
  ----    ------     ----  ----               -------
  Normal  Scheduled  49s   default-scheduler  Successfully assigned default/nginx to minikube
  Normal  Pulling    49s   kubelet            Pulling image "nginx"
  Normal  Pulled     38s   kubelet            Successfully pulled image "nginx" in 10.374s (10.374s including waiting). Image size: 151863538 bytes.
  Normal  Created    38s   kubelet            Created container: nginx
  Normal  Started    38s   kubelet            Started container nginx
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k logs nginx
/docker-entrypoint.sh: /docker-entrypoint.d/ is not empty, will attempt to perform configuration
/docker-entrypoint.sh: Looking for shell scripts in /docker-entrypoint.d/
/docker-entrypoint.sh: Launching /docker-entrypoint.d/10-listen-on-ipv6-by-default.sh
10-listen-on-ipv6-by-default.sh: info: Getting the checksum of /etc/nginx/conf.d/default.conf
10-listen-on-ipv6-by-default.sh: info: Enabled listen on IPv6 in /etc/nginx/conf.d/default.conf
/docker-entrypoint.sh: Sourcing /docker-entrypoint.d/15-local-resolvers.envsh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/20-envsubst-on-templates.sh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/30-tune-worker-processes.sh
/docker-entrypoint.sh: Configuration complete; ready for start up
2025/12/07 21:17:20 [notice] 1#1: using the "epoll" event method
2025/12/07 21:17:20 [notice] 1#1: nginx/1.29.3
2025/12/07 21:17:20 [notice] 1#1: built by gcc 14.2.0 (Debian 14.2.0-19)
2025/12/07 21:17:20 [notice] 1#1: OS: Linux 6.6.87.2-microsoft-standard-WSL2
2025/12/07 21:17:20 [notice] 1#1: getrlimit(RLIMIT_NOFILE): 1048576:1048576
2025/12/07 21:17:20 [notice] 1#1: start worker processes
2025/12/07 21:17:20 [notice] 1#1: start worker process 29
2025/12/07 21:17:20 [notice] 1#1: start worker process 30
2025/12/07 21:17:20 [notice] 1#1: start worker process 31
2025/12/07 21:17:20 [notice] 1#1: start worker process 32
2025/12/07 21:17:20 [notice] 1#1: start worker process 33
2025/12/07 21:17:20 [notice] 1#1: start worker process 34
2025/12/07 21:17:20 [notice] 1#1: start worker process 35
2025/12/07 21:17:20 [notice] 1#1: start worker process 36
2025/12/07 21:17:20 [notice] 1#1: start worker process 37
2025/12/07 21:17:20 [notice] 1#1: start worker process 38
2025/12/07 21:17:20 [notice] 1#1: start worker process 39
2025/12/07 21:17:20 [notice] 1#1: start worker process 40
2025/12/07 21:17:20 [notice] 1#1: start worker process 41
2025/12/07 21:17:20 [notice] 1#1: start worker process 42
2. Deployments (30 min)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k create deployment web --image=nginx
deployment.apps/web created

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k scale deployment web --replicas=3
deployment.apps/web scaled

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k set image deployment/web nginx=nginx:1.25
deployment.apps/web image updated

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k rollout status deployment/web
deployment "web" successfully rolled out

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k rollout history deployment/web
deployment.apps/web
REVISION  CHANGE-CAUSE
1         <none>
2         <none>

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k rollout undo deployment/web
deployment.apps/web rolled back

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get deployments -o wide
NAME   READY   UP-TO-DATE   AVAILABLE   AGE     CONTAINERS   IMAGES   SELECTOR
web    3/3     3            3           2m16s   nginx        nginx    app=web
3. Services (30 min)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k expose deployment web --type=NodePort --port=80
service/web exposed

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k expose deployment web --type=ClusterIP --port=80 --name=web-internal
service/web-internal exposed

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get svc  # verifier les deux service
NAME           TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)        AGE
kubernetes     ClusterIP   10.96.0.1        <none>        443/TCP        25h
web            NodePort    10.108.252.124   <none>        80:32679/TCP   2m11s
web-internal   ClusterIP   10.102.66.90     <none>        80/TCP         110s
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k describe svc web
Name:                     web
Namespace:                default
Labels:                   app=web
Annotations:              <none>
Selector:                 app=web
Type:                     NodePort
IP Family Policy:         SingleStack
IP Families:              IPv4
IP:                       10.108.252.124
IPs:                      10.108.252.124
Port:                     <unset>  80/TCP
TargetPort:               80/TCP
NodePort:                 <unset>  32679/TCP
Endpoints:                10.244.0.15:80,10.244.0.13:80,10.244.0.14:80
Session Affinity:         None
External Traffic Policy:  Cluster
Internal Traffic Policy:  Cluster
Events:                   <none>
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ km service web --url   #Accès au Service
http://127.0.0.1:40059
❗  Because you are using a Docker driver on linux, the terminal needs to be open to run it.
MERCREDI — ConfigMaps + Secrets + Probes + Multi-containers (2h)
1. ConfigMaps / Secrets (30 min)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k create configmap app-config --from-literal=ENV=prod -o yaml --dry-run=client > configmap.yaml

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k create secret generic db-secret --from-literal=password=admin123 -o yaml --dry-run=client > secret.yaml

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k apply -f configmap.yaml -f secret.yaml
configmap/app-config created
secret/db-secret created
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get configmap,secret
NAME                         DATA   AGE
configmap/app-config         1      14s
configmap/kube-root-ca.crt   1      26h

NAME               TYPE     DATA   AGE
secret/db-secret   Opaque   1      14s

## Pod utilisant ConfigMap + Secret
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ vi pod-config.yaml
apiVersion: v1
kind: Pod
metadata:
  name: app-pod
spec:
  containers:
  - name: app
    image: nginx
    env:
    - name: ENV
      valueFrom:
        configMapKeyRef:
          name: app-config
          key: ENV
    - name: DB_PASSWORD
      valueFrom:
        secretKeyRef:
          name: db-secret
          key: password

hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k apply -f pod-config.yaml && k get pod -o yaml | grep -A5 ENV
pod/app-pod unchanged
        {"apiVersion":"v1","kind":"Pod","metadata":{"annotations":{},"name":"app-pod","namespace":"default"},"spec":{"containers":[{"env":[{"name":"ENV","valueFrom":{"configMapKeyRef":{"key":"ENV","name":"app-config"}}},{"name":"DB_PASSWORD","valueFrom":{"secretKeyRef":{"key":"password","name":"db-secret"}}}],"image":"nginx","name":"app"}]}}

    creationTimestamp: "2025-12-07T21:39:07Z"
    generation: 1
    name: app-pod
    namespace: default
    resourceVersion: "5799"
--
      - name: ENV
        valueFrom:
          configMapKeyRef:
            key: ENV
            name: app-config
      - name: DB_PASSWORD
        valueFrom:
          secretKeyRef:
            key: password
2. Probes + Resources (30 min)
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ vi deployment-probes.yaml
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k apply -f deployment-probes.yaml && k describe pod
deployment.apps/probed-app created
Pods & Descriptions : Name:             app-pod
Namespace:        default
Priority:         0
Service Account:  default
Node:             minikube/192.168.49.2
Start Time:       Sun, 07 Dec 2025 22:39:07 +0100
Labels:           <none>
Annotations:      <none>
Status:           Running
IP:               10.244.0.16
IPs:
  IP:  10.244.0.16
Containers:
  app:
    Container ID:   docker://2be40ee0a1b66c2d72c6c25dbd9088386d67fdf856121e902d7b90583ae9e00c
    Image:          nginx
    Image ID:       docker-pullable://nginx@sha256:553f64aecdc31b5bf944521731cd70e35da4faed96b2b7548a3d8e2598c52a42
    Port:           <none>
    Host Port:      <none>
    State:          Running
      Started:      Sun, 07 Dec 2025 22:39:09 +0100
    Ready:          True
    Restart Count:  0
    Environment:
      ENV:          <set to the key 'ENV' of config map 'app-config'>  Optional: false
      DB_PASSWORD:  <set to the key 'password' in secret 'db-secret'>  Optional: false
    Mounts:
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-wfdfx (ro)
Conditions:
  Type                        Status
  PodReadyToStartContainers   True
  Initialized                 True
  Ready                       True
  ContainersReady             True
  PodScheduled                True
Volumes:
  kube-api-access-wfdfx:
    Type:                    Projected
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    Optional:                false
    DownwardAPI:             true
QoS Class:                   BestEffort
Node-Selectors:              <none>
Tolerations:
  node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
  node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Normal  Scheduled  8m9s   Successfully assigned default/app-pod to minikube
  Normal  Pulling    8m9s   Pulling image "nginx"
  Normal  Pulled     8m8s   Successfully pulled image "nginx"
  Normal  Created    8m8s   Created container: app
  Normal  Started    8m8s   Started container app
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ vi pod-sidecar.yaml
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k apply -f pod-sidecar.yaml && k logs sidecar-pod -c logger
pod/sidecar-pod created
Error from server (BadRequest): container "logger" in pod "sidecar-pod" is waiting to start: ContainerCreating
hamdi@DESKTOP-6O8TS4A:/mnt/c/Users/Admin$ k get pod sidecar-pod
NAME          READY   STATUS    RESTARTS   AGE
sidecar-pod   2/2     Running   0          65s










