FROM java:8
ADD target/pking-provider.jar pking-provider.jar
EXPOSE 6062
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/pking-provider.jar"]