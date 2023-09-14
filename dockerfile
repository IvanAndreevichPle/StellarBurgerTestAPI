# Используем базовый образ с Java и Maven
FROM maven:3.8.4-openjdk-11-slim

# Устанавливаем дополнительные пакеты (если необходимо)
# RUN apt-get update && apt-get install -y wget

# Создаем рабочую директорию
WORKDIR /app

# Копируем только файлы, необходимые для установки зависимостей
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем все остальные файлы проекта
COPY . .

# Собираем проект с помощью Maven
RUN mvn test allure:report