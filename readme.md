# API Testing Automation Project
<img  src="images/screens/reqresin.jpg">

## :man_student:: Content:

- [Technology stack](#earth_africa-Стек-технологий)
- [Implemented checks](#earth_africa-Реализованные-проверки)
- [Building in Jenkins](#earth_africa-Jenkins-job)
- [Run from terminal](#earth_africa-Запуск-тестов-из-терминала)
- [Allure report](#earth_africa-Allure-отчет)
- [Integration Allure TestOps](#earth_africa-Интеграция-c-Allure-TestOps)
- [Notification in Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)

## 🧰: Technology stack

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
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
- ✓ POST/api/register - registration in the system
- ✓ DELETE/api/users/2 - user account deletion


# :running_woman: Run tests

### Run tests locally
```
gradle clean test 
```

If necessary, you can override the launch options
```
gradle clean
test/positive/negative - all tests/postitve/negative

```

### Run tests on a remote browser
```
clean test
```
You can also override launch options if needed.

```
clean
test/positive/negative - all tests/postitve/negative
```
## :hammer_and_wrench:: Build options in Jenkins:

- remote (remote server address)
- browserSize (browser window size, default 1920x1080)
- browserVersion (browser version, default 100.0)
- browser (browser, chrome by default)




## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Build <a target="_blank" href="https://jenkins.autotests.cloud/job/C17_ruslan_g_r_diplomAPI/"> Jenkins </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/C17_ruslan_g_r_diplomAPI/"><img src="images/screens/Jenkins.PNG" alt="Jenkins1"/></a>
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.svg"> <a href="https://jenkins.autotests.cloud/job/C17_ruslan_g_r_diplomAPI/13/allure/">Example Allure-report</a>
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
  <img src="images/screens/AllureTestOpsMain.PNG" alt="dashboard" width="900">
</p>

### Test case

<p align="center">
  <img src="images/screens/AllureTestOpsTestCases.PNG" alt="testcase" width="900">
</p>



### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications using a bot

<p align="center">
<img title="telegram" src="images/screens/telegram.PNG">
</p>


