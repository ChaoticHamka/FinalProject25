# Тестируемый автоматизированный фреймворк
## "РИА Новости"

> **Автоматизированный проект тестирования онлайн-сервиса "РИА Новости"**, включающий как UI-, так и API-тесты, реализованные на Java с использованием современных инструментов и библиотек.

## Описание

Тестовый фреймворк покрывает два уровня:
- **UI-тестирование** (через браузер, с проверкой состояния элементов, валидации, поведения форм);
- **API-тестирование** (валидация ответов сервера при различных сценариях авторизации).

## Что покрывают тесты

### ✅ UI

Тестируются компоненты формы логина и восстановления пароля:
- Активность кнопок при загрузке;
- Валидация полей email и пароля;
- Появление/исчезновение ошибок;
- Поведение при вводе невалидных значений;
- Сохранение данных после закрытия формы.

### ✅ API

Проверяются различные сценарии обращения к endpoint авторизации:
- Пустые/невалидные email и пароль;
- Невалидный формат email;
- Отсутствие headers;
- Проверка лимитов по неудачным попыткам входа;
- Статус-коды и тело ответа.

# RIA Authorization & Password Recovery Tests

![Java](https://img.shields.io/badge/Java-24-red.svg)
![JUnit](https://img.shields.io/badge/Testing-JUnit5-green.svg)
![Maven](https://img.shields.io/badge/Build-Maven-blue.svg)
![Selenium](https://img.shields.io/badge/UI%20Testing-Selenium-orange.svg)
![REST Assured](https://img.shields.io/badge/API%20Testing-REST--Assured-yellow.svg)

## Среда разработки

<img src="https://resources.jetbrains.com/storage/products/intellij-idea/img/meta/intellij-idea_logo_300x300.png" alt="IntelliJ IDEA" width="80"/>

- **IntelliJ IDEA** — основная IDE для разработки и запуска тестов.

---

## Используемые инструменты

| Инструмент                                                                                                                                                                                                                         | Назначение                               |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| <img src="https://camo.githubusercontent.com/21df198fc04f5b13fbd8f7eb39b06b4fa4eefc600a2ede6e9c4ba2b42c95bff1/68747470733a2f2f656469746f72636f6e6669672e6f72672f6c6f676f732f6d6176656e2e706e67" alt="Maven" width="60">  **Maven** | Сборка проекта и управление зависимостями |
| <img src="https://img.icons8.com/external-tal-revivo-color-tal-revivo/48/000000/external-postman-is-the-only-complete-api-development-environment-logo-color-tal-revivo.png" alt="Postman" width="60"> **Postman**                                          | Визуальное тестирование API-запросов      |
| <img src="https://img.icons8.com/color/48/000000/jenkins.png" alt="Jenkins" width="60"> **Jenkins**                                                                                                                                                         | Автоматизация CI/CD                       |
| <img src="https://img.icons8.com/material-outlined/48/000000/github.png" alt="GitHub" width="60"> **GitHub**                                                                                                                                                | Хранение и версионирование кода          |
| <img src="https://plantuml.com/logo3.png" alt="PlantUML" width="60"> **PlantUML**                                                                                                                                                                           | Диаграммы и документация                 |

---

## Технологии тестирования

| Библиотека            | Назначение                                          |
|------------------------|-----------------------------------------------------|
| <img src="https://upload.wikimedia.org/wikipedia/commons/5/59/JUnit_5_Banner.png" alt="PlantUML" width="60"> **JUnit 5**       | Фреймворк для написания и запуска тестов |
| <img src="https://dogq.io/blog/content/images/2023/11/4.png" alt="REST Assured" width="60"> **REST Assured** | Тестирование REST API                     |
| <img src="https://camo.githubusercontent.com/03ea5cbad1fd5efa88109b9c7a0524974b52aa8f525a2defe0a8cc88a6eb1e94/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f642f64352f53656c656e69756d5f4c6f676f2e706e67" alt="Selenium WebDriver" width="60"> **Selenium WebDriver** | Автоматизация UI-тестов                   |
| <img src="https://miro.medium.com/v2/resize:fit:790/1*nQq_1UizpnVtMeux4NXvjw.png" alt="Java Faker" width="60"> **Java Faker**      | Генерация случайных данных                          |
| <img src="https://openvpn.net/wp-content/uploads/log4j.png" alt="Log4j" width="60"> **Log4j**           | Логгирование тестов                                |


# Диаграмма классов (мини-версия)

<img src="docs/class_diagram_mini.png" width="100%">

[//]: # (<img src="docs/class_diagram.png" width="100%">)

[//]: # (![Диаграмма классов]&#40;docs/class_diagram_mini.png&#41;)

# Примеры автотестов

## UI-тест: Проверка появления CSS-класса у label при фокусе на поле email

```java
@Test
public void testEmailLabelChangeOnFocused() {
    String heading = "Проверка поведения поля email при клике на него";
    LogUI.startTest(heading);

    String classForCheck = Finals.CSS_CLASS_ON_FOCUSED;

    // До клика класс отсутствует
    Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);

    // Кликаем по label
    loginForm.clickOnEmailLabel();

    // После клика класс должен появиться
    Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);

    assertAll(
        heading,
        () -> assertFalse(isLabelHasClassBeforeClick, "До клика класс не должен быть установлен"),
        () -> assertTrue(isLabelHasClassAfterClick, "После клика класс должен появиться")
    );
}
```

### Описание:
- Тест проверяет поведение поля email в UI при фокусе.
- После клика на label должен применяться CSS-класс on-focused для анимации и визуальной подсветки.
- Используется assertAll для групповой валидации нескольких условий.

## API-тест: Отправка пустых значений логина и пароля

```java
@Test
public void testEmptyLoginAndPassword() {
    LogAPI.startTest("Проверка с пустыми email и паролем");

    // Отправляем POST-запрос с пустым телом
    login.setResponseEmptyLoginAndPassword();

    // Проверяем статус и тело ответа
    assertAll(
        "Проверка с пустыми email и паролем",
        () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
        () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть 'error'"),
        () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "Ошибка 'login' должна быть 'empty'")
    );
}
```

### Описание:
- Тест отправляет запрос авторизации без логина и пароля.
- Ожидается:
  - HTTP статус 200;
  - JSON status = "error";
  - Поле errors.login = "empty".

# Разработчик проекта 
## Радецкая Юлия
[![codewars](https://www.codewars.com/users/ChaoticHamka/badges/large)](https://www.codewars.com/users/ChaoticHamka)

# Блок с цитатами

[![Readme Quotes](https://quotes-github-readme.vercel.app/api?type=horizontal&theme=dark)](https://github.com/piyushsuthar/github-readme-quotes)
