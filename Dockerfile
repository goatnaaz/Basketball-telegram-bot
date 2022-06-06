FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_btb_bot
ENV BOT_TOKEN=5342919530:AAGJvKvdw_h1fiSKQh5jLbR_iVR8n2pvtdg
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
