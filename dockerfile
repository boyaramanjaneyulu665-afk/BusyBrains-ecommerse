FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
# Add -Xmx to limit memory so the free host doesn't kill the process
ENTRYPOINT ["java", "-Xmx300m", "-jar", "/app.jar"]