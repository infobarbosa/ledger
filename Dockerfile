FROM java:alpine

WORKDIR /app

ADD target/ledger-1.0-SNAPSHOT.jar ledger.jar

EXPOSE 8080

CMD [ "java", "-jar", "ledger.jar" ]