#pull base image
FROM java:8

#expose port 8080
EXPOSE 8080

#default command
CMD java -jar app.jar

#copy hello world to docker image
ADD target/catering-app-0.0.1-SNAPSHOT.jar app.jar
