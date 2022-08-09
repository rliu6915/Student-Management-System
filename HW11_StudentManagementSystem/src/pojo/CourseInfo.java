package pojo;

/**
 * Describe the information of all the courses
 * @author Renyu Liu
 *
 */
public class CourseInfo {
    /**
     * Create an instance of ID
     */
	public String ID;
	
	/**
	 * Create an instance of course name
	 */
    public String courseName;
    
    /**
     * Create an instance of teacher name
     */
    public String teacherName;
    
    /**
     * Create an instance of time 
     */
    public String flag;
    
    /**
     * Create an instance of startTime
     */
    public String startTime;
    
    /**
     * Create an instance of endTime
     */
    public String endTime;
    
    /**
     * Create an instance of period
     */
    public String period;

    /**
     * Describe the information of all the courses
     * @param ID of the course
     * @param courseName of the course
     * @param teacherName of the course
     * @param flag of the course
     * @param startTime of the course
     * @param endTime of the course
     * @param period of the course
     */
    public CourseInfo(String ID, String courseName, String teacherName, String flag, String startTime, String endTime, String period) {
        this.ID = ID;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.flag = flag;
        this.startTime = startTime;
        this.endTime = endTime;
        this.period = period;
    }

    /**
     * Return the string 
     */
    @Override
    public String toString() {
        return ID+"|"+courseName+","+startTime+"-"+endTime+" on "+flag+",with course:"+period+",leturer:"+teacherName+",students:";
    }
}
