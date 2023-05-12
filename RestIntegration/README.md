
This is an example that exposes a rest API to post Data  to api/v2/reservation and get data from api/v2/reservation. 
This also has a single page application that runs on port 8080 and displays the data.

# Prequisit
1. Install docker
2. docker pull mongo:4.0.4
3. docker run -d -p 27017:27017 --name integration mongo:latest
# Build Web application
1. npm run build
* This steps copy the static content to  ../integration/src/main/resources/static

#Running Integration 
1. mvn spring-boot:run

