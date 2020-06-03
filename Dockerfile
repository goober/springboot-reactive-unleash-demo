FROM openjdk:11-jre-slim
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8080
ENV JAVA_OPTS=""
ENV JAVA_MEM_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS $JAVA_MEM_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
