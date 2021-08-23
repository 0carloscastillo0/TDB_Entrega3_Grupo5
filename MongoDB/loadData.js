

/*
 * Script que se encarga de poblar la base de datos  
 * 
 */

print("STARTING SCRIPT");
//Host donde está nuestra base de datos, no tiene que ser nuestro equipo local, puede ser cualquier mongoDb.
conn = new Mongo("localhost");

//Nombre de la base de datos que vamos a utilizar
db = conn.getDB("voluntariadodb");

/*Limpiamos la base de datos por si existia algo antes*/
db.dropDatabase();

/* Voluntarios */
print("***********creando voluntarios*********");



vol1 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Carlos",
    "edad_voluntario" : 25,
    "direccion_voluntario": "29106 Kling Villages Apt. 975",
    "habilidades":["limpiar","curar"]
    
};
vol2 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Javier",
    "edad_voluntario" : 25,
    "direccion_voluntario": "Avinguda Arnau, 2, 5º A",
    "habilidades":["cargero","conductor"]
    
};
vol3 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Francisco",
    "edad_voluntario" : 25,
    "direccion_voluntario": "Travessera Urrutia, 16, 6º 6º",
    "habilidades":["cocinar","animador","recepcionar"]
    
};
vol4 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Sebastian",
    "edad_voluntario" : 25,
    "direccion_voluntario": "6029 Hartmann Locks",
    "habilidades":["orador"]
    
};
vol5 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Maximiliano",
    "edad_voluntario" : 25,
    "direccion_voluntario": "Carretera Lucia, 990, Casa 5",
    "habilidades":["organizar","rescatista"]
    
};
vol6 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Wladimir",
    "edad_voluntario" : 25,
    "direccion_voluntario": "Weiseweg 3b",
    "habilidades":["rastreador"]
    
};
vol7 = {
    "_id" : new ObjectId(),
    "nombre_voluntario" : "Miguel",
    "edad_voluntario" : 25,
    "direccion_voluntario": "Cl. Thiago Carrillo # 5190 Dpto. 588",
    "habilidades":["estratega","recolector"]
    
};


print("***********creando habilidades*********");

/* Habilidades */


hab1 = {
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "cocinar",
        "descripcion_habilidad" : "Preparar el desayuno, almuerzo, once y cena",
        "cod_alfanumerico":"D26CXEWE9D"
    } 
};

hab2 = {
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "orador",
        "descripcion_habilidad" : "Orar a dios y dar esperanzas a los danmificados y desaparecidos",
        "cod_alfanumerico":"8E4QZ5EMWT"
    } 
  
};

hab3 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "cargero",
        "descripcion_habilidad" : "trasladar materiales y excombros pesados",
        "cod_alfanumerico":"WP58KH7U3E"
    } 
};

hab4 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "curar",
        "descripcion_habilidad" : "Curar y sanar heridad vitales, de grado medio y leves a los danmificados",
        "cod_alfanumerico":"US4Q4V4J63"
    } 
};

hab5 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "limpiar",
        "descripcion_habilidad" : "Realizar limpieza en hogares danmificados o terreno destruido",
        "cod_alfanumerico":"YEC8XL7HEY"
    } 
};

hab6 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "conductor",
        "descripcion_habilidad" : "conducir o manejar un vehiculo de carretera o carga cualquiera, ya sea un auto, camioneta, camión, moto, etc.",
        "cod_alfanumerico":"6VBYFDSB6M"
    } 
};

hab7 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "animador",
        "descripcion_habilidad" : "motivar y animar a los danmificados para salir adelante de la catastrofe.",
        "cod_alfanumerico":"FJQXFSQXQE"
    } 
};

hab8 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "recepcionar",
        "descripcion_habilidad" : "Recibir cualquier aporte realizado por la gente solidaria y generosa, ya sea alimentos no perecibles, agua, etc.",
        "cod_alfanumerico":"3YRH7DNCEB"
    } 
};

hab9 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "organizar",
        "descripcion_habilidad" : "Preparar un plan o una operacion para poder resguardar los viveres recibidos.",
        "cod_alfanumerico":"V33XBMJF77"
    } 
};

hab10 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "rescatista",
        "descripcion_habilidad" : "Realizar un rescate a los danmificados de la emergencia.",
        "cod_alfanumerico":"WEXA6ZAZPA"
    } 
};

hab11 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "rastreador",
        "descripcion_habilidad" : "Realizar una busqueda o rastreo para poder encontrar a las víctimas de la emergencia.",
        "cod_alfanumerico":"CUJJMTQNLP"
    } 
};

hab12 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "estratega",
        "descripcion_habilidad" : "Preparar un plan maestro para poder realizar un trabajo de rescate.",
        "cod_alfanumerico":"GFUYVU2WGY"
    } 
};

hab13 = {  
    "_id" : new ObjectId(),
    "info":{
        "nombre_habilidad" : "recolector",
        "descripcion_habilidad" : "Poder recolectar escombros y/o objetos pesados para despejar una cierta zona importante.",
        "cod_alfanumerico":"5PC822NU6Q"
    } 
};


print("***********guardando voluntarios*********");
db.voluntario.save(vol1);
db.voluntario.save(vol2);
db.voluntario.save(vol3);
db.voluntario.save(vol4);
db.voluntario.save(vol5);
db.voluntario.save(vol6);
db.voluntario.save(vol7);


print("***********guardando habilidades*********");
db.habilidad.save(hab1);
db.habilidad.save(hab2);
db.habilidad.save(hab3);
db.habilidad.save(hab4);
db.habilidad.save(hab5);
db.habilidad.save(hab6);
db.habilidad.save(hab7);
db.habilidad.save(hab8);
db.habilidad.save(hab9);
db.habilidad.save(hab10);
db.habilidad.save(hab11);
db.habilidad.save(hab12);
db.habilidad.save(hab13);


print("SCRIPT FINISHED");

