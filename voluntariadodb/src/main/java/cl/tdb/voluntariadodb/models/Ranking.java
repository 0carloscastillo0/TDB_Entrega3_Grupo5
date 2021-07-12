package cl.tdb.voluntariadodb.models;

public class Ranking {
    private int id_ranking;
    private int valoracion_ranking;
    private int id_voluntario;
    private int id_tarea;


    public int getId() {
        return id_ranking;
    }

    public void setId_ranking(int id) {
        this.id_ranking = id;
    }

    public int getValoracion() {
        return valoracion_ranking;
    }

    public void setValoracion(int valoracion) {
        this.valoracion_ranking = valoracion;
    }

    public int getId_voluntario(){
        return id_voluntario;
    }
    public void setId_voluntario(int voluntario){
        this.id_voluntario=voluntario;
    }

    public int getId_tarea(){
        return id_tarea;
    }
    public void setId_tarea(int tarea){
        this.id_tarea=tarea;
    }
    

}
