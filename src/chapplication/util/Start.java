package chapplication.util;

/**
 * @author James
 * @date Feb 6, 2014
 */
public class Start {
    public static CTextUtilities localData;
    public static CServerUtilities globalData;
    
    public static void main(String[] args){
        initVariables();
    }
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private static void initVariables(){
        localData=new CTextUtilities();
        globalData=new CServerUtilities("USER");
        new FrameController();
        FrameController.start();
    }
    
}
