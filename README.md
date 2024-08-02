# SeleniumTemplate

Este repositorio proporciona una plantilla básica para comenzar a trabajar con Selenium, Gradle y Cucumber en proyectos de automatización de pruebas en Java.

## Contenido

- [Introducción](#introducción)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Introducción

Selenium es una herramienta poderosa para la automatización de navegadores web. Este proyecto proporciona una plantilla para comenzar rápidamente con Selenium y está diseñado para ser fácilmente extensible y configurable para diferentes necesidades de automatización. Utiliza Gradle para la gestión de dependencias y Cucumber para la definición de pruebas en un lenguaje legible.

## Requisitos

- [Java 8 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- Un navegador web compatible (por ejemplo, Google Chrome)
- [Chromedriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) para Chrome o el driver correspondiente para tu navegador

## Instalación

1. Clona este repositorio en tu máquina local:

    ```sh
    git clone https://github.com/victorinho/SeleniumTemplate.git
    cd SeleniumTemplate
    ```

2. Descarga el WebDriver correspondiente a tu navegador y asegúrate de que esté en tu PATH. Por ejemplo, para Chrome, descarga [Chromedriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) y agrega su ubicación a tu PATH.

3. Ejecuta el siguiente comando para descargar las dependencias y compilar el proyecto:

    ```sh
    gradle build
    ```

## Uso

Para ejecutar las pruebas de Cucumber incluidas en esta plantilla, utiliza el siguiente comando:

```sh
gradle test
