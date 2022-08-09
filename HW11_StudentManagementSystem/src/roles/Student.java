package roles;

/**
 * Represent a student
 * @author Renyu Liu
 *
 */
public class Student extends User{

	/**
	 * Represent a student
	 * @param uid student id 
	 * @param name student name 
	 * @param username the username of a student 
	 * @param password the password
	 */
    public Student(String uid, String name, String username, String password) {
        super(uid, name, username, password);
    }

    @Override
    public int privilegeLevel() {
        return 2;
    }
}
