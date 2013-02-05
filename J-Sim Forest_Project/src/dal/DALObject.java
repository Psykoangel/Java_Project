
package dal;


import java.sql.*;


public class DALObject {
    private String url = new String();
    private String username = new String();
    private String password = new String();
    private Connection cnx;
    private PreparedStatement preStmt;
    private ResultSet result;
    private int tab[];;
    private int i = 0;
    private int count = 0;

    public ResultSet getResult() {
        return result;
    }
    public void setResult(ResultSet result) {
        this.result = result;
    }

    public DALObject() {
        try {
            if (cnx == null)    {
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
                }}
            else {
                System.out.println("Une connexion est déjà ouverte");
            }
        } catch (Exception ex) { 
            // Si connexion driver K.O.
            System.out.println("Chargement du driver K.O.");
        }
    }
    
    public ResultSet select() throws SQLException {
    String query = ("SELECT ID FROM test;");
    preStmt = cnx.prepareStatement(query);
    result = preStmt.executeQuery();
    while (result.next()) {
        count++;
        tab = new int[count];
        tab[i] = result.getInt("ID");
        System.out.println(tab[i]);
        i++;
    }
    //preStmt.close();
    return result;
    }
}

/*public void addEmployee(Employee e) throws SQLException {
        String req = ("INSERT INTO employes (nom ,prenom) VALUES (");
        req += "?";
        req += ", ?);";
        PreparedStatement prState = conn.prepareStatement(req);
        prState.setString(1, e.getName());
        prState.setString(2, e.getFirstName());
        prState.execute();
        prState.close();
    }*/