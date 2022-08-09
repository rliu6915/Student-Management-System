package roles;

/**
 * Represent a user
 * @author Renyu liu
 *
 */
public abstract class User {
	/**
	 * Create an instance of id 
	 */
    public String uid;
    
    /**
     * Create an instance of name
     */
    public String name;
    
    /**
     * Create an instance of username
     */
    public String username;
    
    /**
     * Create an instance of password
     */
    public String password;

 
    /**
     * abstract method for privilegeLevel()
     */
    public abstract int privilegeLevel();

    /**
     * Represent a user
     * @param uid of user 
     * @param name of user
     * @param username of user
     * @param password of user
     */
    public User(String uid, String name, String username, String password) {
        this.uid = uid;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
