package com.bptn.online_examination_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RegisterStudent {

	//method that takes a file, reads the file and returns a list
	//@SuppressWarnings("unchecked")
	public static List<Student> readRegisteredStudents(String filename) {

		//creates a list of read-registered-student
		List <Student> readRegisteredStudents = new ArrayList<>();

		//uses fileinputstream and objectinputstream to read the file
		try (ObjectInputStream readRegisteredStud = new ObjectInputStream(new FileInputStream(filename))) {
			readRegisteredStudents = (List<Student>)readRegisteredStud.readObject();
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();//prints stack trace if any of the caught exception occurs for debugging
		}
		return readRegisteredStudents;	//returns list
	}

	//method that takes a file, writes objects to the file
	public static void writeRegisteredStudent(String filename, List<Student> students) {

		try {//uses fileoutputstream and objectoutputstream to write the file
			FileOutputStream registeredStudent = new FileOutputStream(filename);
			ObjectOutputStream writeRegStudent = new ObjectOutputStream(registeredStudent);
			writeRegStudent.writeObject(students);	//writes student object to the file
			writeRegStudent.flush();	//flushes the writer
			writeRegStudent.close();	//close the writer
		} 
		catch (IOException e) {
			//prints stack trace if exception occurs for debugging
			e.printStackTrace();
		}
	}

	//method that takes a list of student, verifies inputed student attribuutes against the list
	public static Student verifyStudent(List<Student> students) {

		//initializes capturedstudent
		Student capturedstudent = null;  
		// creates an object of the scanner class
		Scanner scan = new Scanner(System.in);

		//prompts students to enter  credentials , reads and stores the input
		System.out.print("Enter your firstname: ");
		String studentFirstName = scan.nextLine();

		System.out.print("Enter your lastname: ");
		String studentLastName = scan.nextLine();
		System.out.print("Enter your id: ");
		int studentId = 0; 

		//ensures the right input is entered
		try { 
			studentId = scan.nextInt();
			scan.nextLine();
		}
		catch(InputMismatchException e){
			System.out.println("Invalid ID format. Please enter a nemeric Id value");
			scan.nextLine();
		}


		boolean isVerify = false;		//sets isverified to false

		//iterate through the students list to check compared the dentered student with student objects in the list 
		for(Student student: students) {

			// if there is a match for entered student in the list of students, informs student of their verification status and isverify becomes true
			if( (student.getFirstName().equalsIgnoreCase(studentFirstName)) && (student.getLastName().equalsIgnoreCase(studentLastName)) && (student.getId()==studentId) ) {
				System.out.println("You have been verified");
				isVerify =true;
				capturedstudent = student;		//sets captured student to entered student
				break;
			}
		}
		// if there is no match for entered student in the list of students, informs student of their status and write student to the registered_student file becomes
		if(!isVerify){
			System.out.println("You are not a registered student. Addding student to verified list");
			Student newStudent = new Student(studentFirstName, studentLastName, studentId); //creates a new student object to be added to the students list
			students.add(newStudent); //adds new student to list
			writeRegisteredStudent("registered_student.txt", students);	//writes student to file
			capturedstudent = newStudent; //sets captured student to entered student				

		}
		return capturedstudent;  //returns capturedstudent

	}
}
