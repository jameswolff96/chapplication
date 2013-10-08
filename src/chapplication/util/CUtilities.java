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
     * @return true if username is used
     */
    public abstract boolean usernameExsists(String user);
    /**
     *
     * @param pass
     * @return true if password is used
     */
    public abstract boolean passwordExsists(String pass);
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
     * @return ArrayList<String> of passwords
     */
    public abstract ArrayList getPasswords();
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
