package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<Book> Books = new ArrayList<Book>();
	private ArrayList<String> booknames = new ArrayList<String>();
	
	private File usersfile = new File("D:\\Library\\Data\\Users");
	private File Booksfile = new File("D:\\Library\\Data\\Books");
	private File folder = new File("D:\\Library\\Data");
	
	public Database() {
		
		if (!folder.exists()) {
			folder.mkdirs();
		}
		if (!usersfile.exists()) {
			try {
				usersfile.createNewFile();
			}
			catch(Exception e){}
		}
		
		if (!Booksfile.exists()) {
			try {
				Booksfile.createNewFile();
			}
			catch(Exception e){}

		}
		getUsers();
	} 
	
	public void AddUser(User s) {
		users.add(s);
		usernames.add(s.getName());
		saveUsers();
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
		saveBooks();
	}
	
	private void getUsers() {
		String text1 = "" ;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader (usersfile));
			String s1 ;
			while ((s1 = br1.readLine())!= null) {
				text1 = text1 + s1 ;
			}
			br1.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1 = text1.split("<NewUser/>");
			for (String s : a1) {
				String[] a2 = s.split("<N/>");
				
				if(a2[3].matches("Admin")) {
					
					User user = new Admin (a2[0], a2[1] , a2[2]);
					users.add(user);
					usernames.add(user.getName());
					
				}
				else {
					
					User user = new NormalUser (a2[0], a2[1] , a2[2]);
					users.add(user);
					usernames.add(user.getName());
					
				}
			}
		}
	}
	
	private void saveUsers() {
		String text1 = "";
		for(User user : users) {
			text1 = text1 + users.toString() + "<NewUser/>" ; 
		}
		try {
			PrintWriter pw = new PrintWriter (usersfile);
			pw.print(text1);
			pw.close();
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void saveBooks () {
		String text1 = "";
		for(Book book : Books) {
			text1 = text1 + book.toString2() + "<NewBook/>" ; 
		}
		try {
			PrintWriter pw = new PrintWriter (Booksfile);
			pw.print(text1);
			pw.close();
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void getBooks() {
		String text1 = "" ;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader (Booksfile));
			String s1 ;
			while ((s1 = br1.readLine())!= null) {
				text1 = text1 + s1 ;
			}
			br1.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1 = text1.split("<NewbBook/>");
			for (String s : a1) {
				Book book = parseBook(s);
				Books.add(book);
				booknames.add(book.getName());
			}
		}
	}
	
	public Book parseBook (String s) {
		String[] a = s.split("<N/>");
		Book book = new Book();
		book.setName(a[0]);
		book.setAuthor(a[1]);
		book.setAdress(a[3]);
		book.setQty(Integer.parseInt(a[4]));
		book.setPrice(Double.parseDouble(a[5]));
		return book ;
	}
	
	//******
	
	public ArrayList<Book> getAllBooks(){
		return Books;
	}
	
	public int getBook(String bookname) {
		
		int i=-1;
		for(Book book : Books) {
			if(book.getName().matches(bookname));
			i=Books.indexOf(book);
		}
		return i;
	  }
	
	public Book getBook(int i) {
		
		return Books.get(i);
	  }
	
		public void deleteBook(int i) {
			Books.remove(i);
			booknames.remove(i);
			saveBooks();
		}
	
	
}
