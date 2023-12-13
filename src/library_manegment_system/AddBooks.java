package library;

import java.util.Scanner;

public class AddBooks implements IOOperation{
	@Override
	public void oper(Database database, User user) {
		
		Scanner s = new Scanner (System.in);
		Book book = new Book();
		System.out.println("Enter book name: ");
		book.setName(s.next());
		System.out.println("Enter book Author: ");
		book.setAuthor(s.next());
		System.out.println("Enter book Publisher: ");
		book.setPublisher(s.next());
		System.out.println("Enter book Collection Address: ");
		book.setAdress(s.next());
		System.out.println("Enter book Qty: ");
		book.setQty(s.nextInt());
		System.out.println("Enter book Price: ");
		book.setPrice(s.nextDouble());
		System.out.println("Enter Borrowing coppies: ");
		book.setBrwcopies(s.nextInt());
		s.close();
		database.AddBook(book);
		System.out.println("Book added successfully!");
		
	}


}
