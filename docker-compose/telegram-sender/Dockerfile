FROM openjdk:17

COPY build/libs/telegram-sender-*[^tesourcplain].jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]

