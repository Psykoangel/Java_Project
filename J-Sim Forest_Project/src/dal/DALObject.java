package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DALObject {
    private String url;
    private String username;
    private String password;
    private Connection cnx;
    private PreparedStatement preStmt;
    private ResultSet result;
    private ArrayList lst;
    private ArrayList<String[]> completeLst;
    
    //Accesseurs
    public ArrayList getLst() {
        return lst;
    }
    public ArrayList<String[]> getCompleteLst() {
        return completeLst;
    }

    //Constructeur
    public DALObject() {
        try {
            if (cnx == null) {
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
            }
            else {
                System.out.println("Une connexion est déjà ouverte");
            }
        } catch (Exception ex) { 
              // Si connexion driver K.O.
              System.out.println("Chargement du driver K.O.");
          }
    }
    
    //Récupération des information de la bdd pour générer le fichier .csv
    //Envoi DAL -> BOL
    public void exportCSVBDD() throws SQLException {
        completeLst = new ArrayList<>();
        String str = new String();
        String query = ("SELECT GRID FROM save;");
        preStmt = cnx.prepareStatement(query);
        result = preStmt.executeQuery();
        while (result.next()) {
            str = result.getString("GRID");
        }
        preStmt.close();
        String[] tab1 = str.split(";");
        for (int i = 0; i < tab1.length; i++) {
            String[] tab2 = tab1[i].split(",");
            completeLst.add(tab2);
        }
    }
    
    //Récupération des information de la bdd pour afficher les sauvegardes
    //Envoi DAL -> BOL
    public ArrayList showSave() throws SQLException {
        String query = ("SELECT NAME FROM save ORDER BY ID;");
        preStmt = cnx.prepareStatement(query);
        result = preStmt.executeQuery();
        lst = new ArrayList<>();
        while (result.next()) {
            lst.add(result.getString("NAME"));
        }
        preStmt.close();
        return lst;
    }
    
    //Récupération des information de la bdd pour récupérer les données de la sauvegarde
    //Envoi DAL -> BOL
    public ArrayList selectSave() throws SQLException {
        int test = 1;
        String query = ("SELECT TX, TY, STT, SN, GRID FROM save WHERE ID = ?;");
        preStmt = cnx.prepareStatement(query);
        preStmt.setInt(1, test);
        result = preStmt.executeQuery();
        lst = new ArrayList<>();
        while (result.next()) {
            lst.add(result.getInt("TX"));
            lst.add(result.getInt("TY"));
            lst.add(result.getInt("STT"));
            lst.add(result.getInt("SN"));
            lst.add(result.getString("GRID"));
            System.out.println(lst);
        }
        preStmt.close();
        return lst;
    }
    
    //Update pour modifier ou écraser les données en BDD
    //BOL -> DAL
    /*public void updateSave() throws SQLException {
        String req = ("UPDATE save SET NAME = ?, TX = ?, TY = ?, STT = ?, SN = ?, GRID = ? WHERE ID = ?;");
        PreparedStatement preStmt = cnx.prepareStatement(req);
        preStmt.setString(1, VARIABLE_RECUP_ID);
        preStmt.setString(2, VARIABLE_RECUP_ID);
        preStmt.setString(3, VARIABLE_RECUP_ID);
        preStmt.setString(4, VARIABLE_RECUP_ID);
        preStmt.setString(5, VARIABLE_RECUP_ID);
        preStmt.setString(6, VARIABLE_RECUP_ID);
        preStmt.setString(7, VARIABLE_RECUP_ID);
        preStmt.execute();
        preStmt.close();
    }
    
    //Suppresion d'une sauvegarde
    //BOL -> DAL
    public void deleteSave() throws SQLException {
        String req = ("DELETE FROM save WHERE ID = ?;");
        PreparedStatement preStmt = cnx.prepareStatement(req);
        preStmt.setString(1, VARIABLE_RECUP_ID);
        preStmt.execute();
        preStmt.close();
    }
    
    //Ajout d'une sauvegarde dans la BDD
    // BOL -> DAL
    public void insertSave() throws SQLException {
        String query = ("INSERT INTO employes (NAME, TX, TY, STT, SN, GRID) VALUES (?,?,?,?,?,?,?);");
        preStmt.setString(1, VARIABLE_RECUP_ID);
        preStmt.setString(2, VARIABLE_RECUP_ID);
        preStmt.setString(3, VARIABLE_RECUP_ID);
        preStmt.setString(4, VARIABLE_RECUP_ID);
        preStmt.setString(5, VARIABLE_RECUP_ID);
        preStmt.setString(6, VARIABLE_RECUP_ID);
        preStmt.setString(7, VARIABLE_RECUP_ID);
        preStmt = cnx.prepareStatement(query);
        preStmt.execute();
        preStmt.close();
    }*/
}