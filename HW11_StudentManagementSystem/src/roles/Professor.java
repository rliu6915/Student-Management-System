package roles;

/**
 * Represent a professor
 * @author Renyu Liu
 *
 */
public class Professor extends User{
    /**
     * Represent a professor
     * @param uid prof ID
     * @param name prof name
     * @param username prof username
     * @param password prof password
     */
	public Professor(String uid, String name, String username, String password) {
        super(uid, name, username, password);
    }

    @Override
    public int privilegeLevel() {
        return 0;
    }
}
