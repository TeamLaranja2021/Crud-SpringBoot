## DOCKER FILE DA APLICACAO
ENV APP_NAME=springcrud.jar

COPY ${APP_NAME} /app/springcrud/

EXPOSE 8081

ENTRYPOINT ["java", "-jar" , "/app/springcrud/${APP_NAME}"]





