package files;

import pojo.CourseInfo;
import pojo.StudentAssociationCurriculum;
import roles.Admin;
import roles.Professor;
import roles.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Load the files
 * @author Renyu Liu
 *
 */
public class FileInfoReader {
    
	/**
	 * Create an instance of studentMap
	 */
	public Map<String, Student> studentMap=new HashMap<>();
    
	/**
	 * Create an instance of professorMap
	 */
	public Map<String, Professor> professorMap=new HashMap<>();
    
	/**
	 * Create an instance of adminMap
	 */
	public Map<String, Admin> adminMap=new HashMap<>();
    
	/**
	 * Create an instance of students associated with curriculum
	 */
	public List<StudentAssociationCurriculum> Sac=new ArrayList<>();
    
	/**
	 * Create an instance of a list of courses
	 */
	public List<CourseInfo>course=new ArrayList<>();
    
	/**
	 * Get the basePath
	 */
	private String basePath=FileInfoReader.class.getClassLoader().getResource("").getPath();
   
	/**
	 * Load the file
	 * @return true if can load the file 
	 */
    public boolean load(){
        try {
        loadAdminInfo();
        loadStudentInfo();
        loadCourseInfo();
        loadProfInfo();
        } catch (IOException e) {
            e.printStackTrace();
            // return false for exception 
            return false;
        }
        // return true if can load the file 
        return true;
    }
    
    /**
     * Save the file 
     * @return true if can save the file 
     */
    public boolean save(){
        try {
        saveStudentInfo();
        saveAdminInfo();
        saveCourseInfo();
        saveProfInfo();
        } catch (IOException e) {
            e.printStackTrace();
         // return false for exception 
            return false;
        }
        // return true if can save the file
        return true;
    }
    
    /**
     * Load the admin Information 
     * @throws IOException
     */
    private void loadAdminInfo() throws IOException {
        //System.out.println(basePath);
        FileInputStream inputStream = new FileInputStream(basePath+"adminInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
        	// split the file 
            String[]data=str.split(";");
            Admin admin=new Admin(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim());
            adminMap.put(data[2].trim(),admin);
        }
        //close
        inputStream.close();
        bufferedReader.close();

    }
    
    /**
     * Save the admin Information 
     * @throws IOException
     */
    private void saveAdminInfo() throws IOException{

        FileWriter fw=new FileWriter(new File(basePath+"adminInfo.txt"));
        
        BufferedWriter  bw=new BufferedWriter(fw);
        adminMap.forEach((key,value)->{
            try {
            	// write the file
                bw.write(value.uid+"; ");
                bw.write(value.name+"; ");
                bw.write(value.username+"; ");
                bw.write(value.password+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fw.close();
    }
    
    /**
     * Load the student Information
     * @throws IOException
     */
    private void loadStudentInfo() throws IOException{
        FileInputStream inputStream = new FileInputStream(basePath+"studentInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
        	// split the file 
            String[]data=str.split(";|,|:");
            int len=data.length;
            Student student=new Student(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim());
            studentMap.put(data[2].trim(),student);
            for (int i = 4; i <len ; i+=2) {
                Sac.add(new StudentAssociationCurriculum(data[2].trim(),data[i].trim(),data[i+1].trim()));
            }
        }
        //close
        inputStream.close();
        bufferedReader.close();
    }
    
    /**
     * Save the student Information
     * @throws IOException
     */
    private void saveStudentInfo() throws IOException{
        FileWriter fw=new FileWriter(new File(basePath+"studentInfo.txt"));
       
        BufferedWriter  bw=new BufferedWriter(fw);
        studentMap.forEach((key,value)->{
            try {
            	// write the file 
                bw.write(value.uid+"; ");
                bw.write(value.name+"; ");
                bw.write(value.username+"; ");
                bw.write(value.password+";");
                for (StudentAssociationCurriculum sac:Sac
                     ) {
                    if(sac.studentID.equals(value.username))
                    {
                        bw.write(sac.curriculumID+": ");
                        bw.write(sac.grade+",");
                    }
                }
                bw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fw.close();

    }
    
    /**
     * Load the professor Information
     * @throws IOException
     */
    private void loadProfInfo() throws IOException {
        FileInputStream inputStream = new FileInputStream(basePath+"profInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
        	// split the file 
            String[]data=str.split(";");
            Professor professor=new Professor(data[1].trim(),data[0].trim(),data[2].trim(),data[3].trim());
            professorMap.put(data[2].trim(),professor);
        }
        //close
        inputStream.close();
        bufferedReader.close();

    }
    
    /**
     * Save the professor Information
     * @throws IOException
     */
    private void saveProfInfo() throws IOException{

        FileWriter fw=new FileWriter(new File(basePath+"profInfo.txt"));
        
        BufferedWriter  bw=new BufferedWriter(fw);
        professorMap.forEach((key,value)->{
            try {
            	// write the file 
                bw.write(value.name+"; ");
                bw.write(value.uid+"; ");
                bw.write(value.username+"; ");
                bw.write(value.password+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fw.close();
    }
    
    /**
     * Load the course Information
     * @throws IOException
     */
    private void loadCourseInfo() throws IOException {
        FileInputStream inputStream = new FileInputStream(basePath+"courseInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
        	// split the file 
            String[]data=str.split(";");
            CourseInfo courseInfo=new CourseInfo(data[0].trim(),data[1].trim(),data[2].trim(),data[3].trim(),data[4].trim(),data[5].trim(),data[6].trim());
            course.add(courseInfo);
        }
        //close
        inputStream.close();
        bufferedReader.close();
    }
    
    /**
     * Save the course Information
     * @throws IOException
     */
    private void saveCourseInfo() throws IOException{

        FileWriter fw=new FileWriter(new File(basePath+"courseInfo.txt"));
        BufferedWriter  bw=new BufferedWriter(fw);
        for (CourseInfo c:course
             ) {
        	// write the file 
            bw.write(c.ID+"; ");
            bw.write(c.courseName+"; ");
            bw.write(c.teacherName+"; ");
            bw.write(c.flag+"; ");
            bw.write(c.startTime+"; ");
            bw.write(c.endTime+"; ");
            bw.write(c.period+"\n");
        }
        bw.close();
        fw.close();
    }

    /**
     * test the studentinfo
     * @param args
     */
    public static void main(String[] args) {
        //test
        FileInfoReader f=new FileInfoReader();
        try {
            f.loadStudentInfo();
            System.out.println(f.adminMap);
            f.saveStudentInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
