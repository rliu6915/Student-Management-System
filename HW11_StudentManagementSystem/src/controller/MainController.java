package controller;


import pojo.CourseInfo;
import pojo.StudentAssociationCurriculum;
import roles.Professor;
import roles.Student;
import tool.MyTool;
import files.FileInfoReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Control the main logic of the entire system
 * @author Renyu Liu
 *
 */
public class MainController {
    public FileInfoReader f;
    
    /**
     * Print the message
     */
    public MainController(){
        f = new FileInfoReader();
        // print the message
        if(f.load()){
            System.out.println("File data initialization completed!");
        }
        else {
            System.out.println("Initialization error, please check whether the file exists or whether the location format is wrong!");
        }

    }
    
    /**
     * Return true when you can log in as a student
     * @param username when log in as a student
     * @param password when log in as a student
     * @return true when you can log in 
     */
    public boolean loginAsStudent(String username,String password){
    	// check if it is a student 
        if(f.studentMap.get(username)!=null)
        // return this when it is a student
        return f.studentMap.get(username).password.equals(password);
        // return this when it is not a student
        else return false;
    }
    
    /**
     * Return true when you can log in as a professor
     * @param username when log in as a professor
     * @param password when log in as a professor
     * @return true when you can log in
     */
    public boolean loginAsProfessor(String username,String password){
    	// check if it is a professor 
        if(f.professorMap.get(username)!=null)
        // return this when it is a professor
        return f.professorMap.get(username).password.equals(password);
        // return this when it is not a professor
        else return false;
    }
    
    /**
     * Return true when you can log in as a admin
     * @param username when log in as a admin
     * @param password when log in as a admin
     * @return true when you can log in
     */
    public boolean loginAsAdmin(String username,String password){
    	// check if it is a admin
        if(f.adminMap.get(username)!=null)
        // return this when it is a admin
        return f.adminMap.get(username).password.equals(password);
        // return this when it is not a admin
        else return false;
    }
    
    // admin 
    
    /**
     * This method shows all the courses for admin
     */
    public void showAllCourse(){
    	// show all the courses
        for (CourseInfo c:f.course
             ) {
            int studentNum=0;
            // check for all the curriculum
            for (StudentAssociationCurriculum sac:f.Sac
                 ) {
            	// check for curriculumID
                if(sac.curriculumID.equals(c.ID))
                {
                	// add one of student
                    studentNum++;
                }
            }
            System.out.println(c.toString()+studentNum);
        }
    }
    

    /**
     * This method adds course for admin
     * @param a ID of the course
     * @param b courseName of the course
     * @param c teacherName of the course
     * @param d time of the course
     * @param e startTime of the course
     * @param f1 endTime of the course
     * @param g student number of the course
     * @return 0 if we can find the id 
     */
    public int addCourse(String a,String b,String c,String d,String e,String f1,String g){
        try {
        	// try the course 
            CourseInfo courseInfo = new CourseInfo(a, b, c, d, e, f1, g);
            for (CourseInfo ac:f.course
                 ) {
            	// return 0 if we can find the id 
                if(ac.ID.equals(a))return 0;
            }
            f.course.add(courseInfo);
        } catch (Exception e1) {
        	// return 1 for the exception
            return -1;
        }
        // otherwise, return 1
        return 1;
    }
    
    /**
     * This method deletes course for admin
     * @param a ID of the course
     * @return true if the course has been removed
     */
    public boolean deleteCourse(String a){
        try {
        	// create a null CourseInfo
            CourseInfo deletec=null;
            for (CourseInfo c:f.course
                 ) {
                if(c.ID.equals(a))
                {
                	// delete the course if ID is ok 
                    deletec=c;
                }
            }
            // return this if we delete the course
            return  f.course.remove(deletec);
        }catch (Exception e) {
        	// return this for exception 
            return false;
        }
    }
    
    
    /**
     * This method adds student for admin
     * @param v1 student ID
     * @param v2 student name 
     * @param v3 student username
     * @param v4 password
     * @return 0 if containing the student username
     */
    public int addStudent(String v1,String v2,String v3,String v4){
        try {
        	// try a student 
            Student student=new Student(v1,v2,v3,v4);
            // look at map if containing the student username
            if(f.studentMap.containsKey(v3))
            {
            	// return this if containing the student username
                return 0;
            }
            // put the student in the map 
            f.studentMap.put(v3,student);
        }catch (Exception e)
        {
        	// return this for exception
            return -1;
        }
        
        // otherwise, return this 
        return 1;

    }
    
    /**
     * This method deletes student for admin
     * @param username the imported the student username
     * @return true if find the student and remove
     */
    public boolean deleteStudnet(String username){
        try {
        	// try to remove a student, return this if cannot find the student
            if(f.studentMap.remove(username)==null)return false;
        }
        catch (Exception e)
        {
            return false;
        }
        // return this, if find the student and remove
        return true;
    }
    
