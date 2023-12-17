package library;

// Mohra

public class Book {
	private String name;    //title
	private String author;    
	private String publisher;   
	private String adress;     //collection location
	private int qty;           //copies for sale
	private double price;

	
	
	public Book() {};
	public Book(String name, String author, String publisher, String adress, String status, int qty, double price ) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.adress = adress;
		this.qty = qty;
		this.price = price;

		
	}
	
	public String toString(){
		String text = "Book Name: " + name +"\n"+
				"Book Author: " + author +"\n"+
				"Book Publisher: " + publisher +"\n"+
				"Book Collection Adress: " + adress +"\n"+
				"Qty: " +String.valueOf(qty) +"\n"+
				"Book Price: " + String.valueOf(price) +"\n" ;
			return text ;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	public String toString2() {
		String text = name +"\t\t" + author +"\t\t" + publisher +"\t\t"+ adress +"\t\t"+String.valueOf(qty) 
		+"\t\t"+ String.valueOf(price) ;
			return text ;
	}
	


}
