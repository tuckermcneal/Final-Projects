import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Wordle {

	private int guesses = 0;
	private ArrayList<String> wordle_words = new ArrayList<>();
	private int randomNum;
	private String user_guess="";
	private int realguesses = 0;
	public Wordle(int ans) {

		///Decide what mode game is in
		if(ans==1) 
			guesses = 8; //easy
		else if(ans==2)
				guesses = 6;  //normal
		else 
			guesses = 4;	//hard
		
		
		
		
		Random rand  = new Random();
		
		wordle_words = this.readfile();  // reads file
		randomNum = rand.nextInt(0,wordle_words.size());//creates a random number so i can get the word for the wordle 	
	
		this.play();
	

		
		
	}

public static ArrayList<String> readfile()  {	//takes in file and sorts it into an array
	
	ArrayList<String> word_list = new ArrayList<>();
	FileReader file;
	try {
		file = new FileReader("wordle_words.txt");
		Scanner read = new Scanner(file);
	
	
	while(read.hasNext()) {  //while there is another line the array fills up
		String line = read.nextLine();
		line = line.toLowerCase();
		word_list.add(line); //assign words to specific spots in arraylist
	
	
	}}
	
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		
	return word_list;// returns the filled array 
}

public void play() { //starts the game
	Scanner scan = new Scanner(System.in);
		
	while (user_guess.equalsIgnoreCase(wordle_words.get(randomNum))!= true ) { // while the answer doesnt equal the users input
		if ( guesses > 0) {
				System.out.println("Enter your guess");
					user_guess = scan.next();
					guesses--;
					realguesses++;
			 while (user_guess.length()!= 5) {//while the length of the user input isnt 5
				 System.out.println("Invalid input...go again");
				 	user_guess=scan.next();	}		
			 
			 	System.out.println(this.checkword(user_guess));		//activates method to check word
			 	if(user_guess.equals(wordle_words.get(randomNum))!= true)
			 	System.out.println("You have "+ guesses+ " guesses left!");
		}
		else {
			break;
		}
	}
		if(user_guess.equals(wordle_words.get(randomNum))) {			// asks if guess is equal to answer to determine winner
	System.out.println("You have won! That took "+ realguesses + " guesses!");}
		else	
			System.out.println("You have ran out of guesses, the word was "+ wordle_words.get(randomNum));
} 

public String checkword(String input_word) { // checks word with the answer
	String result = "";
	input_word = input_word.toLowerCase();
	
for ( int i = 0 ; i < 5; i++) {
	if (wordle_words.get(randomNum).indexOf(input_word.charAt(i))==i) {	//checks if they are the same letter in same spot
		result += " ✅️ ";}
		else if (wordle_words.get(randomNum).indexOf(input_word.charAt(i))!= -1){	// checks if there is a letter in the answer
			result += (" 🟨 ");}
		else 
			result +=(" ❌ ");
			
		}
	return result;		//returns the string of user input inaccuracies
}
	}

