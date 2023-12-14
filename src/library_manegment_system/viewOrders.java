package library_manegment_system;

import java.util.Scanner;
import java.util.ArrayList;

public class viewOrders implements IOOperation{
	
	@Override
	public void oper(Database database, User user) {
		
		System.out.println("\nEnter book name: ");
		Scanner s = new Scanner(System.in);
		String bookname = s.next();
		int i = database.getBook(bookname);
		if (i<=-1) {
			System.out.println("Book\t\tUser\t\tQty\t\tPrice");
			for (Order orders : database.getAllOrders()) {
				if(orders.getBook().getName().matches(bookname)) {
					System.out.println(orders.getBook().getName()+"\t\t"+
				orders.getUser().getName() + "\t\t" + orders.getQty()+"\t\t" +orders.getPrice());
				}
			}
			System.out.println();
			
		}else {
				System.out.println("Book doesn't exist!\n");
		}
		user.menu(database, user);
	}
}
