FROM java:8-alpine
MAINTAINER "wtrue"
ADD rical.backend.provider-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 10000
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "app.jar"]
