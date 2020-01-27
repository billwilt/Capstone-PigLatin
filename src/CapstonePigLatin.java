import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author Bill Wilt
 */

public class CapstonePigLatin {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean wantToContinue;
		
		do {
			int y = 0;
			System.out.print("Please enter the word you'd like to convert to Pig Latin: ");
			String userInput = keyboard.next();
			
			boolean userInputUP = userInput.toUpperCase().equals(userInput);
			boolean userInputLC = userInput.toLowerCase().equals(userInput);
			//System.out.println(userInputUP + " uppercase");
			//System.out.println(userInputLC + " lowercase");
			
				Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(userInput);
				boolean b = m.find();
				if (b) {
					System.out.println("You used a special character in your word.");
					System.out.println(userInput);
					System.out.println();
				} else {
				
					String userInputLowerCase = (userInput.toLowerCase());
					char c = userInputLowerCase.charAt(y);
			
					if (isVowel(c)) {
						if (userInputUP) {
							//If vowel UPPERCASE
							System.out.println("Your word converted to Pig Latin is: " + userInputLowerCase.toUpperCase() + "WAY");
							System.out.println();
						} else if (userInputLC) {
							//If vowel lowercase
							System.out.println("Your word converted to Pig Latin is: " + userInputLowerCase.toLowerCase() + "way");
							System.out.println();
						} else 
							//If vowel Titlecase
							System.out.println("Your word converted to Pig Latin is: " + (toTitleCase(userInputLowerCase)) + "way");
						System.out.println();
					} else {
						int wordLength = (userInput.length());
				
						do {
							y = y + 1;
							c = userInputLowerCase.charAt(y);
					
						} while (!isVowel(c));
						//If consonant UPPERCASE 	
						if (userInputUP) {
							System.out.println((userInputLowerCase.substring(y, wordLength).toUpperCase()) + (userInputLowerCase.substring(0, y).toUpperCase()) + "AY");
							System.out.println();
						} else if (userInputLC) {
							//IF consonant lowercase
							System.out.println((userInputLowerCase.substring(y, wordLength).toLowerCase()) + userInputLowerCase.substring(0, y) + "ay");
							System.out.println();
						} else 
							//If constant Titlecase
							System.out.println(toTitleCase(userInputLowerCase.substring(y, wordLength)) + userInputLowerCase.substring(0, y) + "ay");
							System.out.println(); 				
					}
					}
				System.out.println("Would you like to convert another word to Pig Latin? (y/n)");
				wantToContinue = keyboard.next().startsWith("y");
					} while (wantToContinue);
				System.out.println("Thanks for playing!");
		
		keyboard.close();
	}

	public static boolean isVowel(char c) {
		  return "AEIOUaeiou".indexOf(c) != -1;
		}
	
	public static String toTitleCase(String userInputLowerCase) {
	    StringBuilder titleCase = new StringBuilder(userInputLowerCase.length());
	    boolean nextTitleCase = true;

	    for (char c : userInputLowerCase.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        }

	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}
	
}
