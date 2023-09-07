package Individual_Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 Name: Ky Lam
 Date: 11/27/2022
 
 Individual Project (Word Game)
	Has 3 big majors, such as Fruit, Flower, Animal, the user can select 
	their preference from the beginning of the game.
	
	The user will have 100 points initially, after each question, 
	the score will be deducted, the user needs to keep the score as high as possible.

How does it calculate your score?
	If you answer incorrectly, you will immediately be deducted 10 points.
	If you answer correctly, you will be deducted points equal to the amount of time 
	it took you to enter your answer.
 */

public class Word 
{
	static ArrayList<String> Words = new ArrayList<>();
	
	public static void readFile (String fileName) throws FileNotFoundException
	{
		
		Scanner word = new Scanner (new File (fileName));
		for (int i = 0; i <= 9 ; i++) 
		{
			String keyword = word.next();
			Words.add(keyword);
		}
	}
	

	static HashMap <String, String> getNextWord() 
	{  
		   Random random = new Random();
		   int index = random.nextInt(Words.size());   
		   String answer = Words.get(index);
		   
		// split and shuffle 
		   List <String> temp = Arrays.asList(answer.split(""));
		   Collections.shuffle(temp);
		// make a question
		   String question = "";
		   for (int i=0; i<temp.size(); i++) 
		   {
			   question += temp.get(i);
		   }
		   
		//save question and answer to a hashMap
		   HashMap<String, String> hm = new HashMap<>();
		   hm.put(question, answer); // <ELPPA, APPLE>
		// return to the main app
		   return hm; // return question and answer
	}
	
	
}
