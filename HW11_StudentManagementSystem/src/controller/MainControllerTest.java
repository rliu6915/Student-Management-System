package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods for MainController
 * @author Renyu Liu
 *
 */
class MainControllerTest {
	MainController MC;


	/**
	 * Set up for the tests
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MC=new MainController();
	}


	/**
	 * Test method for LoginAsStudent()
	 */
	@Test
	void testLoginAsStudent() {
		assertEquals(true, MC.loginAsStudent("testStudent01", "password590"));
		assertEquals(false, MC.loginAsStudent("Student", "123456"));
	}

	/**
	 * Test method for LoginAsProfessor()
	 */
	@Test
	void testLoginAsProfessor() {
		assertEquals(true, MC.loginAsProfessor("Greenberg", "password590"));
		assertEquals(false, MC.loginAsProfessor("test", "123456"));
	}

	/**
	 * Test method for LoginAsAdmin()
	 */
	@Test
	void testLoginAsAdmin() {
		assertEquals(true, MC.loginAsAdmin("admin02", "password590"));
		assertEquals(false, MC.loginAsAdmin("Student", "123456"));
	}

	

	/**
	 * Test method for AddCourse()
	 */
	@Test
	void testAddCourse() {
		assertEquals(1, MC.addCourse("1", "2", "3", "4", "5", "6", "7"));
	}

	/**
	 * Test method for DeleteCourse()
	 */
	@Test
	void testDeleteCourse() {
		assertEquals(false, MC.deleteCourse(null));
	}

	/**
	 * Test method for AddStudent()
	 */
	@Test
	void testAddStudent() {
		assertEquals(1, MC.addStudent("1", "2", "3", "4"));
	}

	/**
	 * Test method for DeleteStudnet()
	 */
	@Test
	void testDeleteStudnet() {
		assertEquals(false, MC.deleteStudnet(null));
	}

	/**
	 * Test method for AddProfessor()
	 */
	@Test
	void testAddProfessor() {
		assertEquals(1, MC.addProfessor("1", "2", "3", "4"));
	}

	/**
	 * Test method for DeleteProfessor()
	 */
	@Test
	void testDeleteProfessor() {
		assertEquals(false, MC.deleteProfessor(null));
	}

	

	/**
	 * Test method for StudentAddCourse()
	 */
	@Test
	void testStudentAddCourse() {
		assertEquals(1, MC.studentAddCourse("test", "test", "test"));
	}

	/**
	 * Test method for StudentDeleteCourse()
	 */
	@Test
	void testStudentDeleteCourse() {
		assertEquals(false, MC.studentDeleteCourse(null, null));
	}

	 

}
