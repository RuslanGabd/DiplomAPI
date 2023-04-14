# Проект по автоматизации тестирования API сервиса Reqres
<img  src="images/screens/reqresin.jpg">

## :man_student:: Содержание:

- [Стек технологий](#earth_africa-Стек-технологий)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Интеграция с Allure TestOps](#earth_africa-Интеграция-c-Allure-TestOps)
- [Уведомления в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)

## 🧰: Стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://https://qameta.io/"><img src="images/logo/allureTestOps.svg" width="50" height="50"  alt="Allure_TO"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://https://telegram.org/"><img src="images/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

Autotests are written in <code>Java</code> using <code>JUnit 5</code> and <code>Gradle</code>.
For UI tests, the [Selenide] framework (https://selenide.org/) was used.
Tests can be run locally or using [Selenoid](https://aerokube.com/selenoid/).
Also implemented build in <code>Jenkins</code> with generation of an Allure report and sending a notification with the results to <code>Telegram</code> after the run is completed.

Allure report includes:
* test execution steps;
* screenshot of the page in the browser at the end of the autotest;
* Page Source;
* browser console logs;
* video of the autotest.

## :male_detective:: Implemented checks

- ✓ POST/api/users - creating a user account
- ✓ GET/api//users?page=2 - getting a list of users
- ✓ POST/api/login - login
-  ✓ POST/api/register - регистрация в системе

 


# :running_woman: Run tests

### Run tests locally
```
gradle clean test -Denv=local
```

If necessary, you can override the launch options
```
test/MainPage/ContactPage/NewsPage 

```

### Run tests on a remote browser
```
gradle clean test -Denv=remote
```
You can also override launch options if needed.

```
test/MainPage/ContactPage/NewsPage 
```
## :hammer_and_wrench:: Build options in Jenkins:

- remote (remote server address)
- browserSize (browser window size, default 1920x1080)
- browserVersion (browser version, default 100.0)
- browser (browser, chrome by default)




## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Build <a target="_blank" href="https://jenkins.autotests.cloud/job/C17_ruslan_g_r_unit_25/"> Jenkins </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job//"><img src="images/screens/Jenkins.png" alt="Jenkins1"/></a>
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.svg"> <a href="https://jenkins.autotests.cloud/job/C17_ruslan_g_r_unit_25/6/allure/">Example Allure-report</a>
### Overview

<p align="center">
<img title="Allure Overview" src="images/screens/AllureReport.PNG">
</p>

### Test result

<p align="center">
<img title="Test Results in Alure" src="images/screens/AllureReportTests.PNG">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/allureTestOps.svg"> Integration  [Allure TestOps](https://qameta.io/)

### Main Dashboard

<p align="center">
  <img src="images/screens/AllureTestOpsMain.png" alt="dashboard" width="900">
</p>

### Test case

<p align="center">
  <img src="images/screens/AllureTestOpsTestCases.png" alt="testcase" width="900">
</p>

# Jira integration
<p align="center">
  <img src="images/screens/JiraARHS.png" alt="JiraIntegration" width="950">
</p>



### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications using a bot

<p align="center">
<img title="telegram" src="images/screens/telegram.jpg">
</p>


