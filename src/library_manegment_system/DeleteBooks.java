package library;

import java.util.Scanner;

public class DeleteBooks implements IOOperation{
	@Override
	public void oper(Database database, User user) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter book name: ");
		String bookname = s.next();

String filePath = "D:\\Library\\Data\\Books";
		
		  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // read data
            String line;
		
		int i=database.getBook(bookname);
		if(i>-1) {
			database.deleteBook(i);
			System.out.println("Book deleted successfully!\n");
		}
		else {
			System.out.println("Book doesn't exist!\n");
		}
		

		user.menu(database,user);
	}

}
