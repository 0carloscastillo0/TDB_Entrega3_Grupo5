/*
 * Script que se encarga de generar la base de datos  
 * 
 */

print("STARTING DATABASE SCRIPT");
//Host donde está nuestra base de datos, no tiene que ser nuestro equipo local, puede ser cualquier mongoDb.
conn = new Mongo("localhost");

//Nombre de la base de datos que vamos a utilizar
db = conn.getDB("voluntariadodb");

/*Limpiamos la base de datos por si existia algo antes*/
db.dropDatabase();


/*coleciones de nuestro modelo de datos*/
db.createCollection("voluntario");
db.createCollection("habilidad");

print("FINISHING DATABASE SCRIPT");
