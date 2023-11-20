package hangman;

import javax.swing.JOptionPane;
import hangman.Database;

public class HangmanGame extends JOptionPane {
	
	
	private static String word;
	private static char[] wordGuess;
	private static char[] guessed;
	private static int lives = 7;
	private static final String intro = "Welcome to Hangman. Created by"
			+ " Aaron Chen.\n"
			+ "Please choose how many letters you want in your word. (4-5)";
	private static int numLetters;
	
	
	
	
	public static void main(String args[]) {
		
		initiateGame();
		word = getRandomWord(numLetters);
		sendMsg(word);
		guessed = new char[numLetters + 7];
		
		boolean finished = false;
		while(lives > 0 && !finished) {
			char a = makeGuess();
			if(checkGuess(a)) {
				sendMsg("Congrats! " + a + " was a letter in the word");
				finished = checkFinished();
			} else {
				sendMsg("Sorry! " + a + " was not a letter in the word.");
				lives--;
			}
		}
		
		if (lives == 0) {
			sendMsg("You lost. The word was: " + word);
		} else if (finished) {
			sendMsg("Congrats you won!\nThe word was: "
					+ word + "\nYou had " + lives + " lives left");
		}
		
		
	}
	
	private static boolean checkFinished() {
		boolean finished = true;
		for (int i = 0; i < wordGuess.length; i++) {
			if (wordGuess[i] == '_') {
				finished = false;
			}
		}
		return finished;
	}
	
	private static boolean checkGuess(char guessLetter) {
		boolean found = false;
		for (int i = 0; i < word.length(); i++) {
			if (guessLetter == word.charAt(i)) {
				wordGuess[i] = word.charAt(i);
				found = true;
			}
		}
		
		return found;
	}
	
	private static char makeGuess() {
		char temp = 'a';
		String s = "Time to guess the word! Please enter"
				+ "a letter.\n Lives Left: " + lives + "\n" 
				+ makeGuessString(wordGuess) + "\n"
				+ "Already guessed: " + makeGuessString(guessed);
		try {
			temp = promptMsg(s).charAt(0);
			if (!Character.isLetter(temp)) {
				throw new IllegalArgumentException();
			}
			int i = 0;
			while(Character.isLetter(guessed[i])) {
				i++;
			}
			guessed[i] = temp;
		} catch (IllegalArgumentException e) {
			sendMsg("Invalid input, try again.");
			makeGuess();
		} catch (StringIndexOutOfBoundsException e) {
			sendMsg("You cannot input an empty string, try again.");
			makeGuess();
		} catch (NullPointerException e) {
			sendMsg("You cannot exit this program until you finish.");
			makeGuess();
		}
		return temp;
	}
	
	private static String makeGuessString(char[] guess) {
		String s = "";
		for (int i = 0; i < guess.length; i++) {
			s += guess[i] + " ";
		}
		return s;
	}
	
	private static String getRandomWord(int letters) {
		wordGuess = new char[letters];
		for (int i = 0; i < letters; i++) {
			wordGuess[i] = '_';
		}
		return Database.getWord(numLetters);
	}
	
	private static String promptMsg(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	private static void sendMsg(String msg) {
		JOptionPane.showMessageDialog(null,  msg);
	}
	
	private static void initiateGame() {
		try {
			numLetters = Integer.parseInt(promptMsg(intro));
			if (numLetters <= 3 || numLetters >= 6) {
				throw new IllegalArgumentException();
			}
		} catch (NumberFormatException e) {
			sendMsg("You must enter a number.");
			initiateGame();
		} catch (IllegalArgumentException e) {
			String s = "Number of letters has to be between 4 and 5. ";
			s += "Please try again";
			sendMsg(s);
			initiateGame();
		}
	}
	
}