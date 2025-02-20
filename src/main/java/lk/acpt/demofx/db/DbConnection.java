package lk.acpt.demofx.db;/*Auther : Yasindu Sathsara
Place : ACPT's Lab*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection dbConnection;

    private Connection connection;

    //stop object creation
    private DbConnection() throws ClassNotFoundException, SQLException {
        //load the installed driver to this class
        Class.forName("com.mysql.cj.jdbc.Driver");

        //create a connection with database server and database
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "acpt");
    }

    public static DbConnection getDbConnection() throws SQLException, ClassNotFoundException {
        if(dbConnection==null){
            dbConnection =  new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
