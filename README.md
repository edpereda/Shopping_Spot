# Shopping Spot
Proyecto realizado en lenguaje Java para dispositivos Android, para la materia "Ingeniería de Software" de la Escuela Superior de Cómputo (ESCOM) del Instituto Politécnico Nacional (IPN).

### Realizado en el año 2019. Lenguaje Java. IDE Android Studio.

## Problemática
El proyecto está enfocado a usuarios que carecen de tiempo para revisar los artículos que tienen en su alacena, mostrando una necesidad de no poder saber si un artículo esta por acabarse, si ya cuentan con este producto en su alacena, o el producto aún es suficiente pero ya expiró.

## Descripción
Este proyecto fue realizado en java para dispositivos android, y en c para programar un arduino (código del arduino no disponible). El proyecto esta conformado por unos estantes que tienen montados unos displays y unas pesas que miden el peso de los objetos encima de ellas y envían la información a un Arduino. El Arduino se encarga de realizar una conexión bluetooth y posteriormente envíar la información al teléfono conectado. La aplicación se conectaba a un dispositivo arduino por medio de bluetooth. El arduino envía la cantidad de peso que se encontraba en los estantes. El almacenamiento de los productos y el registro y análisis del peso de éstos mismos se gestionan dentro de la aplicación.

## Objetivos
- La aplicación debe contener una interfaz sencilla, donde muestre el status de los artículos en las alacenas.
- La aplicación debe poder sincronizarse con el módulo bluetooth del arduino y actualizar el status de los artículos.
- La aplicación debe contener una base de datos para almacenar más articulos, sin importar que éstos no esten en las alacenas.
- El estante que mide el peso de dos productos, debe tener indicadores de que esta funcionando de manera correcta.
