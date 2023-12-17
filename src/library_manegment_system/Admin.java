package library;

// Farida

import java.util.Scanner;

public class Admin extends User {  // inhirite from User 
	
	public Admin(String name) {
		super(name);
	
	this.operations = new IOOperation[] {  // Admin options 
			new ViewBooks(),
			new AddBooks(),
			new DeleteBooks(),
			new Search(),
			new Exit()
	};
	}
	
	public Admin(String name , String email , String phonenumber) {
		super(name , email , phonenumber);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new AddBooks(),
				new DeleteBooks(),
				new Search(),
				new Exit()
		};
	}
	
// menu of Admin option 
	
	@Override 
	public void menu(Database database, User user) {
		System.out.println ("1. view Books");
		System.out.println ("2. Add Books");
		System.out.println ("3. Delete Books");
		System.out.println ("4. Search");
		System.out.println ("5. Exit");
		
		// scan the options 
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		this.operations[n-1].oper(database, user);
		s.close();
	}
	
	public String toString () {
		return name + "<N/>" + email + "<N/>" + phonenumber + "<N/>" + "Admin" ;
	}

}
