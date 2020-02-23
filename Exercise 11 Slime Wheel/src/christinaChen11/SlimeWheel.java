package christinaChen11;

import java.lang.NullPointerException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
*Generates slime and lists price.
*
*This program randomly selects different types of ingredients and on a new text file, lists out the prices of the selected materials in receipt form.
*
*ADS PS11: Slime Generator
*Date
*
*
*@author Christina Chen
*/
public class SlimeWheel {
	
	 // instance variables
		static String myGlue;
		static String myActivator;
		static String myTexture;
		static String myTexture1;
		static String myTexture2;
		static String myAddons;
		static String myAddons1;
		static String myAddons2;
		static String[] glueAr;
		static String[] activatorAr;
		static String[] textureAr;
		static String[] addonsAr;

		// default constructor
		public SlimeWheel() {
			this("", "", "", "", "", "", "", "", new String[] {}, new String[] {}, new String[] {}, new String[] {});
		}

		// initialize constructor
		public SlimeWheel(String myGlue, String myActivator, String myTexture, String myTexture1, String myTexture2, String myAddons, String myAddons1, String myAddons2, String[] glueAr, String[] activatorAr, String[] textureAr, String[] addonsAr) {
			this.myGlue = myGlue;
			this.myActivator = myActivator;
			this.myTexture = myTexture;
			this.myTexture1 = myTexture1;
			this.myTexture2 = myTexture2;
			this.myAddons = myAddons;
			this.myAddons1 = myAddons1;
			this.myAddons1 = myAddons1;
			this.glueAr = glueAr;
			this.activatorAr = activatorAr;
			this.textureAr = textureAr;
			this.addonsAr = addonsAr;
		}
		
	//glue
	public String glue(){
		Random spin = new Random();
		String[] glueAr = {"Clear", "White", "Glow-in-the-dark", "Glitter"};
		myGlue = glueAr[spin.nextInt(3)];
		
		return "Step 1 > Glue: " + myGlue+"\n";
	}
	
	//activator
	public String activator(){
		Random spin = new Random();
		String[] activatorAr = {"Borax", "Liquid starch", "Powdered detergent", "Contact lense solution"};
		myActivator = activatorAr[spin.nextInt(3)];
		
		return "Step 2 > Activator: " + myActivator+"\n";
	}
	
	//texture
	public String texture(){
		Random spin = new Random();
		String[] textureAr = {"Lotion", "Foam soap", "Baby oil", "Cornstarch", "Shaving cream"};
		myTexture1 = textureAr[spin.nextInt(4)];
		myTexture2 = textureAr[spin.nextInt(4)];
		
		myTexture = myTexture1 + ", " + myTexture2;
		
		return "Step 3 > Add some texture to the slime.\nTexture: " + myTexture+"\n";
	}
	
	//addons
	public String addons(){
		Scanner reader = new Scanner(System.in);
		Random spin = new Random();
		String[] addonsAr = {"Dye", "Instant snow", "Confetti", "Fishbowl beads", "Floam beads", "Fake plastic snow", "Micro floam", "Glitter", "Sprinkles"};
		myAddons1 = addonsAr[spin.nextInt(8)];
		myAddons2 = addonsAr[spin.nextInt(8)];
		
		if(myAddons1.equals("Dye")) {
			System.out.print("What color would you like? red, blue, green, or yellow?\n");
			String dyecolor = reader.nextLine();
			myAddons1 = dyecolor + " dye";
		}
		
		if(myAddons2.equals("Dye")) {
			System.out.print("What color would you like? Red, blue, green, or yellow?\n");
			String dyecolor = reader.nextLine();
			myAddons2 = dyecolor + " dye";
		}
		
		myAddons = myAddons1 +", "+ myAddons2;
		
		return "Step 4 > Add-ons: " + myAddons;
	}
	
