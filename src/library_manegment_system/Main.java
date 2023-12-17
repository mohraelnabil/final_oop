package library;

import java.util.Scanner;

public class Main {

		static Scanner s ;
		static Database database ;

	public static void main(String[] args) {
		
		database = new Database();
		System.out.println("Welcome to library Manegment System!");

		
// menu 


		int num ;
		// do {
			System.out.println("0. Exit\n" + "1. Login\n2. New User ");
			s = new Scanner(System.in);
			num = s.nextInt();
			
			switch (num) {
			case 0 : System.out.println("Come aqain soon!");break ;
			case 1 : login() ; break;
			case 2 : newuser(); break; 
		 }
		// }while (num != 0);
		
	}

// login 
	

	private static void login() {
	    System.out.println("Enter phone number: ");
	    String phoneNumber = s.next();
	    System.out.println("Enter email: ");
	    String email = s.next();
	    
	    int userId = database.login(phoneNumber, email);
	    if (userId != -1) {
	        User user = database.getUser(userId);
	        
	        // Check if the user is an admin
	        if (user instanceof Admin) {
	            System.out.println("Welcome " + user.getName() + " (Admin)!");
	            user.menu(database, user);
	        } else {
	            System.out.println("Welcome " + user.getName() + " (Normal User)!");
	            user.menu(database, user);
	        }
	    } else {
	        System.out.println("User doesn't exist!");
	    }
	}

// newuser 
	
	private static void newuser() {
		System.out.println("Enter name: ");
		String name = s.next();
		System.out.println("Enter phone number: ");
		String phonenumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		System.out.println("1. Admin\n2. Normal User");
		int n2 = s.nextInt() ;
		
		User user;

		switch (n2) {
		    case 1:
		        user = new Admin(name, email, phonenumber);
		        break;
		    default:
		        user = new NormalUser(name, email, phonenumber);
		        break;
		}

		database.AddUser(user);
		user.menu(database, user);
	}
	

}
