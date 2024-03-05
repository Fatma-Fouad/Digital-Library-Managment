
class Admin extends User {
	
    public Admin(String username, String password) {
        super(username, password);
    }
    
    public Admin(String username) {
        super(username);
    }

    public void updateBookAvailability(Library library, int id) {
		System.out.println("Enter new availability. true or false.");
		boolean newt = sc.nextBoolean();
    	library.books.get(id).setAvailable(newt);
        System.out.println("Book availability is updated successfully.");
    }
    
    public void updateBookTitle(Library library, int id) {
    	System.out.println("Enter new book title.");
		String newt = sc.nextLine();
    	library.books.get(id).setTitle(newt);
        System.out.println("Book title is updated successfully.");
    }
    
    public void updateAouther(Library library, int id) {
		System.out.println("Enter new aouther name.");
		String newt = sc.nextLine();
    	library.books.get(id).setAuthor(newt);
        System.out.println("Book aouther is updated successfully.");
    }
    
    public void updateBookCategory(Library library, int id) {
		System.out.println("Enter new category name.");
		String newt = sc.nextLine();
    	library.books.get(id).setCategory(newt);
        System.out.println("Book category is updated successfully.");
    }

    public void addBook(Library library) {
		System.out.println("Enter Book title.");
		String title = sc.next();
		System.out.println("Enter auther.");
		String a = sc.next();
		System.out.println("Enter category.");
		String cat = sc.next();
		Book book = new Book(title, a, cat);
        library.addBook(book);
        System.out.println("The new book is added successfully.");
    }

    public void deleteBook(Library library) {
		System.out.print("Enter Book id to delete book.");
        int bid = sc.nextInt();
        library.deleteBook(library.books.get(bid));
        System.out.println("Book is deleted successfully.");
    }
    
    public void addUser(Library library) {
		System.out.println("Enter username.");
		String name = sc.nextLine();
		System.out.println("Enter password.");
		String pass = sc.nextLine();
		User user = new User(name, pass);
        library.addUser(user);
        System.out.println("The new user is added successfully.");
    }

    public void deleteUser(Library library) {
		System.out.print("Enter username to delete user.");
        String username = sc.nextLine();
    	for(int i = 0; i < library.getUsers().size(); i++) {
    		if(library.getUsers().get(i).getUsername().equals(username)) {
    			library.deleteUser(library.getUsers().get(i));
    			System.out.println("User is deleted successfully.");
    			return;
    		}
    	}System.out.println("No such a user.");
    }
    
    public void updateUsername(Library library, String username) {
		System.out.println("Enter new username.");
		String newt = sc.nextLine();
    	for(int i = 0; i < library.getUsers().size(); i++) {
    		if(library.getUsers().get(i).getUsername().equals(username)) {
    			library.getUsers().get(i).setUsername(newt);;
    			System.out.println("Username is updated successfully.");
    			return;
    		}
    	}System.out.println("No such a user.");
    }
    
    public void updatepassword(Library library, String username) {
		System.out.println("Enter new password.");
		String newt = sc.nextLine();
    	for(int i = 0; i < library.getUsers().size(); i++) {
    		if(library.getUsers().get(i).getUsername().equals(username)) {
    			library.getUsers().get(i).setUsername(newt);;
    			System.out.println("Password is updated successfully.");
    			return;
    		}
    	}System.out.println("No such a user.");
    }

}