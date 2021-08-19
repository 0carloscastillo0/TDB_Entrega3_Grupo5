package cl.tdb.voluntariadodb.repositories;

public class Hash{

    public int hashFunction(int id, int numeroNodos){
        return id%numeroNodos;
    }

    public Hash(){

    }

}
