FROM openjdk:8-stretch
LABEL version=0.0.2
VOLUME /logs
RUN mkdir /client
WORKDIR /client
ADD target/agonesarmaclient-0.0.2-SNAPSHOT-jar-with-dependencies.jar /client/agonesarmaclient.jar
CMD ["java","-jar","agonesarmaclient.jar","/logs/output.log"]
