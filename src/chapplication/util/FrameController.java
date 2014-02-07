package chapplication.util;

import chapplication.gui.ChangePasswordGUI;
import chapplication.gui.ChapplicationGUI;
import chapplication.gui.LoginGUI;
import chapplication.gui.RegistrationGUI;

/**
 * @author James
 * @date Feb 6, 2014
 */
public class FrameController {
    private static ChangePasswordGUI cpg;
    private static ChapplicationGUI cg;
//    private static JoinServerGUI jsg;
    private static LoginGUI lg;
    private static RegistrationGUI rg;

    public FrameController(){
        initFrames();
    }
    
    private static void initFrames(){
        cpg=new ChangePasswordGUI();
        cg=new ChapplicationGUI();
//        jsg=new JoinServerGUI(null);
        lg=new LoginGUI();
        rg=new RegistrationGUI();
    }
    
    public static void start(){
        cg.setVisible(true);
    }
    
    public static ChangePasswordGUI getCpg() {
        return cpg;
    }

    public static ChapplicationGUI getCg(){
        return cg;
    }
    
    public static LoginGUI getLg() {
        return lg;
    }
    
    public static RegistrationGUI getRg(){
        return rg;
    }
}
