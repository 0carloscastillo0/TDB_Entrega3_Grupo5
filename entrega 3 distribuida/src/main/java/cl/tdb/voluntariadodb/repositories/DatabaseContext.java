package cl.tdb.voluntariadodb.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.sql2o.Sql2o;


@Configuration
public class DatabaseContext {
    //urls de las bases de datos distribuidas.
    @Value("${database.url0}")
    private String dbUrl0;

    @Value("${database.url1}")
    private String dbUrl1;

    @Value("${database.url2}")
    private String dbUrl2;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPass;

    //constructores de las bases de datos, Bean permite conectar para que automaticamente se aplique el constructor al usar @autowired en otra clase, se les puede asignar nombre clave.
    @Bean(name="dsMaster")
    @Primary
    public Sql2o sql2oM(){
            return new Sql2o(dbUrl0,dbUser,dbPass);
    }

    @Bean(name="dsSlave1")
    public Sql2o sql2oS1(){
            return new Sql2o(dbUrl1,dbUser,dbPass);
    }

    @Bean(name="dsSlave2")
    public Sql2o sql2oS2(){
            return new Sql2o(dbUrl2,dbUser,dbPass);
    }
}