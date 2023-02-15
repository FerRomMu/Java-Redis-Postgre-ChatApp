*This app is currently in development. For now only allows you to log in and sign up with authentication.*

# Java-Redis-Postgre-ChatApp

Java Api rest with spring boot that has authentication using spring security and jwt token.

You can log in and sign up with a new user.

Information is saved in a posgreSql db that is dockerized.

A client is available [here](https://github.com/FerRomMu/React-ChatApp-Front) made on Javascript with ReactJs, react-router-dom, formik and Chakra UI.

## Run
To run the project, you need to clone this repository as well as the [client repository](https://github.com/FerRomMu/React-ChatApp-Front) .

### Run docker compose
Go to the project directory and run:
```bash
docker-compose up
```
Now you have postgreSQL on localhost:5432 and pgAdmin on localhost:5050.

### Connect database with pgAdmin
Go to localhost:5050 and create a server to connect the database. Name it 'jwt_security' for consistency with the application's configuration, for the credentials use "username: username" and "password: password".

### Run project (Api)
Now you can run the project with an IDE or use gradle:
```bash
./gradlew bootRun
```
It will be running on localhost:8081 (you can change it on application.properties if needed before execution).

### Run client
Go to the client project and use:
```bash
npm start
```
Client will be on localhost:3030.

By default the application has a create-drop configuration (application.yml) so every time you run the project it will delete all the information on your database (that is saved on a volume created by docker). If you want to preserve the data, you can change the configuration to "update".