	/**
	* Makes receipt for selected materials.
	* On a new text file, lists out the prices of the selected materials in receipt form
	*
	* @author Christina Chen
	* @return void, the new file
	* @throws IOException
	*/
	//price
	public static void price() throws IOException {
		FileWriter fileWriter = new FileWriter("broke.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    double glueM = 0;
	    double activatorM = 0;
	    double textureM1 = 0;
	    double textureM2 = 0;
	    double addonsM1 = 0;
	    double addonsM2 = 0;
	    double price = 0;
	  
	    //glue
	    if(myGlue.equals("Clear")) {
	    	glueM = 1.76;
	    }else if(myGlue.equals("White")){
	    	glueM = 0.99;
	    }else if(myGlue.equals("Glow-in-the-dark")) {
	    	glueM = 3.97;
	    }else if(myGlue.equals("Glitter")) {
	    	glueM = 2.99;
	    }
	    
	    //activator
	    if(myActivator.equals("Borax")) {
	    	activatorM = 2.97;
	    }else if(myActivator.equals("Liquid starch")) {
	    	activatorM = 11.24;
	    }else if(myActivator.equals("Powdered detergent")) {
	    	activatorM = 23.09;
	    }else if(myActivator.equals("Contact lense solution")) {
	    	activatorM = 11.49;
	    }
	    
	    //texture
	    if(myTexture1.equals("Lotion")) {
	    	textureM1 = 11.49;
	    }else if(myTexture1.equals("Foam soap")) {
	    	textureM1 = 3.99;
	    }else if(myTexture1.equals("Baby oil")) {
	    	textureM1 = 4.92;
	    }else if(myTexture1.equals("Cornstarch")) {
	    	textureM1 = 9.80;
	    }else if(myTexture1.equals("Shaving cream")) {
	    	textureM1 = 3.29;
	    }
	    
	    if(myTexture2.equals("Lotion")) {
	    	textureM2 += 11.49;
	    }else if(myTexture2.equals("Foam soap")) {
	    	textureM2 += 3.99;
	    }else if(myTexture2.equals("Baby oil")) {
	    	textureM2 += 4.92;
	    }else if(myTexture2.equals("Cornstarch")) {
	    	textureM2 += 9.80;
	    }else if(myTexture2.equals("Shaving cream")) {
	    	textureM2 += 3.29;
	    }
	    
	    //addons
	    if(myAddons1.equals("Dye")) {
	    	addonsM1 = 8.99;
	    }else if(myAddons1.equals("Instant snow")) {
	    	addonsM1 = 8.95;
	    }else if(myAddons1.equals("Confetti")) {
	    	addonsM1 = 4.89;
	    }else if(myAddons1.equals("Fishbowl beads")) {
	    	addonsM1 = 10.95;
	    }else if(myAddons1.equals("Floam beads")) {
	    	addonsM1 = 2.85;
	    }else if(myAddons1.equals("Fake plastic snow")) {
	    	addonsM1 = 8.56;
	    }else if(myAddons1.equals("Micro floam")) {
	    	addonsM1 = 3.00;
	    }else if(myAddons1.equals("Glitter")) {
	    	addonsM1 = 4.75;
	    }else if(myAddons1.equals("Sprinkles")) {
	    	addonsM1 = 3.99;
	    }
	    
	    if(myAddons2.equals("Dye")) {
	    	addonsM2 = 8.99;
	    }else if(myAddons2.equals("Instant snow")) {
	    	addonsM2 = 8.95;
	    }else if(myAddons2.equals("Confetti")) {
	    	addonsM2 = 4.89;
	    }else if(myAddons2.equals("Fishbowl beads")) {
	    	addonsM2 = 10.95;
	    }else if(myAddons2.equals("Floam beads")) {
	    	addonsM2 = 2.85;
	    }else if(myAddons2.equals("Fake plastic snow")) {
	    	addonsM2 = 8.56;
	    }else if(myAddons2.equals("Micro floam")) {
	    	addonsM2 = 3.00;
	    }else if(myAddons2.equals("Glitter")) {
	    	addonsM2 = 4.75;
	    }else if(myAddons2.equals("Sprinkles")) {
	    	addonsM2 = 3.99;
	    }
	    
	    price = glueM + activatorM + textureM1 + textureM2 + addonsM1 + addonsM2;
	    
	    printWriter.printf("\nHere is your receipt for this purchase:\n");
	    printWriter.printf("------------------------------------------\n");
	    printWriter.printf("  %-30s$%-2.2f\n", myGlue + " glue", glueM);
	    printWriter.printf("  %-30s$%-2.2f\n", myActivator, activatorM);
	    printWriter.printf("  %-30s$%-2.2f\n", myTexture1, textureM1);
	    printWriter.printf("  %-30s$%-2.2f\n", myTexture2, textureM2);
	    printWriter.printf("  %-30s$%-2.2f\n", myAddons1, addonsM1);
	    printWriter.printf("  %-30s$%-2.2f\n\n", myAddons2, addonsM2);
	    printWriter.printf("  %-30s$%-2.2f\n", "Total", price);
	    printWriter.printf("  --------------------------------------\n\n");
	    printWriter.printf("  Thank your for your money, but please\n  reconsider what you are doing with\n  your life before you buy these materials\n  for slime next time(because honestly,\n  slime can be a real waste of time)!\n\n");
	    printWriter.printf("------------------------------------------");

	    printWriter.close();
	}
	
	
	public static void main(String args[]) throws IOException {
		SlimeWheel slime = new SlimeWheel();
		
		System.out.println(slime.glue());
		System.out.println(slime.activator());
		System.out.println(slime.texture());
		System.out.println(slime.addons());
		
		price();
	}
}
