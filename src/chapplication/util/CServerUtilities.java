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
    private static ArrayList<String[]> userInfo;
    public CServerUtilities(String table){
        initSeverConnection();
        initUserInfo();
        tblName=table;
    }
    @Override
    public boolean usernameExsists(String user) {
        try {
            stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT userID FROM "+tblName+" WHERE userID EQUALS "+user);
            stmt.close();
            return result.getString("userID").equals(user);
        } catch (SQLException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean passwordExsists(String pass) {
        try {
            stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT password FROM "+tblName+" WHERE password EQUALS "+pass);
            stmt.close();
            return result.getString("password").equals(pass);
        } catch (SQLException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validUsername(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            ResultSet result=stmt.executeQuery("select userID from ROOT_ADMIN.USERS");
            String[] sa=new String[2];
            while(result.next()){
                sa[0]=result.getString(2);
                sa[1]=result.getString(3);
                userInfo.add(sa);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CServerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
