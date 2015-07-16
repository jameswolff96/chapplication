package chapplication.util;

/**
 * @author James
 * @date Feb 6, 2014
 */
public class Start {
    public static CTextUtilities localData;
    public static CServerUtilities globalData;
    
    public static void main(String[] args){
        initVariables(args);
    }
    private static void initVariables(String[] args){
        localData=new CTextUtilities();
        globalData=new CServerUtilities("USERS", args[0], args[1]);
        new FrameController();
        FrameController.start();
    }
    
}
