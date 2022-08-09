package view;

import controller.MainController;
import pojo.CourseInfo;
import roles.Professor;
import roles.Student;
import tool.MyTool;

import java.util.Scanner;

/**
 * View the management system
 * @author Renyu Liu
 *
 */
public class Boundary {
    MainController MC;
    
    /**
     * A new MainController
     */
    public Boundary(){
        MC=new MainController();
        init();
    }
    
    /**
     * Initialize all the things that you will display
     */
    public void init(){
    	// create a scanner
        Scanner sc=new Scanner(System.in);
        String usename;
        String password;
        
        // print the first message to start the system
        System.out.println("---------------------------");
        System.out.println("Students Management System");
        System.out.println("---------------------------");
        System.out.println("1 -- Login as a student");
        System.out.println("2 -- Login as a professor");
        System.out.println("3 -- Login as a admin");
        System.out.println("4 -- Quit the system");
        int c=sc.nextInt();
        // there are four cases
        switch (c){
            // student
            case 1:
                System.out.println("Please enter the username");
                usename=sc.next().trim();
                
                System.out.println("Please enter the password");
                password=sc.next().trim();
                
                if(MC.loginAsStudent(usename,password))
                {
                    clean();
                    Student student=MC.f.studentMap.get(usename);
                    operationStudent(student);
                }
                else {
                    clean();
                    System.out.println("The account does not exist or the password is wrong");
                    init();
                }
                sc.close();
                break;
            // professor
            case 2:
                System.out.println("Please enter the username");
                usename=sc.next().trim();
                System.out.println("Please enter the password");
                password=sc.next().trim();
                if(MC.loginAsProfessor(usename,password))
                {
                    clean();
                    Professor professor=MC.f.professorMap.get(usename);
                    operationProfessor(professor);
                }
                else {
                    clean();
                    System.out.println("The account does not exist or the password is wrong");
                    init();
                }
                sc.close();
                break;
            // Admin
            case 3:
                System.out.println("Please enter the username");
                //System.out.println(sc.nextLine());
                usename=sc.next();
                System.out.println("Please enter the password");
                password=sc.next();
                if(MC.loginAsAdmin(usename,password))
                {
                    clean();
                    operationAdmin();
                }
                else {
                    clean();
                    System.out.println("The account does not exist or the password is wrong");
                    init();
                }
                sc.close();
                break;
            // Leave the game 
            case 4:
                if(MC.f.save())
               {
                System.out.println("The program has exited");
                System.exit(0);
                }
                else {
                    System.out.println("Saving fail");
                }
                break;
            default:break;
        }
    }
    
    /**
     * Operate Admin
     */
    public void operationAdmin(){
        // Create scanner 
    	Scanner sc=new Scanner(System.in);
    	
    	// print message 
        System.out.println("---------------------------");
        System.out.println("     Welcome,admin");
        System.out.println("---------------------------");
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add new courses");
        System.out.println("3 -- Delete courses");
        System.out.println("4 -- Add new professor");
        System.out.println("5 -- Delete professor");
        System.out.println("6 -- Add new student");
        System.out.println("7 -- Delete student");
        System.out.println("8 -- Return to previous menu");
        int c=sc.nextInt();
        switch (c){
            // view courses
            case 1:
                MC.showAllCourse();
                operationAdmin();
                break;
            // add courses
            case 2:
                System.out.println("Please enter the course information to be added");
                System.out.println("Please enter the courseID");
                String a11=sc.next();
                System.out.println("Please enter the courseName");
                String a12=sc.nextLine();
                a12=sc.nextLine();
                System.out.println("Please enter the professorID or enter NA if this a new professor");
                String a13=sc.next();
                System.out.println("Please enter the professorName");
                String a14=sc.nextLine();
                a14=sc.nextLine();
                System.out.println("Please enter the time e.g. MW");
                String a15=sc.next();
                System.out.println("Please enter the startTime e.g. 8:30");
                String a16=sc.next();
                System.out.println("Please enter the endTime");
                String a17=sc.next();
                System.out.println("Please enter the course capacity");
                String a18=sc.next();
                //CourseInfo courseInfo=new CourseInfo(a11,a12,a13,a14,a15,a16,a17);
                if(MC.addCourse(a11,a12,a13,a14,a15,a16,a17)==1)
                {
                    System.out.println("Operation succeeded");
                }
                else if(MC.addCourse(a11,a12,a13,a14,a15,a16,a17)==0){
                    System.out.println("The course already exists");
                }
                else {
                    System.out.println("error,Operation failed");
                }
                // for a new professor 
                if(a13.equals("NA")) {
                    System.out.println("New professor detected, please complete the information");
                    System.out.println("Please enter the username");
                    String v2=sc.next();
                    System.out.println("Please enter the password");
                    String v3=sc.next();
                    String v4= MyTool.frontCompWithZore(MC.f.professorMap.size()+1,3);
                    //System.out.println(v4);
                    if(MC.addProfessor(v4,a14,v2,v3)==1)
                    {
                        System.out.println("Added successfully");
                    }
                    else if(MC.addProfessor(v4,a14,v2,v3)==0){
                        System.out.println("The username you entered is not available");

                    }
                    else {
                        System.out.println("Error,Please check the input");
                    }
                }
                operationAdmin();
                break;
            // delete a course
            case 3:
                System.out.println("Please enter the courseID to delete");
                String a111=sc.next();
                if(MC.deleteCourse(a111))
                {
                    System.out.println("Operation succeeded");
                }
                else {
                    System.out.println("Operation failed");
                }
                operationAdmin();
                break;
            // add a professor 
            case 4:
                System.out.println("Please enter the professor information to be added(Automatic ID generation)");
                System.out.println("Please enter the professor name");
                String v1=sc.nextLine();
                v1=sc.nextLine();
                System.out.println("Please enter the username");
                String v2=sc.next();
                System.out.println("Please enter the password");
                String v3=sc.next();
                String v4= MyTool.frontCompWithZore(MC.f.professorMap.size()+1,3);
                //System.out.println(v4);
                if(MC.addProfessor(v4,v1,v2,v3)==1)
                {
                    System.out.println("Added successfully");
                }
                else if(MC.addProfessor(v4,v1,v2,v3)==0){
                    System.out.println("The username you entered is not available");

                }
                else {
                    System.out.println("Error,Please check the input");
                }
                operationAdmin();
                break;
             // delete a professor 
            case 5:
                System.out.println("Please enter the professor username");
                String v=sc.next();
                if(MC.deleteProfessor(v))
                {
                    System.out.println("Delete succeeded");
                }
                else {
                    System.out.println("Please check the input");
                }
                operationAdmin();
                break;
             // add a student
            case 6:
                System.out.println("Please enter the student information to be added(Automatic ID generation)");
                System.out.println("Please enter the student name");
                String v11=sc.nextLine();
                v11=sc.nextLine();
                System.out.println("Please enter the username");
                String v21=sc.next();
                System.out.println("Please enter the password");
                String v31=sc.next();
                String v41= MyTool.frontCompWithZore(MC.f.studentMap.size()+1,3);
                //System.out.println(v4);
                if(MC.addStudent(v41,v11,v21,v31)==1)
                {
                    System.out.println("Added successfully");
                }
                else if(MC.addProfessor(v41,v11,v21,v31)==0){
                    System.out.println("The username you entered is not available");

                }
                else {
                    System.out.println("Error,Please check the input");
                }
                operationAdmin();
                break;
             // delete a student
            case 7:
                System.out.println("Please enter the student username");
                String v0=sc.next();
                if(MC.deleteStudnet(v0))
                {
                    System.out.println("Delete succeeded");
                }
                else {
                    System.out.println("Please check the input");
                }
                operationAdmin();
                break;
            // Leave
            case 8:
                clean();
                MC.f.save();
                init();
                break;
            default:
                System.out.println("Invalid selection");
                operationAdmin();
                break;
        }
    }
    
