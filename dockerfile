# Используем базовый образ с Java и Maven
FROM maven:3.8-jdk-11

# Копируем содержимое проекта в контейнер
COPY ./ /app

COPY pom.xml /app/

# Устанавливаем рабочую директорию
WORKDIR /app

# Собираем проект и выполняем тесты
RUN mvn clean test