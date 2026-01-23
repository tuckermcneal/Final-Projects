import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;
public class Wordle {

	private int guesses = 0;
	private String[] wordlewords = new String[60];
	private int randomNum;
	private String g="";
	private String uGuess = "";
	private int realguesses = 0;
	public Wordle(int a) {

		///Decide what mode game is in
		if(a==1) 
			guesses = 8; //easy
		else if(a==2)
				guesses = 6;  //normal
		else 
			guesses = 4;	//hard
		
		Random rand  = new Random();
		randomNum = rand.nextInt(0,60);//creates a random number so i can get the word for the wordle 	
		wordlewords = this.readfile();  // reads file
		wordlewords[randomNum]= wordlewords[randomNum].toLowerCase(); // sets the answer to all lowercase
		this.play();
		
	}

public static String [] readfile()  {	//takes in file and sorts it into an array
	
	String[] words = new String[60];  
	FileReader file;
	try {
		file = new FileReader("wordle_words.txt");
		Scanner read = new Scanner(file);
	
	int i = 0;
	while(read.hasNext()) {  //while there is another line the array fills up
		
		String line = read.nextLine();
		words[i]=line;//assign words to specific spots in array	
	i++;
	
	}}
	
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		
	return words; // returns the filled array 
}

public void play() { //starts the game
	Scanner scan = new Scanner(System.in);
		
	while (g.equalsIgnoreCase(wordlewords[randomNum])!= true ) { // while the answer doesnt equal the users input
		if ( guesses > 0) {
				System.out.println("Enter your guess");
					g = scan.next();
					guesses--;
					realguesses++;
			 while (g.length()!= 5) {//while the length of the user input isnt 5
				 System.out.println("Invalid input...go again");
				 	g=scan.next();	}		
			 
			 	System.out.println(this.checkword(g));		//activates method to check word
			 	System.out.println("You have "+ guesses+ " guesses left!");
		}
		else 
			g= wordlewords[randomNum];
	}
		if(uGuess.equals(wordlewords[randomNum])) {			// asks if guess is equal to answer to determine winner
	System.out.println("You have won! That took "+ realguesses + " guesses!");}
		else	
			System.out.println("You have ran out of guesses, the word was "+ wordlewords[randomNum]);
} 

public String checkword(String w) { // checks word with the answer
	String result = "";
w = w.toLowerCase();
	uGuess=w;
for ( int i = 0 ; i < 5; i++) {
	if (wordlewords[randomNum].indexOf(w.charAt(i))==i) {	//checks if they are the same letter in same spot
		result += " ✅ ";}
		else if (wordlewords[randomNum].indexOf(w.charAt(i))!= -1){	// checks if there is a letter in the answer
			result += (" 🟨 ");}
		else 
			result +=(" ❌ ");
			
		}
	return result;		//returns the string of user input inaccuracies
}
	}

