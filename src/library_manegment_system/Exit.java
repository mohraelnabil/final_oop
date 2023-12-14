package library;

import java.util.Scanner;

public class Exit implements IOOperation{
	@Override
	public void oper(Database database, User user) {
		System.out.println("\nAre you sure that you want to exit?\n"
				+"1. Yes\n2. Main Menu");
				Scanner s = new Scanner(System.in);
				int i = s.nextInt();
				if (i==1) {
					System.out.println("Come again soon!");
				}
				else {
					user.menu(database, user);
				}
			}
	}
