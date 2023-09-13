# StellarBurgerTestAPI
# Проект автотестирования API Бургерной
Этот проект содержит автотесты для Бургерной. Автотесты разработаны с использованием Java, JUnit, Allure, Owner, Lombok,
RestAssured, JavaFaker.

## Зависимости

Для сборки и запуска проекта вам понадобятся следующие зависимости:
- Java Development Kit (JDK) 8 или выше
- Maven
- JUnit
- RestAssured
- JavaFaker
- Owner
- Lombok
- Allure

## Установка и запуск

1. Склонируйте репозиторий на свой локальный компьютер:
   https://github.com/IvanAndreevichPle/StellarBurgerTestAPI

2. Перейдите в папку проекта:
```bash
cd StellarBurgerTestAPI
```
3. Запустите автотесты с помощью Maven:
```bash
mvn test
```
4. Для просмотра отчета о выполнении автотестов выполните команду из терминала:
```bash
mvn allure:serve
```

## Структура проекта

- `src/main/java/api/client` - пакет для работы с клиентами и заказами
- `src/main/java/api/order`  - пакет для работы с игредиентами
- `src/main/java/api/user`   - пакет для генерации и работы с пользователями
- `src/main/java/api/utils`  - пакет с утилдитами

## Ваш вклад

Если вы хотите внести вклад в проект, пожалуйста, создайте форк репозитория,
внесите свои изменения и отправьте пул-реквест. Мы будем рады
рассмотреть ваши предложения и улучшения.

