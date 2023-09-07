package Individual_Project;
import java.io.FileNotFoundException;
import java.util.*;

import Project3.PostfixEvaluation;

/*
Name: Ky Lam
Date: 11/27/2022

*-Word Game-*
	Has 3 big majors, such as Fruit, Flower, Animal, the user can select 
	their preference from the beginning of the game.
	
	The user will have 100 points initially, after each question, 
	the score will be deducted, the user needs to keep the score as high as possible.

How does it calculate your score?
	If you answer incorrectly, you will immediately be deducted 10 points.
	If you answer correctly, you will be deducted points equal to the amount of time 
	it took you to enter your answer.
*/

public class WordApp 
{
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Ask user to choose the majors
		String fileName = majors();
		Word.readFile(fileName);
		
	
	// Crate an object of class Word
	Word word = new Word();
	boolean check = true;
	double point = 0.0;
	int correctTime = 0;
	double score = 0.0;
	
	
	
		while (check == true)
		{
			HashMap<String, String> w = word.getNextWord();
			String question = "";
			String answer = "";
	
			for (String q : w.keySet()) 
			{
				question = q;
				answer = w.get(q);
			}
			Scanner scan = new Scanner (System.in);
	
		
			// print the question
			System.out.println(question); 
			//get answer from user
			System.out.println("What word do these letters make?");         
			// set start time
			double startTime = System.currentTimeMillis(); 
			// input user answer
			String	userAnswer = scan.nextLine();
			// set end time
			double endTime   = System.currentTimeMillis();
			
			
			// Check answer
			if(answer.equalsIgnoreCase(userAnswer))
			{
			System.out.println("\nCorrect!!");
			correctTime += 1 ;
			// Display the response time
			// calculate duration (end time - start time in mili second)
				double totalTime = endTime - startTime;         
			// print response time in second (milisecond/1000)
				System.out.println("Response Time: " + totalTime/1000.0 + "sec"); 
				System.out.println();
				
				point = (point +  totalTime/1000.0)/correctTime;
			
			} else
			{
			System.out.println("\nWrong!!");
			System.out.println("Your score have been deducted 10");
			point += 15;	//Minus 15 point if the wrong answer
			}
	
			
			//Ask the user to CONTINUE?
			System.out.println("\nDo you want to continue?");
			System.out.println("Please say 'YES' if you want to continue");
			System.out.println("or say 'NO' if you want to stop");
			String play = scan.nextLine();
			
			if (play.equalsIgnoreCase("YES"))
			{
				check = true;
				System.out.println();
			} else
				if (play.equalsIgnoreCase("NO"))
				{
					check = false;
					System.out.println("\nBye..");
				}
			
		} 
		
		//Print Score:
		score = 100 - point;
		System.out.printf("Your score is: %3.2f" , score);
	}
	
	public static String majors() 
	{	
		System.out.println("What majors of words do you want to play?");
		System.out.println("Please enter 1 for Fruit, 2 for Flower, and 3 for Animal");
		Scanner input = new Scanner (System.in);
		int obtion = input.nextInt();
		String x = "";
		
		if (obtion == 1)
		{
			x = "fruit.txt";
		}else 
		if (obtion == 2)
		{
			x = "flower.txt";
		}else
		if (obtion == 3)
		{
			x = "animal.txt";
		}
		return x;
	}

}
