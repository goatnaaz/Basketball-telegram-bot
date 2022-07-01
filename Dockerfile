FROM adoptopenjdk/openjdk11:ubi
ENV BOT_NAME=test_btb_bot
ENV BOT_TOKEN=5424983064:AAH3QNgDT1GhG2lHuqN4I8whDjXDoj0Wpe8
ENV BOT_DB_USERNAME=BTB_db
ENV BOT_DB_PASSWORD=7410

ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]