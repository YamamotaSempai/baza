FROM openjdk:11
MAINTAINER aidos.jantleu@gmail.com
COPY target/baza-*.war baza.jar
ENTRYPOINT ["java","-jar","/baza.jar"]