/*
import java.io.File;
import java.lang.String;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadFile {
    public static void main(String[] args) {
        // Create an instance of File for data.txt file.
        File file = new File("C:/Users/JRodr/Java/Workspace/MorseCode/src/Codes.txt");
        try {
            // Create a new Scanner object which will read the data
            // from the file passed in. To check if there are more 
            // line to read from it we check by calling the 
            // scanner.hasNextLine() method. We then read line one 
            // by one till all lines is read.
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (line.trim().isEmpty()) {
                	System.out.printf("%s%n%n%n", "Skipping Empty Line");
                	continue; // skip blank lines.
                }
                else if(parts.length != 2) {
                	System.out.printf("Skipping Line of Length: %d with text: %s%n",parts.length, line);
                	continue;
                }
                
                for(int i = 0; i < line.length(); i++) {
                }
                try {
                	
                	System.out.println(parts[0]);
                	//System.out.println(line);
                }
                catch(ArrayIndexOutOfBoundsException ex) {
                    System.err.println("An exception was thrown");
                	//continue;

                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
        	System.err.printf("Invalid file name: %s%n", file);
        }
    }
}
*/