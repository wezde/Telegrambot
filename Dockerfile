FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_wezde_bot
ENV BOT_TOKEN=5062681583:AAGn-2xHvtYqHFlc5dE6jbA2PBkmVHtqE60
COPY ${JAR_FILE} app.jar
ENTRYPOINT["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]