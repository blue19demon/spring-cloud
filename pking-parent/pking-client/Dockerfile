FROM java:8
ADD target/pking-client.jar pking-client.jar
EXPOSE 9999
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/pking-client.jar"]