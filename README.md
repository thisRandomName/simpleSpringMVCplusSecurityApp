# simpleSpringMVCplusSecurityApp
Registration, Log In, CRUD using Spring MVC and Spring Security

This simple app implements 3 roles :
- ADMIN -> CRUD for the entity "user": Log In with username:admin,password:admin 
- TEACHER -> CRUD for the entity "course" :Log In with username:teacher,password:teacher
- USER -> just Logs In with username:user,password:user


**NOTE: When sb registers as a new user, they cannot Log In immediately after registration !! 
You must Log In as "ADMIN" in order to **edit** the new user's profile and SET the role "USER"(or "TEACHER" or "ADMIN") to them, 
so that the new user can securely Log In.

Created using Spring MVC with Hibernate, Spring Security and mySQL(for the database file)
