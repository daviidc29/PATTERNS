# PATTERNS
## INTEGRANTES

**David Santiago Castro Sierra**

**Juan Esteban Cely Lopez**


### EJERCICIO DE LAS FIGURAS

### CREAR UN PROYECTO CON MAVEN
En este caso se creo un proyecto maven con ayuda de los arquetipos (archetypes).

Se usaron estos parametros para la estructura del proyecto de maven:
```yml
ProjectId: org.apache.maven.archetypes:maven-archetype-quickstart:1.0
Id del Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns.archetype
```

Se   creo en el directorio, un nuevo proyecto `Patterns` a partir de un modelo o arquetipo, que crea un conjunto de directorios con un conjunto de archivos básicos.

Pasos para saber si la estructura de proyecto maven esta bien:

Cambie al directorio `Patterns`:
```sh
$ cd Patterns
```

Para ver el conjunto de archivos y directorios creados por el comando `mvn` ejecute el comando `tree`.
```sh
$ tree
```
En caso de que no funcione en git bash, otra herramienta que se puede usar es PowerShell ya que ésta maneja el comando "tree".

En algunos sistemas operativos, este comando no funciona correctamente o puede requerir un parámetro (por ejemplo: `tree /f`). En caso que funcione, la
salida muestra la estructura del proyecto, similar a como se muestra a continuación:
```sh
.
│ pom.xml
└───src
├───main
│ └───java
│ └───edu
│ └───eci
│ └───cvds
│ └───patterns
  └───archetype
│ App.java
│
└───test
└───java
└───edu
└───eci
└───cvds
└───patterns
└───archetype
AppTest.java
```

Edite el archivo `pom.xml` y realize la siguiente actualización:

Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección `properties` antes de la sección de
dependencias:
```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

## COMPILAR Y EJECUTAR
Para compilar ejecute el comando:
```sh
$ mvn package
```

Si maven no actualiza las dependencias utilice la opción `-U` así:
```sh
$ mvn -U package
```



**Pom.xml**
![alt text](Resources/imagen-1.png)

**Eejecución**

![alt text](Resources/imagen-2.png)

**-Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando `mvn`.**


El parámetro `package` en el comando `mvn` se utiliza para compilar el código fuente del proyecto y empaquetarlo en su formato distribuible, como un archivo JAR o WAR. Este comando es parte del ciclo de vida de Maven y se encarga de preparar el proyecto para su distribución.

Además del parámetro `package`, hay otros parámetros que se pueden enviar al comando `mvn`:

1. **clean**: Limpia el directorio de destino eliminando todos los archivos generados por compilaciones anteriores.
2. **compile**: Compila el código fuente del proyecto.
3. **test**: Ejecuta las pruebas unitarias utilizando un marco de pruebas adecuado.
4. **install**: Instala el paquete en el repositorio local, para que otros proyectos puedan depender de él.
5. **deploy**: Copia el paquete final al repositorio remoto para compartirlo con otros desarrolladores y proyectos.



**Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase `App.java` como parámetro en "mainClass".**
   
   
    `mvn exec:java -Dexec.mainClass=""`




**Realice el cambio en la clase `App.java` para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación.**

![alt text](Resources/imagen-3.png)


**Utilizar la primera posición del parámetro que llega al método "main" para realizar elsaludo personalizado, en caso que no sea posible, se debe mantener el saludo como se encuentra actualmente:**


**Buscar cómo enviar parámetros al plugin "exec".**

`mvn exec:java -Dexec.mainClass="com.ejemplo.App" -Dexec.args="parametro`

**Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: Hello World!**


![alt text](Resources/imagen-4.png)

**Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!**


![alt text](Resources/imagen-5.png)


**Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?**

![alt text](Resources/imagen-6.png)

**Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido.**

En este caso se debe agregar el siguiente bloque en la seccion pluggins del pom.XML:

![alt text](Resources/imagen-7.png)

Donde : 

**mainClass:** Define la clase principal que tiene el método main().

**arguments:** Lista de argumentos pasados a main().


Cada **argument** es un elemento separado.

Maven los pasará como argumentos del programa.

**comando :**`mvn exec:java -Dexec.args="Valor1 Valor2"`

