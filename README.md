## spring4-webapp

This is a simple web application which shows various ways of authorization in Spring Security:
* web security
* global method security
* web security configured through annotations, described in two posts on my blog: [part 1](http://mwenus.blogspot.com/2014/02/spring-security-authorization-on.html) and improved [part 2](http://mwenus.blogspot.com/2014/03/spring-security-authorization-on.html).

If you want to see the code for the first post, checkout branch `1.0`. If you want the code for the second post, use branch `master`.

To start the application simply run:
```bash
mvn tomcat7:run
```
and browse to [http://localhost:8080/spring4-webapp/](http://localhost:8080/spring4-webapp/)

There are three users in this application:
* login: user, pass: user, roles: ROLE_USER
* login: manager, pass: manager, roles: ROLE_MANAGER
* login: admin, pass: admin, roles: ROLE_ADMIN

There is also a `RoleHierarchy`: ROLE_ADMIN > ROLE_MANAGER > ROLE_USER. Thus user has only access to his own actions, manager has access to manager's and user's actions, admin has access to everything.
