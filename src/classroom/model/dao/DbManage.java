package classroom.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManage {
    private static final String dburl = "jdbc:mysql://localhost:3306/classmng_ex";
    private static final String dbuser = "root";
    private static final String dbpswd = "";
    private static Connection con;
    
    
    public static Connection conectarDb(){
        try{
            con = DriverManager.getConnection(dburl, dbuser, dbpswd);
            System.out.println("Conectado!");        
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }
    
    public static void desconectarDb(){
        if (con!=null){
            try {
                con.close();
                System.out.println("Desconectado!");       
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