**Ejecutar nuevamente y verificar la salida en consola. Ej: Hello Pepito Perez!**


![alt text](Resources/imagen-8.png)

## HACER EL ESQUELETO DE LA APLICACIÓN
Cree el paquete `edu.eci.cvds.patterns.shapes` y el paquete `edu.eci.cvds.patterns.shapes.concrete`.

Cree una interfaz llamada `Shape.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` de la siguiente manera:
```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    public int getNumberOfEdges();
}
```

**Interfaz:**

![alt text](Resources/imagen-9.png)


Cree una enumeración llamada `RegularShapeType.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` así:

```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon
}
```

**Enumeración**

![alt text](Resources/imagen-10.png)

En el directorio `src/main/java/edu/eci/cvds/patterns/shapes/concrete` cree las diferentes clases (Triangle, Quadrilateral, Pentagon, Hexagon), que implementen la interfaz creada y retornen el número correspondiente de vértices que tiene la figura. 

Siguiendo el ejemplo del triángulo:
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}
```

**Clases:**


![alt text](Resources/imagen-11.png)



![alt text](Resources/imagen-12.png)



![alt text](Resources/imagen-13.png)


![alt text](Resources/imagen-14.png)

Cree el archivo `ShapeMain.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` con el metodo main:
```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {

  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      System.err.println("Parameter of type RegularShapeType is required.");
      return;
    }
    try {
      RegularShapeType type = RegularShapeType.valueOf(args[0]);
      Shape shape = ShapeFactory.create(type);
      System.out.println(
        String.format(
          "Successfully created a %s with %s sides.",
          type,
          shape.getNumberOfEdges()
        )
      );
    } catch (IllegalArgumentException ex) {
      System.err.println(
        "Parameter '" + args[0] + "' is not a valid RegularShapeType"
      );
      return;
    }
  }
}
```

**Shape.main**

![alt text](Resources/imagen-15.png)




Analice y asegúrese de entender cada una de las instrucciones que se encuentran en todas las clases que se crearon anteriormente. Cree el archivo `ShapeFactory.java` en el directorio `src/main/java/edu/eci/cvds/patterns/shapes` implementando el patrón fábrica (Hint: https://refactoring.guru/design-patterns/catalog), haciendo uso de la instrucción switch-case de Java y usando las enumeraciones.

**¿Cuál fábrica hiciste? y ¿Cuál es mejor?**

En este caso llegamos al consenso de que el patrón Simple Factory es ideal para casos en los que se quiere centralizar la creación de objetos y no es necesaria una estructura compleja con múltiples niveles de herencia o diferentes familias de objetos, como sucede en Factory Method o Abstract Factory.


Para este laboratorio necesitamos crear instancias de clases concretas (Triangle, Quadrilateral, Pentagon, Hexagon) basadas en un único parámetro (RegularShapeType).

La lógica de creación es sencilla y clara: dependiendo del tipo, devolvemos una instancia específica.
No hay múltiples familias de productos ni jerarquías complicadas, por lo que el uso de una fábrica más compleja (como Abstract Factory) no es necesario.

**Comparación:**

**Simple Factory:** Centraliza la creación de objetos y es fácil de mantener. Perfecto para este caso.


**Factory Method:** Proporciona una mayor flexibilidad, pero añade complejidad innecesaria si solo se necesita crear unas pocas clases concretas.


**Abstract Factory:** Útil cuando se tienen por ejemplo múltiples familias de objetos relacionadas. No aplica aquí porque solo manejamos una familia de figuras geométricas


**Clase ShapeFactory**

![alt text](Resources/imagen-16.png)

Ejecute múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verifique la salida en consola para cada una:
- Sin parámetros
- Parámetro: qwerty
- Parámetro: pentagon
- Parámetro: Hexagon

¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

**Primero se modifico el pom.XML para la correcta ejecución**
- Se cambio la clase main de App a ShapeMain
- Se dejo solo un parametro para la ejecución 



![alt text](Resources/imagen-17.png)

- Sin parámetros

![alt text](Resources/imagen-18.png)

- Parámetro: qwerty


![alt text](Resources/imagen-19.png)

- Parámetro: pentagon

![alt text](Resources/imagen-20.png)

- Parámetro: Hexagon

![alt text](Resources/imagen-21.png)

