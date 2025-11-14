#############################
# Etapa 1: Build con Gradle #
#############################
FROM gradle:8.14.2-jdk21 AS build

# Copiamos todo el proyecto
COPY --chown=gradle:gradle . /app

WORKDIR /app

# Construcción del .jar (Spring Boot)
RUN gradle bootJar --no-daemon


#########################################
# Etapa 2: Runtime usando JDK 21 limpio #
#########################################
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiamos el jar generado desde la etapa anterior
COPY --from=build /app/build/libs/*.jar platzi_play1.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "platzi_play1.jar"]
