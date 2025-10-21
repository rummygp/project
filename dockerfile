FROM openjdk:21-jdk
COPY target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/project-0.0.1-SNAPSHOT.jar"]