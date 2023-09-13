# Используйте базовый образ, который подходит для вашего Java-приложения
# Например, openjdk:11-jre-slim
FROM openjdk:11-jre-slim

# Установка необходимых пакетов и зависимостей, если это требуется
# RUN apt-get update && apt-get install -y ...

# Копирование JAR-файла с вашим приложением в контейнер
COPY target/stellarburgertestapi.jar /app/stellarburgertestapi.jar

# Установка рабочей директории
WORKDIR /app

