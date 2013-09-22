package chapplication.util;
import java.util.ArrayList;

/**
 * @author james.wolff
 * @date Sep 16, 2013
 */
public interface CUtilities {
    /**
     *
     * @param user
     * @return returns true if username is not used
     */
    public abstract boolean usernameAvaliable(String user);
    /**
     *
     * @return ArrayList<String> of usernames and passwords
     */
    public abstract ArrayList getUserInfo();
    /**
     *
     * @return ArrayList<String> of usernames
     */
    public abstract ArrayList getUserNames();

    /**
     *
     * @param user, pass
     * @return
     */
    public abstract boolean validPassword(String user, String pass);

    /**
     *
     * @param user
     * @return
     */
    public abstract boolean validUsername(String user);
}
