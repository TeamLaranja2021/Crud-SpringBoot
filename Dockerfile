## DOCKER FILE DA APLICACAO
FROM amazoncorretto:11

RUN mkdir -p /app/docker

ENV APP_NAME=Crud-SpringBoot.jar

COPY ${APP_NAME} out/artifacts/Crud_SpringBoot_jar/

EXPOSE 8080

ENTRYPOINT ["java", "-jar" , "out/artifacts/Crud_SpringBoot_jar/Crud-SpringBoot.jar"]





