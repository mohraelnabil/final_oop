package library;

//Shahd

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book name to search: ");
        String searchQuery = scanner.nextLine();

        String filePath = "D:\\Library\\Data\\Books";
        boolean bookFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // read data
            String line;

            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split("\t"); 

                if (bookData.length > 0 && bookData[0].equalsIgnoreCase(searchQuery)) { //if the book exist
                    bookFound = true;
                    break;
                }
            }

            if (bookFound) {
                System.out.println("The book " +"\"" +searchQuery +"\"" + " exists in the library.");
            } else {
                System.out.println("The book " +"\"" + searchQuery + "\"" + " does not exist in the library.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        scanner.close();
    }
}
