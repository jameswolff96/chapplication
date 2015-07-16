package chapplication.util;
import java.io.File;
import java.io.IOException;
/**
 * @author james.wolff
 * @date Sep 18, 2013
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTextUtilities implements CUtilities{
    private TFileReader tfr;
    private TFileWriter tfw;
    private ArrayList<String[]> userInfo;
    public CTextUtilities() {
        initUserInfo();
    }
    @Override
    public boolean usernameExsists(String user){
        ArrayList<String> userNames=getUserNames();
        for(String s:userNames){
            if(s.equals(user)){
                return true;
            }
        }
        return false;
    }
    @Override
    public ArrayList getUserInfo(){
        return userInfo;
    }
    @Override
    public ArrayList getUserNames(){
        ArrayList<String[]> temp=getUserInfo();
        if(temp==null){
            return null;
        }
        ArrayList<String> userNames=new ArrayList<>();
        for(String[] s:temp){
            userNames.add(s[0]);
        }
        return userNames;
    }

    @Override
    public boolean validPassword(String user, String pass) {
        for(String[] s:userInfo){
            if(validUsername(user)){
                if(pass.equals(s[1])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validUsername(String user) {
        for(String[] s:userInfo){
            if(user.equals(s[0])){
                return true;
            }
        }
        return false;
    }
    public void writeUserInfo(String user, String pass){
        tfw=new TFileWriter("./userInfo.txt");
        tfw.write(user+"|"+pass);
    }
    private void initUserInfo() {
        tfr=new TFileReader("./userInfo.txt");
        userInfo=new ArrayList<>();
        ArrayList<String> strings;
        String[] sa;
        try {
            strings=tfr.readFile();
            for(String s:strings){
                sa=new String[2];
                char[] cs=s.toCharArray();
                int x=0;
                for(char c:cs){
                    if(c=='|'){
                        break;
                    }
                    x++;
                }
                sa[0]=s.substring(0,x);
                x++;
                sa[1]=s.substring(x);
                userInfo.add(sa);
            }
        } catch (Exception ex) {
        	try {
				new File("userInfo.txt").createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Logger.getLogger(CTextUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean passwordExsists(String pass) {
        ArrayList<String> passwords=getPasswords();
        for(String s:passwords){
            if(s.equals(pass)){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList getPasswords() {
        ArrayList<String> temp=getUserInfo();
        if(temp==null){
            return null;
        }
        ArrayList<String> passwords=new ArrayList<>();
        for(String s:temp){
            int x=0;
            while(s.charAt(x)!='|'){
                x++;
            }
            passwords.add(s.substring(x+1));
        }
        return passwords;
    }
}

