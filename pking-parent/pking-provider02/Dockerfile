FROM java:8
ADD target/pking-provider02.jar pking-provider02.jar
EXPOSE 6063
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/pking-provider02.jar"]