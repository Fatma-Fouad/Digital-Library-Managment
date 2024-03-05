import java.util.Scanner;

public class User {
	
	private String username;
	private String password;
	Scanner sc = new Scanner(System.in);
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username) {
		this.username = username;
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
    public void issueBook(Library library) {
		System.out.println("Please enter the book title.");
		String s = sc.nextLine();
        for (Book book : library.books) {
            if (book.getTitle().equals(s) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book issued to " + getUsername());
                return;
            }else if(!book.isAvailable() && book.getTitle().equals(s)) {
            	System.out.println("Book not available for issue.");
            	return;
            }
        }
    	System.out.println("We do not have this Book in our library.");
    	if(this instanceof Admin) {
    		Scanner sc = new Scanner(System.in);
    		System.out.println("If you want to add it to the library enter 0. Otherwise enter 1.");
    		int x = sc.nextInt();
    		if(x == 0) {
    			System.out.println("Enter aouther name.");
    			String s1 = sc.nextLine();
    			System.out.println("Enter category name.");
    			String t = sc.nextLine();
    			((Admin)this).addBook(library);
    		}
    	}
    }
    
    public void returnBook(Library library) {
    	System.out.println("Please enter the book title.");
		String t = sc.nextLine();
        for (Book book : library.books) {
            if (book.getTitle().equals(t) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid book title or book already available.");
    }
    
    public void search(Library library) {
    	System.out.println("Please enter the book title.");
		String r = sc.nextLine();
    	 for (Book book : library.books) {
    		 if(book.getTitle().equals(r)) {
    			 System.out.println(book);
    			 return;
    		 }
    	 }   
    	 System.out.println("There is no such a book in our library.");
    }
    
    public void query() {
    	System.out.println("Please enter you query here.");
    	String query = sc.nextLine();
    	System.out.println("Your query is sent to the owners successfully.");
    	return;
    }
    
}