    /**
     * Operate student
     * @param student
     */
    public void operationStudent(Student student){
    	// Create a scanner
        Scanner sc=new Scanner(System.in);
        // print the message
        System.out.println("---------------------------");
        System.out.println("Welcome,"+student.name);
        System.out.println("---------------------------");
        System.out.println("1 -- View all courses");
        System.out.println("2 -- Add courses to your list");
        System.out.println("3 -- View enrolled courses");
        System.out.println("4 -- Drop courses in your list");
        System.out.println("5 -- View grades");
        System.out.println("6 -- Return to previous menu");
        int c=sc.nextInt();
        switch (c){
            // view all courses
            case 1:
                MC.showAllCourse();
                operationStudent(student);
                break;
            // add courses
            case 2:
                System.out.println("Please enter the courseID you need to add");
                String v1=student.username;
                String v2=sc.next();
                String v3="undetermined";
                if(MC.studentAddCourse(v1,v2,v3)==1)
                {
                    System.out.println("Added successfully");
                }
                else if(MC.studentAddCourse(v1,v2,v3)==-2){
                    System.out.println("the course you select is already in your list");
                }
                else if(MC.studentAddCourse(v1,v2,v3)==-3)
                {
                    System.out.println("The course you select has time conflict with other course");
                }
                else {
                    System.out.println("Error,Please check the input");
                }
                operationStudent(student);
                break;
             // enrolled courses
            case 3:
                MC.showEnrolledCourse(student.username);
                operationStudent(student);
                break;
            // drop courses
            case 4:
                System.out.println("Please enter the coureseID");
                String v0=sc.next();
                if(MC.studentDeleteCourse(student.username,v0))
                {
                    System.out.println("Delete succeeded!");
                }
                else {
                    System.out.println("Please check the input!");
                }
                operationStudent(student);
                break;
            // view grades
            case 5:
                MC.showGrade(student.username);
                operationStudent(student);
                break;
            // Leave
            case 6:
                clean();
                MC.f.save();
                init();
                break;
            default:
                System.out.println("Invalid selection");
                operationStudent(student);
                break;
        }
    }
    
    /**
     * Operate professor
     * @param professor
     */
    public void operationProfessor(Professor professor){
    	// create a scanner 
        Scanner sc=new Scanner(System.in);
        // print the message
        System.out.println("---------------------------");
        System.out.println("Welcome,"+professor.name);
        System.out.println("---------------------------");
        System.out.println("1 -- View given courses");
        System.out.println("2 -- View student list of the given course");
        System.out.println("3 -- Return to the previous menu");
        int c=sc.nextInt();
        //sc.close();
        switch (c){
            // view courses
            case 1:
                MC.showGiveCourse(professor.name);
                operationProfessor(professor);
                break;
            // view students
            case 2:
                MC.showCourseStudent(professor.name);
                operationProfessor(professor);
                break;
            // Leave
            case 3:
                clean();
                MC.f.save();
                init();
                break;
            default:
                System.out.println("Invalid selection!");
                operationProfessor(professor);
                break;
        }
    }
    
    /**
     * Clean the displays and add lines
     */
    public void clean(){
        System.out.println("------- Operation split line---------");
        for(int i=0;i<5;i++)
            System.out.println("");
    }
}
