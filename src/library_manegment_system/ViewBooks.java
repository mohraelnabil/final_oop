package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewBooks implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        try {
            File file = new File("D:\\Library\\Data\\Books");  // Replace with the actual path to your file
            Scanner scanner = new Scanner(file);

            System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\tQty\tPrice\tBrw cps");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] bookData = line.split("\t");

                if (bookData.length >= 7) {
                    String name = bookData[0];
                    String author = bookData[1];
                    String publisher = bookData[2];
                    String cla = bookData[3];
                    int qty = Integer.parseInt(bookData[4]);
                    double price = Double.parseDouble(bookData[5]);
                    int brwCps = Integer.parseInt(bookData[6]);

                    System.out.println(name + "\t\t" + author + "\t\t" + publisher + "\t\t" +
                            cla + "\t" + qty + "\t" + price + "\t" + brwCps);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println();
        user.menu(database, user);
    }
}
