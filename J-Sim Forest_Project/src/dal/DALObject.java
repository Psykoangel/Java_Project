
package dal;


import java.sql.*;


public class DALObject {
    private String url = new String();
    private String username = new String();
    private String password = new String();
    private PreparedStatement preStmt;
    private Connection cnx;
    
    public DALObject() {
        try {
            System.out.println("Test de connexion au driver JDBC");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            try {
                System.out.println("Test de connexion à la BDD");
                url = "jdbc:mysql://localhost/jsimdb";
                username = "root";
                password = "";
                cnx = DriverManager.getConnection(url, username, password);
                System.out.println("BDD O.K.");
            } catch (SQLException e) {
            // Si connexion BDD K.O.
            System.out.println("SQLException: " + e.getMessage()); 
            System.out.println("SQLState: " + e.getSQLState()); 
            System.out.println("VendorError: " + e.getErrorCode()); 
            }
        } catch (Exception ex) { 
            // Si connexion driver K.O.
            System.out.println("Chargement du driver K.O.");
        }
    }
}
