"# auth0-secured-boot-app" 

Read : https://github.com/mathewjustin/gkube-seeder/blob/master/README.md : For gke deployment steps

About this
----------
This app exposes an endpoint /names that will be secured by auth0 

developed based on the blog-post from auth0.
https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/


How to test
---------------

 * http://localhost:1111/users/sign-up
 
 {  "username": "testuser",     "password": "password" }
 
this will create a jwt token and return with header

http://localhost:1111/names

the jwt token which recieved in the previous step can be passed as 

Authorization    -  jwt  

Header to this request to get access.

----------------------------------------
