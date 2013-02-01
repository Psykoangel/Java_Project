
package dal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DALObject {
    private String login;
    private String password;
    private String url;
    private String nameBDD;
    private Connection connection;
    private String querySql;
    private PreparedStatement stmt;
    
    public DALObject() {
        /*try {
            this.login = "root";
            this.password = "";
            this.nameBDD = "";
            this.url = "jdbc:mysql://localhost:3306/"+this.nameBDD;
            this.connection = DriverManager.getConnection(url,login,password);
            System.out.println("-- Connexion reussit --");
        } catch (SQLException e){
            System.out.println("-- Erreur de connexion --");
        }*/
    }
}
