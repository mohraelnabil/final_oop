package library_manegment_system;

import java.io.File;
import java.util.ArrayList;

public class Database {

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<Book> Books = new ArrayList<Book>();
	private ArrayList<String> booknames = new ArrayList<String>();
	
	private File usersfile = new File(Main.class.getClassLoader().getResource("Users").getFile());
	private File Booksfile = new File(Main.class.getClassLoader().getResource("Books").getFile());
	
	public Database() {
		if (!usersfile.exists()) {
			usersfile.mkdirs();
		}
		if (!Booksfile.exists()) {
			Booksfile.mkdirs();
		}
	} 
	
	public void AddUser(User s) {
		users.add(s);
		usernames.add(s.getName());
	}

// take data from user 
	
	public int login(String phonenumber , String email) {
		int n = -1 ;
		for (User s : users) {
			if (s.getphonenumber().matches(phonenumber) && s.getEmail().matches(email)) {
				n = users.indexOf(s) ; // method returns the position of the first occurrence of specified character
				break ;
			}
		}
		return n ;
	}
	
	public User getUser(int n) {
		return users.get(n);
	}
	public void AddBook(Book book) {
		Books.add(book);
		booknames.add(book.getName());
		
	}
}


