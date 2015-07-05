## Running the app

### 1. Clone the repository

$ git clone https://github.com/rodrigodealer/codurance.git

#### 2. Vagrant (with ansible)

[Ansible installation](http://docs.ansible.com/intro_installation.html#getting-ansible)

$ vagrant up

After a while (this can take a **while** since it will download a lot of dependencies)

$ vagrant ssh

$ cd /vagrant/target/scala-2.11

$ java -jar codurance-assembly-1.0.jar

#### 2. In local machine

$ chmod +x sbt

$ ./sbt assembly

$ java -jar codurance-assembly-1.0.jar