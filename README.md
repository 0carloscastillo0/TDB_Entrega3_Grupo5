# TDB_Voluntariado

Para la ejecucion del presente proyecto se necesita:
- Postgresql 11
- Gradle 7.0 o superior
- Spring tool suite 4
- Java JDK 16
- node 10 o superior
- Vue 4.5 o superior para utilizar nuxt con el modulo de axios.
- npm 



1) Clone el archivo de git hub
2) Cree una base de datos llamada voluntariadodb.
    2.1) abra la consola en la parte de git clonada.
    2.2) ejecute el comando: sudo -u postgres psql voluntariadodb < dbCreate.sql
    2.3) ejecute el comando: sudo -u postgres psql voluntariadodb < loadData.sql
    La basa de datos ya esta creada y cargada con datos.
3) Dentro de la carpeta voluntariadodb abra la consola y ejecute: ./gradlew bootRun
4) dejar corriendo la consola anterior.
5) Dentro de la carpeta Frontend abra la consola y ejecute: npm run dev
6) Abrir el navegador y entrar a localhost:3000/script