import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Character;

public class MorseCodeConvert {
	private ArrayList <MorseCode> listCodes = new ArrayList <MorseCode>();
	
	public MorseCodeConvert(String morseCode){ //Constructor
		File file = new File(morseCode);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (line.trim().isEmpty()) {
                	//System.out.printf("%s%n", "Skipping Empty Line");
                	continue; // skip blank lines.
                }
                else if(parts.length != 2) {
                	//System.out.println(parts.length);
                	System.out.printf("Skipping line: %s%n", line);
                	continue;
                }
                String convertToASCII = parts[0];
                char ascii = convertToASCII.charAt(0);
                String code = parts[1];
                MorseCode test = new MorseCode(ascii,code);
                listCodes.add(test); //Adds object of test into listCodes of type MorseCode
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
        	System.err.printf("Invalid file name: %s%n", file);
        }
    }
	public void printMorseCodeList() {
		for(int i = 0; i < listCodes.size(); i++) {
			MorseCode g = listCodes.get(i);
			System.out.printf("(\"%c\" , \"%s\")%n", g.getCh(),g.getCode());
		}
	}
	public void convertString(String string) {
		try {
			//System.out.println(string.length());
			for(int i = 0; i < string.length(); i++) {
				char stringToChar = Character.toUpperCase(string.charAt(i));
				//System.out.println(stringToChar);
				if(stringToChar == ' ') {
					continue;
				}
				for(int j = 0; j < listCodes.size(); j++) {
					MorseCode asciiTable = listCodes.get(j);
					if(asciiTable.getCh() == stringToChar) {
						System.out.printf("%s ",asciiTable.getCode());
					}
				}
			}
			System.out.println();
		}
		catch(NullPointerException ex) {
			System.err.println("Hey");
		}
			
	}
	public void convertFile(String file) {
		File fileConvert = new File(file);
        try {
            Scanner scanner = new Scanner(fileConvert);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                	continue; // skip blank lines.
                }
                for(int i = 0; i < line.length(); i++) {
                	char stringToChar = Character.toUpperCase(line.charAt(i));
                	for(int j = 0; j < listCodes.size(); j++) {
                		MorseCode asciiTable = listCodes.get(j);
                		if(stringToChar == asciiTable.getCh()) {
    						System.out.printf("%s ",asciiTable.getCode());
    					}
                //		System.out.print("?"); //Morse Code if character is not in ASCII table
                	}
                }
                System.out.println();
            }
            scanner.close();
            System.out.println();
        } 
        catch (FileNotFoundException e) {
        	System.err.printf("Invalid file name: %s%n", file);
        }
	}
}
