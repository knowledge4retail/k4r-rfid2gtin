FROM maven:3.8-openjdk-11-slim as MAVEN_TOOL_CHAIN

WORKDIR /build

COPY ./src/ /build/src/
COPY ./pom.xml /build/pom.xml

RUN mvn install:install-file -Dfile="src/main/resources/epctagcoder-0.0.9-SNAPSHOT.jar"


RUN mvn --batch-mode --update-snapshots \
      -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN \
      -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss,SSS \
      clean install

FROM openjdk:11-jre
COPY --from=MAVEN_TOOL_CHAIN /build/target/rfid2gtin.jar /usr/app/app.jar

ENTRYPOINT ["java","-jar","/usr/app/app.jar"]
