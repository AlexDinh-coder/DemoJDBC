FROM openjdk:17
COPY src/main/java/ /tmp
WORKDIR /tmp
CMD java com.java.Main2

