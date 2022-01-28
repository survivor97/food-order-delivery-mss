FROM openjdk:11
ADD target/docker-food-order-delivery.jar docker-food-order-delivery.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-food-order-delivery.jar"]