    /**
     * This method adds teacher for admin
     * @param v1 prof ID
     * @param v2 prof name
     * @param v3 prof username
     * @param v4 prof password
     * @return 0 if containg prof username
     */
    public int addProfessor(String v1,String v2,String v3,String v4){
        try {
        	// try a professor
            Professor professor = new Professor(v1, v2, v3, v4);
            // check if containg prof username
            if(f.professorMap.containsKey(v3))
            {
            	// return this if containg prof username
                return 0;
            }
            // put the information into map 
            f.professorMap.put(v3, professor);
        }catch (Exception e)
        {
        	// return this for exception 
            return -1;
        }
        // otherwsie, return 1
        return 1;
    }
    
    /**
     * This method deletes teacher for admin
     * @param username professor username
     * @return true if find the professor and remove
     */
    public boolean deleteProfessor(String username){
        try {
        	// try to remove a professor, return this if cannot find the professor
            if(f.professorMap.remove(username)==null)return false;
        }
        catch (Exception e)
        {
            return false;
        }
        // return this, if find the professor and remove
        return true;
    }
    
    //student
    
    /**
     * This method show all the enrolled classes
     * @param studentID the ID of a student
     */
    public void showEnrolledCourse(String studentID){
        for (StudentAssociationCurriculum sac:f.Sac
             ) {
        	// check if this is specific student
            if(sac.studentID.equals(studentID))
            {
                System.out.println("CourseID: "+sac.curriculumID);

            }
        }
    }
    
    /**
     * This method add course for studnet
     * @param studentID The ID of a student
     * @param curriculumID the ID of a course 
     * @param grade grade of the course 
     * @return
     */
    public int studentAddCourse(String studentID,String curriculumID,String grade){
        try {
            List<CourseInfo>courseInfoList=new ArrayList<>();
            CourseInfo thecourse=null;
            for (CourseInfo cc:f.course
                    ) {
            	// if the course id can be found 
                if(cc.ID.equals(curriculumID)){
                	// the course is null 
                    thecourse=cc;
                    break;
                }
            }
            for (StudentAssociationCurriculum sac:f.Sac
                    ) { 
            	// find the student 
                if(sac.studentID.equals(studentID))
                {
                    for (CourseInfo cc:f.course
                         ) {
                        if(cc.ID.equals(sac.curriculumID)){
                        	// add the course
                            courseInfoList.add(cc);
                        }
                    }
                }
            }
            for (CourseInfo cc:courseInfoList
                 ) {
            	// check if the ID are the same 
                if(cc.ID.equals(thecourse.ID))return -2;
                // try to check if there is time confict 
                if(MyTool.isCoincidence(cc.startTime,thecourse.startTime,cc.endTime,thecourse.endTime))return -3;
            }
            StudentAssociationCurriculum sac = new StudentAssociationCurriculum(studentID, curriculumID, grade);
            f.Sac.add(sac);
        }catch (Exception e)
        {
        	// return this for exception 
            return -1;
        }
        // otherwise, return this 
        return 1;
    }
    
    /**
     * This method helps to delete course for student
     * @param studentID the ID of a student
     * @param courseID the ID of the course
     * @return true if he deletes a specific class 
     */
    public boolean studentDeleteCourse(String studentID,String courseID){
        try {
            StudentAssociationCurriculum deletesac=null;
            for (StudentAssociationCurriculum sac:f.Sac
                 ) {
            	// if all the information is ok 
                if(sac.curriculumID.equals(courseID)&&sac.studentID.equals(studentID))
                {
                	// delete the class
                    deletesac=sac;
                    break;
                }

            }
            // return this when removing the class
            return  f.Sac.remove(deletesac);
        }catch (Exception e)
        {
        	// return this for exception 
            return false;
        }
    }
    
    /**
     * This method shows the grade for student 
     * @param studentID the ID of a student
     */
    public void showGrade(String studentID){
        for (StudentAssociationCurriculum sac:f.Sac
                ) {
        	// check if this is the specific student
            if(sac.studentID.equals(studentID))
            {
                System.out.println("CourseID: "+sac.curriculumID+"  Grade: "+sac.grade);
            }
        }

    }
    
    
    //professor
    
    /**
     * This method shows all the courses
     * @param teacherName teacher name
     */
    public void showGiveCourse(String teacherName){
        for (CourseInfo c:f.course
             ) {
        	// check if the name is equal
            if(c.teacherName.equals(teacherName)) {
                System.out.println(c.toString());
            }
        }
    }
    
    /**
     * This method shows all the students for the course
     * @param teacherName teacher name
     */
    public void showCourseStudent(String teacherName){
        for (CourseInfo c:f.course
                ) {
        	// check if the name is equal
            if(c.teacherName.equals(teacherName))
            {
            	// print the message
                System.out.println("CourseID: "+c.ID+" CourseName: "+c.courseName);
                System.out.println("The list of students in the course is as follows:");
                for (StudentAssociationCurriculum sac:f.Sac
                        ) {
                	// check the course id 
                    if(sac.curriculumID.equals(c.ID))
                    {
                    	// check if this has specific student
                        if(f.studentMap.get(sac.studentID)!=null);
                        System.out.println("StduentID:  "+f.studentMap.get(sac.studentID).uid+"  Name:"+f.studentMap.get(sac.studentID).name);
                    }
                }
            }

        }

    }



}
