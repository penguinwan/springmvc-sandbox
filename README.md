# Introduction
- this is for me to learn about spring-mvc
- to build war from scratch

# Roadmap
- minimal war with only index.html
- remove version in the war name `springmvc-sandbox`
- add a servlet with only GET

# How to deploy
- open terminal and type `mvn package` then `springmvc-sandbox.war` will be generated at target folder
- copy the `war` to apache tomcat or any servlet container, in the case of apache tomcat, it will be at `/usr/local/Cellar/tomcat/9.0.5/libexec`

# How to access
- without changing apache tomcat default configuration, this web application can be accessed via this url `http://localhost:8080/springmvc-sandbox`
- the web application hello world servlet can be accessed via `http://localhost:8080/springmvc-sandbox/helloworld`