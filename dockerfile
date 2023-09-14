# Используем базовый образ Ubuntu
FROM ubuntu:latest

# Устанавливаем необходимые пакеты
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk-headless \
    maven \
    wget
# Собираем проект с помощью Maven
RUN mvn clean

# Копируем исходный код проекта в контейнер
COPY . /app

# Устанавливаем рабочую директорию
WORKDIR /app

# Запускаем тесты и генерируем отчет Allure
CMD mvn test