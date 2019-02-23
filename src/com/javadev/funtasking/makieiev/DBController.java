package com.javadev.funtasking.makieiev;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBController {
    public void connectToDB(){
        String URL = "jdbc:h2:castlegame";
        String USER = "admin";
        String PASSWORD = "admin";
        try{
            Class.forName("org.h2.Driver").newInstance();

        } catch (Exception e) {
        e.printStackTrace();
    }
}

}
