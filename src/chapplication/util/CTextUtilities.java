package chapplication.util;
/**
 * @author james.wolff
 * @date Sep 18, 2013
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTextUtilities implements CUtilities{
    private TFileReader tfr;
    private ArrayList<Object[]> userInfo;
    public CTextUtilities(){
        initUserInfo();
    }
    @Override
    public boolean usernameAvaliable(String user){
        ArrayList<String> userNames=getUserNames();
        for(String s:userNames){
            if(s.equals(user)){
                return false;
            }
        }
        return true;
    }
    @Override
    public ArrayList getUserInfo(){
        TFileReader tfr=new TFileReader("./userinfo.txt");
        ArrayList<String> users=null;
        try{
            users=tfr.readFile();
        }catch(FileNotFoundException e){
        }
        return users;
    }
    @Override
    public ArrayList getUserNames(){
        ArrayList<String> temp=getUserInfo();
        if(temp==null){
            return null;
        }
        ArrayList<String> userNames=new ArrayList<>();
        for(String s:temp){
            int x=0;
            while(s.charAt(x)!='|'){
                x++;
            }
            userNames.add(s.substring(0, x));
        }
        return userNames;
    }

    @Override
    public boolean validPassword(String user, String pass) {
        String temp;
        Integer i;
        for(Object[]o:userInfo){
            i=(Integer)o[1];
            temp=(String)o[0];
            temp=temp.substring(0, i.intValue());
            if(user.equals(temp)){
                String temp1=(String)o[0];
                return pass.equals(temp1.substring(i.intValue()));
            }
        }
        return false;
    }

    @Override
    public boolean validUsername(String user) {
        String temp;
        Integer i;
        for(Object[]o:userInfo){
            i=(Integer)o[1];
            temp=(String)o[0];
            temp=temp.substring(0, i.intValue());
            if(user.equals(temp)){
                
            }
        }
        return false;
    }
    private void initUserInfo(){
        tfr=new TFileReader("./userInfo.txt");
        userInfo=new ArrayList<>();
        ArrayList<String> strings;
        Object[]o;
        try {
            strings=tfr.readFile();
            for(String s:strings){
                o=new Object[2];
                o[0]=s;
                char[] cs=s.toCharArray();
                int x=0;
                for(char c:cs){
                    if(c=='|'){
                        o[1]=new Integer(x);
                        break;
                    }
                    x++;
                }
                userInfo.add(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(CTextUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

