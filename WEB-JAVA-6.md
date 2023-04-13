# WEB-JAVA-6 - Unit Testing Web Components

## Tabla de contenidos

- [WEB-JAVA-6 - Unit Testing Web Components](#web-java-6---unit-testing-web-components)
	- [Tabla de contenidos](#tabla-de-contenidos)
	- [Parte 1](#parte-1)
	- [Parte 2](#parte-2)
		- [Setup](#setup)
	- [Parte 3](#parte-3)
		- [Crear y ejecutar pruebas](#crear-y-ejecutar-pruebas)
		- [Ejercicio](#ejercicio)
	- [Recursos](#recursos)

## Parte 1

1. [Mockito](https://site.mockito.org/)

- Mockito es un mocking framework para Java que se implementa en conjunción a otros frameworks de pruebas unitarias.
- Facilita la implementación de frameworks y librerías de pruebas al "mockear" (simular/replicar) la ejecución de cualquier aplicación Java.
- Se puede implementar con Gradle o Maven
- Se recomienda implementar cuando el objeto/interfáz tiene un resultado o comporamiento no determinista (puede cambiar).




## Parte 2

### Setup

1. El proyecto de ejemplo necesita los siguientes archivos

- Editar y agregar la dependencia en nuestro ```build.gradle```
    - Se utilizará una versión 4+. Pero se pueden implementar 3+ o 2+.
    - A partir de 3+ se necesita Java 8 o superior

```Java
dependencies {
    testImplementation 'org.mockito:mockito-core:4+'
    testImplementation 'org.mockito:mockito-junit-jupiter:4+'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5+'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5+'
}

test {
    useJUnitPlatform()
}
```

- ```User.java```
```Java
package sampleModel;

public class User {
	Long id;
	String name;
	
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + "]";
	}
	
	
}


```

2. ```UserService.java```

```Java
package sampleService;

//import java.util.HashMap;

import sampleModel.User;
import sampleRepository.UserRepository;

public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("The name can't be null");
		}
		return userRepository.createUser(name);
	}
	
	public User getUser(final long id) {
		return userRepository.getUser(id);
	}
	
}
```

3. ```UserRepository.java```

```Java
package sampleRepository;

import sampleModel.User;

public interface UserRepository {
	User createUser(String name);
	
	User getUser(Long id);
}


```

4. ```UseSrerviceTests.java```

> This is our main test file. Must be a JUnit test case/suite file

```Java
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

	@BeforeEach
	public void setUp() {
	}
	
	@DisplayName("Given a new user created when called createUser(), test the expeted Data and methods")

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
```

## Parte 3

### Crear y ejecutar pruebas

Se harán todas las modificaciones en ```UserServiceTest.java```

1. Crear un objeto mock/simulado de UserRepository

```java
@Mock
private UserRepository userRepository;

```

2. Agregar el objeto simulado a la clase que queremos probar

```java
@InjectMocks
private UserService userService;
```

3. En la prueba declarar la primer prueba unitaria para el metodo ```createUser()```

```java
@Test
public void testCreateUser() {
    // Declarar usuario esperado
    
    User expected = new User(1L, "Arwen");
    
    // Declarar prueba con mock y hacerle prueba
    
    Mockito.when(userRepository.createUser(1L ,"Arwen"))
        .thenReturn(expected);

   // Crear pruebas de JUnit para nuestro Mock

   final User result = userService.createUser("Arwen");

   // Pruebas para id, name y objeto completo
   
   Assertions.assertEquals(expected.id, result.id);
   Assertions.assertEquals(expected.name, result.name, "Los nombres no coinciden");
   Assertions.assertEquals(expected, result);
}
```

4. Crear una prueba para que falle nuestro mock

```java
    // Nuevo objeto
    User simulatedUser = new User(2L, "Gimli");
    
    User expected = new User(1L, "Arwen");
   
    // Cambiar a simulatedUser
    Mockito.when(userRepository.createUser(1L, "Arwen"))
        .thenReturn(simulatedUser);
```


5. Agregar metodo de verificacion para la ejecucion del metodo ```createUser()````

```java
    Mockito.verify(userRepository).createUser("Arwen");
```

Esto verifica que el método llamado de nuestro objeto simulado ```userRepository``` sea exclusivamente ```createUser()```

6. Agregar metodo para verificar lo anterior y asegurarnos que la ejecución de ```createUser()``` sea solamente invocada n cantidad de veces.

```java
    Mockito.verify(userRepository, Mockito.times(2)).createUser("Arwen");
```


### Ejercicio

1. Crear prueba para ```getUser```
    - Solo se ejecuta el metodo 1 vez
    - JUnit + Mockito

```java
@Test
public void testGetUser() {
    User simulatedUser = new User(1L, "Arwen");
    User expected = new User(1L, "Arwen");

    Mockito.when(userRepository.getUser(1L))
        .thenReturn(simulatedUser);

    final User result = userService.getUser(1L);
    Assertions.assertEquals(expected, result);
    Mockito.verify(userRepository, Mockito.times(1)).getUser("1L");
}
```

## Recursos

- [Mockito](https://site.mockito.org/) 
- [Mockito Tutorial (digitalocean.com)](https://www.digitalocean.com/community/tutorials/mockito-tutorial)
