# Используем базовый образ с Java и Maven для сборки проекта
FROM maven:3.8-jdk-11 AS build

# Копируем содержимое проекта в контейнер
COPY ./ /usr/src/app

# Устанавливаем рабочую директорию
WORKDIR /usr/src/app

# Собираем проект
RUN mvn clean install

# Используем базовый образ с Java для запуска приложения
FROM openjdk:11-jre-slim

# Копируем JAR-файл приложения из контейнера сборки
#COPY --from=build /usr/src/app/target/stellarburgertestapi.jar /app/stellarburgertestapi.jar

# Рабочая директория
WORKDIR /app

# Устанавливаем Allure CLI
RUN apt-get update && \
    apt-get install -y allure && \
    apt-get clean

# Запускаем Allure Serve для автоматической генерации отчета
CMD ["allure", "serve", "/app/allure-results"]
