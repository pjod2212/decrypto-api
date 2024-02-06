# Desafío Técnico Decrypto - Spring REST API CRUD 

Este proyecto es una implementación CRUD usando api rest

# Tecnologías utilizadas

<ul>
  <li><a href="https://spring.io/projects/spring-boot">Spring Boot</a></li>
  <li><a href="https://www.mysql.com/download/">MySql</a></li>
  <li>
<a href="https://swagger.io/](https://springdoc.org">OpenApi para documentar el servicio</a>
</li>
<li>
<a href="https://projectlombok.org/">Lombok</a>
</li>
</ul>

# Pasos para ejecutar de forma local .

Al correr el proyeto carga automaticamente algunos datos, solo hace falta pocos pasos que a continuación voy a nombrar.

Si utilizas eclipse ,  para que funcione lombok , ir a donde esta la carpeta .m2 ej (C:\Users\Pablo_Donati\.m2\repository\org\projectlombok\lombok\1.18.20) ejecutar el jar y reiniciar el   ide que estes usando.

 Configurar la conexión de la base de datos, utilice dbeaver pero puede hacerse con el ide que desees, descargar mysql.

 ![image](https://github.com/pjod2212/decrypto-api/assets/18425978/f9da8161-500d-476a-9c0f-072db6896730)

Elegir mysql

![image](https://github.com/pjod2212/decrypto-api/assets/18425978/83a529c7-9abd-4a14-a357-098cd338dcc9)

Configurar base de datos, es importante nombrar bien los campos.

![image](https://github.com/pjod2212/decrypto-api/assets/18425978/67887777-f8db-40cb-afab-a988c3d408fc)


Al tener creada la conexión , click derecho crear nuevo database con nombre decrypto o el que fuera, siempre tener en cuenta el nombre para las properties:

![image](https://github.com/pjod2212/decrypto-api/assets/18425978/cc4fb670-dcdd-46dc-94b7-79d921da9e1c)

Clonear el proyecto , importarlo como proyecto maven. Los servicios se pueden correr desde http://localhost:8080/api/swagger-ui/index.html



```properties

# Ejemplo de properties 
server.servlet.context-path=/api

spring.datasource.url=jdbc:mysql://localhost:3306/decrypto
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
spring.sql.init.data-locations=classpath:data.sql
spring.sql.init.mode=always
spring.jpa.hibernate.ddl-auto=update

```


# Desarrollador
Pablo Donati




