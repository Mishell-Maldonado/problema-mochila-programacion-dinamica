# Sistema de Gestión de Inventario - Programación Dinámica

*Descripción General*
Este proyecto implementa un sistema interactivo en Java para resolver el problema de la **Mochila 0/1**, aplicando Programación Dinámica para maximizar el beneficio económico de un inventario bajo restricciones de espacio.

El programa mide el rendimiento en tiempo real, realiza el rastreo de los productos seleccionados y despliega un análisis comparativo directamente en la consola.


##  Enfoques y Complejidad Teórica

| Enfoque | Complejidad Temporal | Complejidad Espacial | Características |
| :--- | :---: | :---: | :--- |
| **1. Recursivo Puro** | $O(2^n)$ | $O(n)$ | Analiza todas las combinaciones; recalcula subproblemas. |
| **2. Top-Down** | $O(n \cdot W)$ | $O(n \cdot W)$ | Optimiza la recursión mediante el uso de **Memoización**. |
| **3. Bottom-Up** | $O(n \cdot W)$ | $O(n \cdot W)$ | El más eficiente. Resuelve de forma iterativa (**Tabulación**). |



##  Funcionalidades Clave
- **Interactividad:** Ingreso dinámico de productos y evaluación de múltiples casos en bucle.
- **Rastreo Óptimo:** Muestra los índices específicos de los productos seleccionados.
- **Medición Real:** Compara los tiempos de ejecución en nanosegundos (`System.nanoTime()`).
- **Diagnóstico:** Despliega el análisis de complejidad teórica en pantalla.


#  Estructura del Código (`/src`)
- `Producto.java`: Modelo de la entidad (atributos peso y valor).
- `Mochila.java`: Algoritmos y lógica de los tres enfoques de optimización.
- `Main.java`: Interfaz de consola, captura de datos y control del flujo principal.


##  Tecnologías y Autor
- *Entorno:* Java (JDK 25) | Visual Studio Code | Git & GitHub
- *Estudiante:* Angelina Mishell Maldonado Toral 
- *Institución:* Universidad Politécnica Salesiana 
