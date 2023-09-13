# Используем базовый образ с Java и Maven
FROM maven:3.8-jdk-11

# Копируем содержимое проекта в контейнер
COPY ./ /usr/src/app

COPY pom.xml /usr/src/app/

COPY ./target/allure-results /usr/src/app/target/allure-results

# Устанавливаем рабочую директорию
WORKDIR /app

# Собираем проект и выполняем тесты
RUN mvn clean test