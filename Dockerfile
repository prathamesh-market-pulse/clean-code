FROM openjdk:12-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /clean-code

CMD ./gradlew run