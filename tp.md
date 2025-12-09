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





