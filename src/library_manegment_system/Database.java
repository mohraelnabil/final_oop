package library;

// Hana and Shahd

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {

	// Array list to save UserName and BookName
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<Book> Books = new ArrayList<Book>();
	private ArrayList<String> booknames = new ArrayList<String>();
	
	// Create File By it self 
	private File usersfile = new File("D:\\Library\\Data\\Users");
	private File Booksfile = new File("D:\\Library\\Data\\Books");
	private File folder = new File("D:\\Library\\Data");
	
	public Database() {
		
		// check if the folder dosn't exist , he mkdirs() method is called on the folder object to create the directory
		if (!folder.exists()) {
			folder.mkdirs();
		}
		// create files
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
	
//**************
//User
	
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
		// split is like determine that this is the end of the string (or line of data)
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
	
	
	// to add NewUser in the end to save it correctly
	private void saveUsers() {
	    try {
	        PrintWriter writer = new PrintWriter(usersfile);   // write data to the usersfile.

	        for (User user : users) {
	            // Write each user to the file with the <NewUser/> tag on a separate line
	            writer.println(user.toString() + "<NewUser/>");
	        }

	        writer.close();
	    } catch (Exception e) {
	        System.err.println(e.toString()); // ( tostring ) -> return data into the File 
	    }
	}
	
//******************
// Book
	
	public void AddBook(Book book) {
		Books.add(book);
		booknames.add(book.getName());
		saveBooks();
	}
	
	
	public void saveBooks() {
	    try {
	        FileWriter fw = new FileWriter(Booksfile, true); // Append mode In append mode, if the file already exists,
	        //the new data will be appended to the existing content of the file. If the file doesn't exist, a new file will be created.
	        PrintWriter pw = new PrintWriter(fw);

	        for (Book book : Books) {
	            pw.println(book.toString2() + "<NewBook/>");
	        }

	        pw.close();
	        fw.close();
	    } catch (Exception e) {
	        System.err.println(e.toString());
	    }
	}
	

	
	public ArrayList<Book> getAllBooks(){
		return Books;
	}
	
// used in the class DeleteBooks to point to specific book
	
	public int getBook(String bookname) {
	    int i = -1;
	    for (Book book : Books) {
	        if (book.getName().equals(bookname)) {
	            i = Books.indexOf(book);
	            break;
	        }
	    }
	    return i;
	  
	}
	//
	public Book getBook(int i) {
		
		return Books.get(i);
	  }
	
	public void deleteBook(String bookname) {
	    int index = -1;
	    for (int i = 0; i < Books.size(); i++) {
	        Book book = Books.get(i);
	        if (book.getName().equals(bookname)) {
	            index = i;
	            break;
	        }
	    }
	    if (index != -1) {
	        Books.remove(index);
	        booknames.remove(index);
	        saveBooks();
	        System.out.println("Book deleted successfully!\n");
	    } else {
	        System.out.println("Book doesn't exist!\n");
	    }
	}

	
}
