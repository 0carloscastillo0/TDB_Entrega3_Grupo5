package cl.tdb.voluntariadodb.repositories;



import cl.tdb.voluntariadodb.models.Eme_Habilidad;
import cl.tdb.voluntariadodb.models.Habilidad;
import cl.tdb.voluntariadodb.services.HabilidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import java.util.ArrayList;
@Repository
public class EmeHabilRepositoryImp implements EmeHabilidadRepository{

    @Autowired
    @Qualifier("dsMaster")
    private Sql2o sql2o0;
    @Autowired
    @Qualifier("dsSlave1")
    private Sql2o sql2o1;
    @Autowired
    @Qualifier("dsSlave2")
    private Sql2o sql2o2;

    private Hash hash=new Hash();


    @Override
    public Eme_Habilidad crear(Eme_Habilidad eme_habilidad){
        int idAnterior;
        // se calcula el id anterior.
        try(Connection conn0 = sql2o0.open()){
            idAnterior = conn0.createQuery("SELECT COUNT(*) FROM eme_habilidad").executeScalar(Integer.class);
            conn0.close();
        }
        try(Connection conn1 = sql2o1.open()){
            idAnterior = idAnterior + conn1.createQuery("SELECT COUNT(*) FROM eme_habilidad").executeScalar(Integer.class);
            conn1.close();
        }
        try(Connection conn2 = sql2o2.open()){
            idAnterior = idAnterior + conn2.createQuery("SELECT COUNT(*) FROM eme_habilidad").executeScalar(Integer.class);
            conn2.close();        
        }

        //sentencia sql a ejecutar (una insercion).
        String sql = "INSERT INTO eme_habilidad (id_eme_habilidad ,id_emergencia, id_habilidad, nombre_tabla)" + "VALUES (:id, :id_eme, :id_habil, :nombre_tabla)";
        
        // hash del id de la emergencia de la insecion.
        int nodo=hash.hashFunction(eme_habilidad.getId_emergencia(),3);

        // se realiza la insercion en el nodo que corresponde.
        if(nodo==0){
            
            eme_habilidad.setNombre_tabla("eme_habilidad0");
            try(Connection conn = sql2o0.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_eme", eme_habilidad.getId_emergencia())
                .addParameter("id_habil", eme_habilidad.getId_habilidad())
                .addParameter("nombre_tabla", eme_habilidad.getNombre_tabla())
                .executeUpdate();
                
                
                conn.close();        
            }
        }
        else if(nodo==1){
           
            eme_habilidad.setNombre_tabla("eme_habilidad1");
            try(Connection conn = sql2o1.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_eme", eme_habilidad.getId_emergencia())
                .addParameter("id_habil", eme_habilidad.getId_habilidad())
                .addParameter("nombre_tabla", eme_habilidad.getNombre_tabla())
                .executeUpdate();
                conn.close();        
            }
        }
        else if(nodo==2){

            eme_habilidad.setNombre_tabla("eme_habilidad2");
            try(Connection conn = sql2o2.open()){
                conn.createQuery(sql, true)
                .addParameter("id",idAnterior + 1)
                .addParameter("id_eme", eme_habilidad.getId_emergencia())
                .addParameter("id_habil", eme_habilidad.getId_habilidad())
                .addParameter("nombre_tabla", eme_habilidad.getNombre_tabla())
                .executeUpdate();
                conn.close();        
            }
        }

        eme_habilidad.setId_eme_habilidad(idAnterior + 1);
        return eme_habilidad;
    }




    public List<String> habilidadesPorEmergencia(int id_emergencia){
        
        //sentencia sql a ejecutar.
        String sql = "select h.nombre_habilidad from habilidad h, eme_habilidad eh where eh.id_emergencia=:id and h.id_habilidad=eh.id_habilidad";
        
        // hash del id de la emergencia.
        int nodo=hash.hashFunction(id_emergencia,3);
        List<String> salida = new ArrayList<String>();

        // se realiza la sentencia en el nodo que corresponde.
        if(nodo==0){
            try(Connection conn = sql2o0.open()){
                String nombreEmergencia= conn.createQuery("SELECT nombre_emergencia from emergencia where id_emergencia=:id").addParameter("id",id_emergencia).executeScalar(String.class);
                List<Habilidad> habilidades=conn.createQuery(sql,true).addParameter("id",id_emergencia).executeAndFetch(Habilidad.class);
                salida.add("emergencia");
                salida.add(nombreEmergencia);
                salida.add("tabla_emergencia");
                salida.add("emergencia0");
                for (Habilidad habilidad : habilidades) {
                    salida.add("habilidad:");
                    salida.add(habilidad.getNombre_habilidad());
                    salida.add("tabla_eme_habilidad");
                    salida.add("eme_habilidad0");
                }
                conn.close();        
            }
        }
        else if(nodo==1){
            try(Connection conn = sql2o1.open()){
                String nombreEmergencia= conn.createQuery("SELECT nombre_emergencia from emergencia where id_emergencia=:id").addParameter("id",id_emergencia).executeScalar(String.class);
                List<Habilidad> habilidades=conn.createQuery(sql,true).addParameter("id",id_emergencia).executeAndFetch(Habilidad.class);
                salida.add("emergencia");
                salida.add(nombreEmergencia);
                salida.add("tabla_emergencia");
                salida.add("emergencia1");
                for (Habilidad habilidad : habilidades) {
                    salida.add("habilidad:");
                    salida.add(habilidad.getNombre_habilidad());
                    salida.add("tabla_eme_habilidad");
                    salida.add("eme_habilidad1");
                }
                conn.close();   
            }
        }
        else if(nodo==2){
            try(Connection conn = sql2o2.open()){
                String nombreEmergencia= conn.createQuery("SELECT nombre_emergencia from emergencia where id_emergencia=:id").addParameter("id",id_emergencia).executeScalar(String.class);
                List<Habilidad> habilidades=conn.createQuery(sql,true).addParameter("id",id_emergencia).executeAndFetch(Habilidad.class);
                salida.add("emergencia");
                salida.add(nombreEmergencia);
                salida.add("tabla_emergencia");
                salida.add("emergencia2");
                for (Habilidad habilidad : habilidades) {
                    salida.add("habilidad:");
                    salida.add(habilidad.getNombre_habilidad());
                    salida.add("tabla_eme_habilidad");
                    salida.add("eme_habilidad2");
                }
                conn.close();   
            }
        }

        return salida;

    }
}
