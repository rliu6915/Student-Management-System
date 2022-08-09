package pojo;

/**
 * Describe the students associated with curriculum
 * @author Renyu Liu 
 *
 */
public class StudentAssociationCurriculum {
	/**
	 * Create an instance of student ID
	 */
    public String studentID;
    
    /**
     * Create an instance of curriculum ID
     */
    public String curriculumID;
    
    /**
     * Create an instance of grade
     */
    public String grade;

    /**
     * Describe the students associated with curriculum
     * @param studentID of a course
     * @param curriculumID of a course
     * @param grade of a course
     */
    public StudentAssociationCurriculum(String studentID, String curriculumID, String grade) {
        this.studentID = studentID;
        this.curriculumID = curriculumID;
        this.grade = grade;
    }
}
