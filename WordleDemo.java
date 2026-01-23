import java.util.Scanner;

public class WordleDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Wordle! ");
		System.out.println("Would you like to play on easy, normal or hard mode?");
		String ans = scan.next();
		ans	= ans.toLowerCase();
		if (ans.equals("easy")) {	//select gamemode and starts game
			Wordle word = new Wordle (1);}
			else if (ans.equals( "normal")) {
			Wordle word = new Wordle(2);}
			else { 
				Wordle word = new Wordle(3);}
		
	}

}
