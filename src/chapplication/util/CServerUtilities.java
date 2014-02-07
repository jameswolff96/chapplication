package chapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author james.wolff
 * @date Sep 18, 2013
 */
public class CServerUtilities implements CUtilities{
    private static Connection conn;
    private static Statement stmt;
    private static String tblName;
    private static final String DEFAULT_SCHEMA="ROOT_ADMIN";
    private static ArrayList<String[]> userInfo;
    public CServerUtilities(String table){
        tblName=table;
        initSeverConnection();
        initUserInfo();
    }
    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean usernameExsists(String user) {
        try {
            stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT userID FROM "+DEFAULT_SCHEMA+"."+tblName+" WHERE userID=\'"+user+"\'");
            result.next();
            result.getString("userID").equals(user);
            stmt.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean passwordExsists(String pass) {
        try {
            stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT pass FROM "+DEFAULT_SCHEMA+"."+tblName+" WHERE pass=\'"+pass+"\'");
            result.next();
            result.getString("pass").equals(pass);
            stmt.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public ArrayList getUserInfo() {
        return userInfo;
    }

    @Override
    public ArrayList getUserNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getPasswords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validPassword(String user, String pass) {
        if(passwordExsists(pass)){
            try {
                stmt=conn.createStatement();
                ResultSet result=stmt.executeQuery("SELECT * FROM "+DEFAULT_SCHEMA+"."+tblName+" WHERE userID=\'"+user+"\'");
                result.next();
                return result.getString("pass").equals(pass);
            } catch (SQLException ex) {
                Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean validUsername(String user) {
        return usernameExsists(user);
    }

    public void addUser(String username, String password){
        try {
            stmt=conn.createStatement();
            stmt.executeUpdate("INSERT INTO "+DEFAULT_SCHEMA+"."+tblName+" values (\'"+username+"\',\'"+password+"\')");
        } catch (SQLException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initSeverConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/chapplication;", "root_admin", "thisisareallylongpassword");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initUserInfo(){
        try {
            userInfo=new ArrayList<>();
            stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT * FROM "+DEFAULT_SCHEMA+"."+tblName);
            String[] sa=new String[2];
            while(result.next()){
                sa[0]=result.getString(1);
                sa[1]=result.getString(2);
                userInfo.add(sa);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteUser(String user, String pass){
        if(validPassword(user, pass)){
            System.out.println("hi");
            try {
                stmt=conn.createStatement();
                stmt.executeUpdate("DELETE FROM "+DEFAULT_SCHEMA+"."+tblName+" WHERE userID=\'"+user+"\'");
                stmt.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public void updateUser(String user, String oldPass, String newPass) {
        if(deleteUser(user, oldPass)){
            addUser(user, newPass);
        }else{
            
        }
    }
}
