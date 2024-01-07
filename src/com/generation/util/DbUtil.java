package com.generation.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil 
{

    public static Connection connectToDB(String dbName) throws Exception
    {
        String versione = "com.mysql.cj.jdbc.Driver";
        Class.forName(versione);   
        String dbInformations = "jdbc:mysql://localhost:3306/"+dbName+"?user=jaita&password=jaita107";
        Connection tubo = DriverManager.getConnection(dbInformations);
        return tubo;
    }

    public static String toQuote(String in)
    {
        return "'"+in+"'";
    }
    
}
