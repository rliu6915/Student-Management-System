package roles;

/**
 * Represent a admin
 * @author Renyu Liu
 *
 */
public class Admin extends User {
    @Override
    public  int privilegeLevel(){
        return 1;
    };

    /**
     * Represent a admin
     * @param uid admin ID
     * @param name admin name
     * @param username admin username
     * @param password admin password
     */
    public Admin(String uid, String name, String username, String password) {
        super(uid, name, username, password);
    }
}
