package com.bptn.online_examination_system;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Exam {

	//create a method that reads the question from the question bank and returns a map with key as question and value as answer
	public static Map<String, String> readQuestion(String filename) {
		Map<String, String> questionAndAnswer = new HashMap<>();	//Initializes the map to store questions and answers.
		try {
			Scanner scanQuestion = new Scanner(Path.of(filename));	//Creates a Scanner to read the file specified by the filename.
			while(scanQuestion.hasNext()) {							//Checks if there is another line to read in the file.
				String readQuestion = scanQuestion.nextLine();		//stores the read line from the file in a variable readQuestion
				String[] quest = readQuestion.split("/");			//splits the line in question and answer
				questionAndAnswer.put(quest[0], quest[1].strip());	// Adds the question and answer to the map		
			}
			scanQuestion.close();
		} catch (IOException e) {									//catches IOException exception
			e.printStackTrace();									//Prints the stack trace for debugging
		}

		return questionAndAnswer;									//returns the map with question and answer

	}


	//creates a method that displays question and check inputed answers from student for correctness. 
	public static int displayExam() {

		// Read questions and answers from a file and store them in a map.
		Map<String, String> questionAndAnswer = readQuestion("questions.txt");
		Set<String> questions = questionAndAnswer.keySet();		 	// Get the set of questions from the map keys.
		List<String> questionList = new ArrayList<>(questions);		// Convert the set of questions into a list for shuffling.
		Collections.shuffle(questionList);							// Shuffle the list of questions to randomize the order.					
		System.out.println("\nPlease answer the following questions.\nYou will be presented with ten(10) questions. Enter one of options A, B, C, or D for each question.\n");

		Scanner scanAnswer = new Scanner(System.in);				// Create a Scanner object to read the student's answers from the console.

		// Initialize the counter for numbering questions and result counter to keep track of correct answers
		int counter = 1;
		int score = 0;

		// Iterate through the first 10 questions in the shuffled list.
		for(String question : questionList.subList(0,10) ) {
			System.out.println(counter + ". " + question);					// Print the question number and the question text.
			System.out.println("Enter options Between A - D");				//prompt the student to enter a response
			String answer = scanAnswer.nextLine(); 							// reads the student response from the console

			// Ensure the student's answer is valid (between A and D).
			while(!(answer.equalsIgnoreCase("A")) && !(answer.equalsIgnoreCase("B")) && !(answer.equalsIgnoreCase("C")) && !(answer.equalsIgnoreCase("D"))) {
				System.out.println("Invalid Response, enter a valid input between A-D");
				answer = scanAnswer.nextLine();			
			}
			if (answer.equalsIgnoreCase(questionAndAnswer.get(question))) {// Check if the student's answer matches the correct answer from the map.
				System.out.println("Correct Response");						// If the answer is correct, print a confirmation message 
				score++;													//increment the result counter.
			}else {
				System.out.println("Incorrect response");					//prints if answer is incorrect
			}
			counter++;														//increments counter
		}

		return score;														//return result


	}	
}
