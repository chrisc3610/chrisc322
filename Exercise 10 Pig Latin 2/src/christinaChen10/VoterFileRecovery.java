package christinaChen10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
*Formats a text file.
*
*This class splits the text at the pipelines "|" and makes the first line(the labels) uppercase.
*<p>
*ADS PS10: Pig Latin Part 2
*1/14/2019
*
*
*@author Christina Chen
*/
public class VoterFileRecovery {
	/*
		1		First Name - 16 columns, left justified
		2		Last Name - 16 columns, left justified
		4		City - 22 columns, left justified
		7		Phone - 16 columns, left justified
		8		Last ID - 19 columns, right justified
		9		How many of the last 8 elections did the voter participate in?
	*/		
	
	/**
	* Formats a text file.
	* The generatePhoneList method splits the text at the pipelines "|" and makes the first line(the labels) uppercase.
	*
	* @author Christina Chen
	* @param file is the input text file that the method will be working with
	* @return the output is returned in the output file
	* @throws IOException
	*/
	public static void generatePhoneList(String file) throws IOException {
		try {
				//inputs file
				Scanner reader = new Scanner(new File("Recovered+Voterfile+Pipe+Delimited.txt"));
				PrintWriter weeFile = new PrintWriter("264531_phonelist.txt");
        
				int count = 0;
				while(reader.hasNextLine()){
					count++;
					String s = reader.nextLine();
					s=s.replace("\"", "");
					//process header
					if (count == 1) {
						s=s.toUpperCase();
						String[] ar = s.split("\\|");
						weeFile.printf("%-16s%-16s%-22s%-16s%19s%15s%n", ar[1],ar[2],ar[4],ar[7],ar[8], "VotingHistory".toUpperCase() );
					} else {
						int i;
						int vote8=0;
						String v8;
						
						//process body
						String[] ar = s.split("\\|");
						if (ar.length <10) {
							System.out.println ("Input error, skip line : " + s );
							continue;
						}
						
						//counts the amount of votes for each record
						if (ar.length >=17 ){
							for ( i=9 ; i<16; i++) {
								vote8 += Integer.parseInt(ar[i]);
							}
						}
						
						v8=Integer.toString(vote8) + "/8";
						weeFile.printf("%-16s%-16s%-22s%-16s%19s%15s%n", ar[1],ar[2],ar[4],ar[7],ar[8], v8 );
					}	
				}
				weeFile.close();
				reader.close();

		} catch(IOException e) {
			System.out.println("File Reading Error, Please Try Again: ");
		}  	
	}
	
	/**
	* Executes the prior method.
	* The main method uses the given file as the parameter for the first method..
	*
	* @author Christina Chen
	* @return the output is returned in the output file
	* @throws IOException
	*/
	public static void main(String args[]) throws IOException{
		String input ="Recovered+Voterfile+Pipe+Delimited.txt";
		generatePhoneList(input);	 

	}
} //end class
