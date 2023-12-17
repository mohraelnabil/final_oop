package library;

// Farida

import java.util.Scanner;

public class NormalUser extends User { // inherite from user

		public NormalUser(String name) {
			super(name);
			this.operations = new IOOperation[] {
					new ViewBooks(),
					new Search(),
					new Exit()
					
			};
		}
		
		public NormalUser(String name , String email , String phonenumber) {
			super(name , email , phonenumber);
			this.operations = new IOOperation[] {
					new ViewBooks(),
					new Search(),
					new Exit()
					
			};
		}
		
		@Override 
		public void menu(Database database, User user) {
			System.out.println ("1. view Books");
			System.out.println ("2. Search");
			System.out.println ("3. Exit");
			
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			this.operations[n-1].oper(database,user);
			s.close();
		}
		
		public String toString () {
			return name + "<N/>" + email + "<N/>" + phonenumber + "<N/>" + "Normal" ;
		}

	}
