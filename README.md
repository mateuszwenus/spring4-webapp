## spring4-webapp

This is a simple web application which demonstrates various ways of authorization:
* web security
* global method security
* web security configured through annotations, described on my blog

To start the application simply run:
```bash
$mvn tomcat7:run
```
and browse to http://localhost:8080/spring4-webapp/

There are three users in this application:
* login: user, pass: user, roles: ROLE_USER
* login: manager, pass: manager, roles: ROLE_MANAGER
* login: admin, pass: admin, roles: ROLE_ADMIN

There is also a `RoleHierarchy`: ROLE_ADMIN > ROLE_MANAGER > ROLE_USER. Thus user has only access to his own actions, manager has access to manager's and user's actions, admin has access to everything.
