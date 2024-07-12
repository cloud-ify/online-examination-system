package com.bptn.online_examination_system;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//File myfile = new File("./registeredStudent.txt");
		//initialize list of students
		List<Student> students = new ArrayList<>();
		
		//reads the list of registered student from registered_student.txt and saves it to the students list
		students = RegisterStudent.readRegisteredStudents("registered_student.txt");
		
		//verify the student and stores the student object to variable capturedstudent
		Student capturedstudent = RegisterStudent.verifyStudent(students);
		
		//publish the exam and returns score and stores it to variable score 
		int score = Exam.displayExam();
		
		//creates a result object to store the student result detail
		Result myResult = new Result(capturedstudent.getFirstName(), capturedstudent.getLastName(), capturedstudent.getId(), score);
		
		//prints the student grade based on the score and stores the grade as myGrade
		String myGrade = myResult.printGrade(score);
		
		//creates a result object to store the student result detail including grade
		Result myResultDetails = new Result(capturedstudent.getFirstName(), capturedstudent.getLastName(), capturedstudent.getId(), score, myGrade);
		
		//format the result resultDetail as a string for saving
		String resultDetail = "First Name: " + myResultDetails.firstName + " | " +  "Last Name: " + myResultDetails.lastName + " | " + "Student ID: " + myResultDetails.id + " | " +  "Score: " + myResultDetails.score + " | " +  "Grade: " + myResultDetails.grade + "\n";
		
		//format the result resultDetail as a string for display
		//System.out.println(students);
		String myFinalResult =String.format("Name: %s %s \nStudent id: %d \nScore: %d \nGrade: %s", myResultDetails.firstName, myResultDetails.lastName,  myResultDetails.id, myResultDetails.score, myResultDetails.grade);
		
		//displays result
		System.out.println("\n------------------------------------------\nYour results are displayed below. \n" + myFinalResult + "\n------------------------------------------");
		//System.out.println("\n------------------------------------------");
		
		
		//saves result details to student_result.txt
		Result.saveResult("student_result.txt", resultDetail);
		
		
		
//		scan.close();
//		System.out.println("Your Result"
//				+ "\n Name: " + myResultDetails.firstName + " " + myResultDetails.lastName +
//				"\nStudent id: " + myResultDetails.id  + 
//				"\nScore: " + myResultDetails.result + " out of 10" +
//				"\nGrade: " +  myResultDetails.grade);
//		
		

		
	}
	
} 

	

