FROM maven:3.6.3-jdk-11

WORKDIR /app

ADD . /app
RUN mvn clean package -Ddir=app
RUN mv target/neo4j-example-1.0.0.jar neo4j-example-1.0.0.jar

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/.urandom -jar neo4j-example-1.0.0.jar"]
