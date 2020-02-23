package christinaChen10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
*Translates English into Pig Latin
*
*This class determines whether characters in a word are vowels or not, then uses that to find the first consonant cluster in a word, and finally uses that to translate English into Pig Latin.
*<p>
*ADS PS10: Pig Latin
*1/14/2019
*
*
*@author Christina Chen
*/
public class PigLatin {
	static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
	//String[] arS = "s".split("");
	
	/**
    * Checks if character is vowel.
    * isVowel first checks if the character is one of the basic vowels(a, e, i, o, u), then checks if it's "y", then depending on the different placement conditions of the "y", determines if it is a vowel or not.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @param i is the index of the character of the string the method checks
	* @return true if the character is a vowel and false if it is a consonant
	*/
	//isVowel
	public static boolean isVowel(String s, int i) {
		boolean wee = false;
		
		char yeet = s.charAt(i);
		if(yeet == 'a' || yeet == 'e' || yeet == 'i'|| yeet == 'o' || yeet == 'u') {
			wee = true;
		}else if(yeet == 'y') {
			if(i == 0) {
				if(isVowel(s, i+1)) {
					wee = false;
				}else if(s.charAt(i+1) == 'v') {
					wee = true;
				}
			}else if(i != 0 && i != s.length()-1 && !isVowel(s, i-1) && !isVowel(s, i+1)) {
				wee = true;
			}else if(i != 0 && !isVowel(s, i-1)) {
				wee = true;
			}else if(i != s.length()-1 && !isVowel(s, i+1)) {
				wee = true;
			}
		}

		return wee;
	} //end method
	
	/**
	* Checks if character is silent.
	* isVowel first checks if the character is a silent letter.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @param i is the index of the character of the string the method checks
	* @return true if the character is silent and false if it isn't silent
	*/
	//isSilent
	public static boolean isSilent(String s, int i) {
		boolean wee = false;
		
		if(s.charAt(0) == 'w' && s.charAt(1) == 'r') {
			wee = true;
		}else if(s.charAt(0) == 'p' && s.charAt(1) == 's') {
			wee = true;
		}else if(s.charAt(0) == 'p' && s.charAt(1) == 'g') {
			wee = true;
		}else if(s.charAt(0) == 'g' && s.charAt(1) == 'n') {
			wee = true;
		}else if(s.charAt(0) == 'w' && s.charAt(1) == 'h') {
			wee = true;
		}else if(s.charAt(0) == 'k' && s.charAt(1) == 'n') {
			wee = true;
		}else if(s.charAt(0) == 'c' && (s.charAt(1) == 'e' || s.charAt(1) == 'i' || s.charAt(1) == 'y')) {
			wee = true;
		}
		
		return wee;
	}
	
	/**
	* Finds index of first consonant.
	* startOfFirstConsonantCluster uses the isVowel method to check for each character starting from the beginning of the word until it hits a consonant.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @return the index of the very first consonant
	*/
	//startOfFirstConsonantCluster
	public static int startOfFirstConsonantCluster(String s) {
		int c = 0;
		char[] arC = s.toCharArray();
		
		if(s.length() == 0 ) {
			return -1;
		}
		
		for(int i = 0; i<arC.length; i++) {
			if(!isVowel(s, i) && Character.isLetter(arC[i])){
				//^vowel when cyc,cy,yc
				c = i;
				return c;
			}else if( isVowel(s, i)) {
				c = -1;
			}
		}
		return c;
	} //end method

	/**
	* Finds index of last consonant in cluster.
	* endOfFirstConsonantCluster uses the isVowel method and startOfFirstConsonantCluster to measure how long the cluster is, ending when it hits a vowel again.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @return the last index of the first consonant cluster
	*/
	//endOfFirstConsonantCluster
	public static int endOfFirstConsonantCluster(String s) {	
		int c = startOfFirstConsonantCluster(s);		
		if(s.length() == 0  ||  c == -1) {
			return -1;
		}
	
		int c2 = 0;	
		char[] arC = s.toCharArray();
		
		//stop when gets to a vowel
		for(int i = c+1; i<arC.length; i++) {
			if(isVowel(s, i)){
				c2 = i-1;
				break;
			}
			else {
				c2=i;
			}
		}
		
		return c2;
	} //end method

	/**
	* Translates English to Pig Latin.
	* wordToPigLatin uses the startOfFirstConsonantCluster and endOfFirstConsonantCluster methods to determine the first consonant cluster of a word and moves it to the end of the word, adding a corresponding ending to the end.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @return the English word translated into Pig Latin
	*/
	//wordToPigLatin
	public static String wordToPigLatin(String s) {		
		s.trim();
		if(s.length() == 0 ) {
			return "-1";
		}
		
		int cS = startOfFirstConsonantCluster(s);
		int cE = endOfFirstConsonantCluster(s);
		String sN;

		//String sN = s.substring(cE+1, s.length());

		if (isVowel(s,0) || isSilent(s,0)) {
			sN = s+"way";
		}else {
			sN= s.substring(cE+1,s.length()) + s.substring(cS,cE+1) + "ay";
		}
		
		System.out.print(sN);
		return sN;	
	}
	
	/**
	* Finds start of ending punctuation sequence.
	* findStartOfEndingPuncSeq checks to see if the last character in the string is a punctuation mark and finds the index of it if so.
	*
	* @author Christina Chen
	* @param s is the String that the method is checking
	* @return  the index where the ending punctuation sequence begins, or it returns -1 if the String does not end with a punctuation sequence
	*/
	//findStartOfEndingPuncSeq
	public static int findStartOfEndingPuncSeq(String s) {
		int c = 0;
		
		if(s.length() == 0 ) {
			return -1;
		}
		
		for(int i = 0; i< s.length(); i++) {
			if(isVowel(s, i)) {
				c = -1;
			}
		}	
		
		if(Character.isLetterOrDigit(s.charAt(s.length()-1))) {
			c = -1;
		}else {
			for(int i = 0 ; i<s.length(); i++) {
				if(!Character.isLetterOrDigit(s.charAt(i))/*check the index, if i = letter/digit*/) {
					c = i;
				}
			}
		}

		return c;
	}
	
	/**
	* Modifies a .txt file.
	* fileToPigLatin replaces the endings ".txt" with "_PL.txt" and splits the text into separate strings to be translated into Pig Latin.
	*
	* @author Christina Chen
	* @param file is the String(file) that the method is checking
	* @return the new file with the translated strings
	* @throws IOException
	*/
	//fileToPigLatin
	public static void fileToPigLatin(String file) throws IOException {
		Scanner reader = new Scanner(new File(file));
		File fFile = new File(file.replaceAll(".txt", "_PL.txt"));
		PrintWriter weeFile = new PrintWriter(fFile);
		
		while(reader.hasNextLine()){
			String s = reader.next();
			s.trim();
			if(s.length() == 0 ) {
				continue;
			}
			
			String ar[]= s.split(" ");
			for(String word: ar) {
				String fWord;
				
				if(word.toUpperCase() == word.toLowerCase()) {
					fWord = word;
				}else if(findStartOfEndingPuncSeq(word) == -1){
					fWord = wordToPigLatin(word);
				}else {
					String wPunc = word.substring(findStartOfEndingPuncSeq(word), word.length()-1);
					String wT = wordToPigLatin(word.substring(0, findStartOfEndingPuncSeq(word)));
					fWord = wPunc + wT;
				}
				weeFile.print(fWord + " ");
			}
		}
		weeFile.close();
	}
}
