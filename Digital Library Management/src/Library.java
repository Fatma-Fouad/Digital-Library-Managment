import java.util.*;

public class Library {
	ArrayList<Book> books;
    private ArrayList<User> users;
    Map<String, ArrayList<Book>> categories;
    Scanner sc = new Scanner(System.in);

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.categories = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        if (!categories.containsKey(book.getCategory())) {
            categories.put(book.getCategory(), new ArrayList<>());
        }
        categories.get(book.getCategory()).add(book);
    }
    
    public void deleteBook(Book book) {
    	books.remove(book);
    	if (categories.containsKey(book.getCategory())) {
    		categories.get(book.getCategory()).remove(book);
    	}
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public void deleteUser(User user) {
    	users.remove(user);
    }
    
    public void issueBook(User user) {
    	user.issueBook(this);
    }
    
    public void returnBook(User user) {
    	user.issueBook(this);
    }
    
    public void displayBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println(++Book.id + ": " + book.getTitle() + " by " + book.getAuthor() + " - Available: " + book.isAvailable());
        }
    }
    
    public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void displayBooksByCategory(){
		System.out.println("Please enter the category name");
		String s = sc.next();
    	if (categories.containsKey(s)) {
    		System.out.println("Books in category '" + s + "':");
    		for (Book book : categories.get(s)) {
    			System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Available: " + book.isAvailable());
    		}
    	} else {
    		System.out.println("Category not found.");
    	}
    }

    public void displayCategories() {
        System.out.println("Available Categories:");
        for (String category : categories.keySet()) {
            System.out.println(category);
        }
    }
}
