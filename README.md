# ms-spring
 
## :information_source: Information 

Projects developed with Spring Boot, Spring Cloud, Docker, H2 database and PostGreSQL. Only the backend part was developed.

Each project was divided into:

- **hr-api-gateway-zuul**: will be responsible for connecting the client to Payroll, user and worker applications; for distributing random ports; by limiting the user's access to some features, and this depends on the group the user will be in.

- **hr-config-server**: will be responsible for connecting the database settings to the github repository: https://github.com/RamonBecker/ms-spring-configs

- **hr-eureka-server**: will be responsible for registering the microservices;

- **hr-oauth**: will be responsible for authenticating and authorizing users in applications;

- **hr-payroll**: will be responsible for returning the worked days and the Worker's salary;

- **hr-user**: will be responsible for returning users registered in the database.

- **hr-worker**: will be responsible for returning the workers registered in the database.

![servidorcliente](https://user-images.githubusercontent.com/44611131/144718999-8c7f52fd-07a7-4de8-9fa1-1be6b292db57.PNG)

The following technologies were used for the development of the projects:

- Feign for API requests between microservices;
- Ribbon for load balancing;
- Zuul Gateway API for routing and authorization;
- Hystrix for fault tolerance;
- OAuth and JWT for authentication and authorization;
- Centralized configuration server with data in Git repository;
- The generation of Docker containers for microservices and databases.


## 📌 Class Diagram
![diagrama de classe](https://user-images.githubusercontent.com/44611131/144337612-89508e9e-fe99-48e1-aa46-9ce04cf6e408.PNG)



## 🔨 POSTMAN

To test the end points you will need to install POSTMAN or Insomnia. I recommend installing POSTMAN. I'll leave the collections on the DRIVE to facilitate testing.

Download and import collections into your POSTMAN: 
```
https://drive.google.com/file/d/1ceruYB27Mfz1ogSXgfj1_M52Y1QUk4rP/view?usp=sharing
```

In POSTMAN you must add the following environment variables:
```
- api-gateway: http://localhost:8765
- config-host: http://localhost:8888
- client-name: myappname123
- client-secret: myappsecret123
- username: leia@gmail.com
- password: 123456
- token: On Windows you will have to add the environment variables:
   if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}

```

On Windows, you will have to add the environment variables:
```
GITHUB_USER (Username GITHUB) and GITHUB_PASS (Password GITHUB)
```

## ⚠️ Prerequisite
[![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/br/java/technologies/javase-downloads.html) >= 11 

![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

![Spring boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

![JPA-hibernate (1)](https://user-images.githubusercontent.com/44611131/136869865-0e3d7476-5128-4471-8817-8df40315b970.jpg)

![JSON Badge](https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white)

![POSTGRESQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white )

![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

![POSTMAN](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white )



##  🔧 Install 


![](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)


```
git clone https://github.com/RamonBecker/ms-spring.git
```

![](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
```
git clone https://github.com/RamonBecker/ms-spring.git
or install github https://desktop.github.com/ 
```



## ⚙️ Installing PostgreSQL

### ![LINUX](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)

Enter the following commands in the terminal.

```
sudo apt update
sudo apt install postgresql postgresql-contrib

```

**psql** is a command line used to interact with the PostgreSQL server. This will show the server version.

```
sudo -u postgres psql -c "SELECT version();"
```


To log into PostgreSQL as a postgre user, you can use psql. This can be done as shown below:

```
sudo su – postgres
```

To use Postgre, type in the terminal:
```
psql
```


This will grant access to PostgreSQl. If you want to leave the session, just use:
```
\q
```

#### Creating Roles and Users

To create a role, log into your Postgres account as you did before. Once in the Postgres console, you can create a new role (role) by typing:

```
createrole --interactive
```

The system will ask you to name the role and whether it has super user permission. Likewise, you can also create a new user with the command:
```
createuser –interactive
```
Alternatively, from the normal command prompt, you can use the command as shown below:
```
sudo -u postgres createuser –interactive
```

#### New Role Validation


To start, you need to create a Linux user with the same names as the Postgres Database and the role as well.
This can be done using a non-root account with sudo access. To create a new user on Linux, you can use a command similar to the one shown below:
```
sudo adduser testPostgres
```

Replace the name testPostgress with an appropriate name.

Once you have created the account, switch to it and connect to the database using:
```
sudo -u testPostgres psql

```

To switch to another database specify the database name using:
```
psql -d sampleUser
```

Once logged in, check the current database connection using:
```
\conninfo
```

![](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)

Download the installation package and follow the steps defined in the installation.

```
https://www.enterprisedb.com/downloads/postgres-postgresql-downloads 
```

## ⚙️ Accessing the H2 database


If you want to modify the user to access the database, modify the application.properties file.
Change the following:
```
spring.datasource.username=user
spring.datasource.password=password
```

Access in browser
```
http://localhost:8080/h2-console
```
If the JDBC URL is not configured, replace it with:
```
jdbc:h2:mem:testdb
```
![h2](https://user-images.githubusercontent.com/44611131/137225410-277de0f7-cf7c-48b1-b9e4-9be2d5b4ff43.PNG)


##   Run the following SQL script

```
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);


INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

```
## :zap: Technologies	

- Java
- JPA
- Spring Boot
- Feign
- Ribbon
- Hystrix
- OAuth
- Docker

## :memo: Developed features

- [x] CRUD User
- [x] CRUD Worker
- [X] CRUD Payment

## :technologist:	 Author

By Ramon Becker 👋🏽 Get in touch!

[<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/github.svg' alt='github' height='40'>](https://github.com/RamonBecker)  [<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/linkedin.svg' alt='linkedin' height='40'>](https://www.linkedin.com/in/https://www.linkedin.com/in/ramon-becker-da-silva-96b81b141//)
![Gmail Badge](https://img.shields.io/badge/-ramonbecker68@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:ramonbecker68@gmail.com)

