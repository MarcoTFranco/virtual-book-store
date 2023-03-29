FROM azul/zulu-openjdk-alpine:17-jre-latest

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080