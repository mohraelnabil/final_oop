package library_manegment_system;

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
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	private File usersfile = new File("D:\\Library Management System\\Data\\Users");
	private File Booksfile = new File("D:\\Library Management System\\Data\\Books");
	private File ordersfile = new File("D:\\Library Management System\\Data\\orders");
	private File folder = new File("D:\\Library Management System\\Data");
	
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
		if (!ordersfile.exists()) {
			try {
				ordersfile.createNewFile();
			}
			catch(Exception e){}

		}
		getUsers();
		getBooks();
		getOrders();
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
		book.setBrwcopies(Integer.parseInt(a[6]));
		return book ;
	}
	
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
	public void deleteAllData() {
		if (usersfile.exists()) {
			try {
				usersfile.delete();
			}catch (Exception e) {}
	}
		if(!Booksfile.exists()) {
			try {
				Booksfile.delete();
			}catch (Exception e) {}
		}
		if (!ordersfile.exists()) {
			try {
				ordersfile.delete();
			}
			catch(Exception e){}

		}
	  }
	public void addOrder(Order order , Book book , int bookindex) {
		orders.add(order);
		Books.set(bookindex , book);
		saveOrders();
	}
	private void saveOrders () {
		String text1 = "";
		for(Order order : orders) {
			text1 = text1 + order.toString2() + "<NewOrder/>" ; 
		}
		try {
			PrintWriter pw = new PrintWriter (ordersfile);
			pw.print(text1);
			pw.close();
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	private void getOrders() {
		String text1 = "" ;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader (ordersfile));
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
			String[] a1 = text1.split("<NewOrder/>");
			for (String s : a1) {
				Order order = parseOrder(s);
				orders.add(order);
			}
		}
	}
	private User getUserByName(String name) {
		User u = new NormalUser("");
		for (User user : users) {
			if (user.getName().matches(name)) {
				u = user;
				break;
			}
		}
		return u;
	}
	
	private Order parseOrder(String s) {
	     String[] a = s.split("<\n>");
	     Order order = new Order(Books.get(getBook(a[0])), getUserByName(a[1]),
	    		 Double.parseDouble(a[2]), Integer.parseInt(a[3]));
	     return order;
	 }
	public ArrayList<Order> getAllOrders(){
		return orders;
	}
	}
