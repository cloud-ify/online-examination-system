package com.bptn.online_examination_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


public class Result extends Student {
	//create instance variable result and grade
	int score;
	String grade;

	//creates parameterized constructor
	Result(String firstName, String lastName, int id, int score) {
		super(firstName, lastName, id);
		this.score  = score;

	}


	//overloads the constructor
	Result(String firstName, String lastName, int id, int score, String grade) {
		super(firstName, lastName, id);
		this.score  = score;
		this.grade = grade;

	}


	//creates getter and setter methods
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	//	methods that takes the score and returns the grade
	public String printGrade(int score) {

		//checks for different stated conditions and assigns the matching grades
		if(score >=8 && score<=10) {
			grade = "A";
		}
		else if(score >=7 && score<8) {
			grade = "B";
		}
		else if(score >=6 && score<7) {
			grade = "C";
		}
		else if(score >=5 && score<6) {
			grade = "D";
		}
		else {
			grade = "F";
		}

		return grade;	

	}

	//method that saves the result to a file
	public static void saveResult(String filename, String result) {
		System.out.println("\nEnter 'y' to save your result or any key to exit");
		//creates a scanner to read the user input
		try (Scanner scanResult = new Scanner(System.in)) {
			String saveResult = scanResult.nextLine();		//reads user input

			//checks if the user wants to save the result
			if(saveResult.equalsIgnoreCase("y")) {//if yes write the result to give file name
				try {
					//creates the bufferedwriter to append the result
					BufferedWriter writeResult = new BufferedWriter(new FileWriter(filename, true));

					//writes the result to the file and closes the writer
					writeResult.write(result);
					writeResult.close();

					//notify student that the result has been saved
					System.out.println("Your result has been saved. \nThis is the end of your exam");
				} catch (IOException e) {
					e.printStackTrace();		//print if IOException occurs
				}}else {//if the student chooses not to save the result, notify them that exam has ended
					System.out.println("\nThis is the end of your exam");
				}
		}
	}
}

