FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY ./build/libs/*.jar shop.jar
ENTRYPOINT ["shop.jar"]