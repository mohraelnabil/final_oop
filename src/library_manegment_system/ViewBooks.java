package library;

//Hana


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewBooks implements IOOperation{
    public void viewBooks() {
       
    }
	public void oper(Database database, User user) {
		 try {
	            File file = new File("D:\\Library\\Data\\Books"); 
	            Scanner scanner = new Scanner(file);

	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                // Process the line of data
	                System.out.println(line);
	            }

	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found: " + e.getMessage());
	        }
	}
	



}
