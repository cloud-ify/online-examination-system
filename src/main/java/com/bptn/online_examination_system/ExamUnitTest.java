package com.bptn.online_examination_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ExamUnitTest {
	@Test
	public void testGrade() {
		Result testResult = new Result("Jane", "Doe", 30 , 5);
		String grade = testResult.printGrade(5); 
		assertEquals("D", grade);
	}
	@Test
	public void testReadandWriteVerifiedStudent() {
		List <Student> students = new ArrayList<>();
		students.add(new Student("Emma", "Noah", 1));
		students.add(new Student("Ben", "Sun", 6));
		students.add(new Student("Ann", "Mark", 1));
		RegisterStudent.writeRegisteredStudent("test.txt", students);
		
		List <Student> readStudents = RegisterStudent.readRegisteredStudents("test.txt");
		assertEquals(students.size(), readStudents.size()); 
		assertTrue(students.get(1).getId()== 6);
	}
	
	@AfterEach
	//clean up testfile after each test
	public void tearDown() {
		File testfile = new File("test.txt");
		if(testfile.exists()) {testfile.delete();}
	}
}
