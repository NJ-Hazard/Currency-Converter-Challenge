# 💰 Conversor de Monedas - Challenge Alura

¡Bienvenido al **Conversor de Monedas**! Este es un proyecto desarrollado como parte del desafío de Alura Latam, que consiste en una aplicación de consola en Java para realizar conversiones de divisas en tiempo real utilizando una API externa.

## 🚀 Características

- **Menú Interactivo**: Interfaz de consola fácil de usar para navegar entre las opciones.
- **Conversión de Monedas**: Soporte para convertir entre las siguientes divisas:
  - 🇺🇸 Dólar Estadounidense (USD)
  - 🇦🇷 Peso Argentino (ARS)
  - 🇧🇴 Peso Boliviano (BOB)
  - 🇧🇷 Real Brasileño (BRL)
  - 🇨🇱 Peso Chileno (CLP)
  - 🇨🇴 Peso Colombiano (COP)
- **Historial de Conversiones**: Guarda un registro de las conversiones realizadas durante la sesión.
- **Datos en Tiempo Real**: Consume la [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio actualizadas.

## 🛠️ Tecnologías Utilizadas

- **Java 21**: Lenguaje de programación principal.
- **Gradle**: Herramienta de automatización de construcción.
- **Gson**: Biblioteca de Google para el procesamiento de JSON.
- **Java HttpClient**: Para realizar solicitudes HTTP a la API.

## 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1.  **Java Development Kit (JDK) 21** o superior.
2.  Una conexión a Internet activa (necesaria para consultar las tasas de cambio).

## 🔧 Instalación y Ejecución

### 1. Clonar el Repositorio

```bash
git clone <URL-DEL-REPOSITORIO>
cd Currency-Converter-Challenge
```

### 2. Compilar y Ejecutar con Gradle

Este proyecto utiliza Gradle Wrapper, por lo que no necesitas tener Gradle instalado globalmente.

**En Windows:**

```powershell
./gradlew run
```

**En Linux/macOS:**

```bash
./gradlew run
```

*Nota: La primera vez que ejecutes el comando, Gradle descargará las dependencias necesarias, lo cual puede tardar unos momentos.*

### 3. Ejecutar desde un IDE

También puedes importar el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code, Antigravity en mi caso):

1.  Abre el proyecto seleccionando la carpeta raíz `Currency-Converter-Challenge`.
2.  Espera a que Gradle sincronice las dependencias.
3.  Navega a `app/src/main/java/conversormonedas/ConversorApp.java`.
4.  Ejecuta el método `main`.

### 4. Ejecutar desde la terminal

1. cd app
2. javac -cp "lib/gson-2.10.1.jar" -d target/classes src/main/java/conversormonedas/ConversorApp.java src/main/java/conversormonedas/Conversor.java
3. java -cp "lib/gson-2.10.1.jar;target/classes" ConversorApp

## 📖 Cómo Usar

Al iniciar la aplicación, verás un menú con las siguientes opciones:

1.  **Hacer conversión**: Te guiará para seleccionar la moneda de origen, la moneda de destino y la cantidad a convertir.
2.  **Ver historial**: Muestra una lista de todas las conversiones que has realizado desde que abriste la aplicación.
3.  **Salir**: Cierra la aplicación.

### Ejemplo de flujo:

```text
_____ BIENVENIDO AL CONVERSOR DE MONEDAS _____

_____ ¿QUÉ DESEAS HACER? _____
1. Hacer conversión
2. Ver historial
3. Salir
Elige opción (1-3): 1

_____ NUEVA CONVERSIÓN _____
...
Elige moneda ORIGEN: 6 (USD)
Elige moneda DESTINO: 1 (ARS)
Cantidad a convertir: 100

_____ RESULTADO _____
100.0 USD = 12345.67 ARS
(Guardado en historial)
```

## ⚠️ Nota sobre la API Key

Este proyecto utiliza una clave de API gratuita de ExchangeRate-API. Si experimentas problemas con las solicitudes, verifica que la clave en `Conversor.java` sea válida o regístrate en [exchangerate-api.com](https://www.exchangerate-api.com/) para obtener tu propia clave y reemplazarla en el código.

---
Desarrollado con 💙 por [Neil Sebastián Jácome Contreras] para el Challenge de Alura.
