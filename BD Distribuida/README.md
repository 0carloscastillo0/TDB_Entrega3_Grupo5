# TDB_Voluntariado

Para la ejecucion del presente proyecto se necesita:
- Postgresql 11
- Gradle 7.0 o superior
- Spring tool suite 4
- Java JDK 16



1) Clone el archivo de git hub
2) Cree una base de datos llamada voluntariadodb0.
    2.1) abra la consola en la parte de git clonada.
    2.2) ejecute el comando: sudo -u postgres psql voluntariadodb0 < dbCreate.sql
    Las bases de datos distribuidas ya esta creada y cargada con datos.
3) Dentro de la carpeta voluntariadodb abra la consola y ejecute: ./gradlew bootRun
4) dejar corriendo la consola anterior.
5) Abrir Postman y ejecutar consulas en http://localhost:8080/
