import java.util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Java Programming", "John Doe", "Programming"));
        library.addBook(new Book("Data Structures", "Jane Smith", "Programming"));
        library.addBook(new Book("History of Science", "Albert Einstein", "Science"));
        library.addBook(new Book("Comptetitive Programming", "Steven & Felix Halim", "Programming"));
        library.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Crime"));
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", "Fiction"));
        library.addBook(new Book("Jarten laws", "Amr Abdel Hamid", "Novel"));
        library.addBook(new Book("Harry Potter and the Prisoner of Azkaban", "JK Rowling", "Fiction"));
        library.addBook(new Book("Land of Zicola", "Amr Abdel Hamid", "Novel"));
        library.addBook(new Book("Murder in Mesopotamia", "Agatha Christie", "Crime"));

        library.addUser(new User("Naglaa", "1234"));
        library.addUser(new Admin("Fatma", "1649"));
        library.addUser(new User("John", "5678"));
        library.addUser(new Admin("Bob", "0987"));

        System.out.println("Welcom to our library.");
        System.out.println("Enter a number from the following list.");
        System.out.println("\n1. sign in  as a user.\n2. sign in  as an admin.\n3. Contenue as a geust.\n4. Exit Library.");
        int c = sc.nextInt();
        while(c < 1 && c > 4) {
        	System.out.println("Invalid Input. Please try again.");
        	System.out.println("Enter a number from the following list.");
        	System.out.println("\n1. sign in  as a user.\n2. sign in  as an admin.\n3. Contenue as a geust.\n4. Exit Library.");
            c = sc.nextInt();
        }
        User u;
    	switch(c) {
    	case 1:
    		System.out.println("Enter your username.");
    		String s1 = sc.next();
    		System.out.println("Enter your password.");
    		String i = sc.next();
    		u = new User(s1,i);
    		int x = 0;
    		while(x != 6) {
	    		System.out.println("Enter a number from the following list.");
	    		System.out.println("\n1. Display Books\n2. Issue Book\n3. Return Book\n4. Search for a book\n5. Have a query?\n6. Close");
	    		x = sc.nextInt();
    			switch(x) {
    			case 1:
    				System.out.println("Choose one of the following.");
    				System.out.println("\n1. Display all books.\n2. Display all books in a spesific category.\n3. Display categories.");
    				int y = sc.nextInt();
    				if(y == 1)
    					library.displayBooks();
    				else if(y == 3)
    					library.displayCategories();
    				else {
    					library.displayBooksByCategory();
    				}break;
    			case 2:
    				u.issueBook(library);
    				break;
    			case 3:
    				u.returnBook(library);
    				break;
    			case 4:
    				u.search(library);
    				break;
    			case 5:
    				u.query();
    				break;
    			default: System.out.println("Invalid Input. Please try again.");
    			}
    		}	
    		break;
    		
    	case 2:
    		System.out.println("Enter your username.");
    		String usernamea = sc.next();
    		System.out.println("Enter your password.");
    		String passworda = sc.next();
    		u = new Admin(usernamea, passworda);
    		int x1 = 0;
    		
    		while(x1 != 9) {
	    		System.out.println("Enter a number from the following list.");
	    		System.out.println("\n1. Display Books\n2. Issue Book\n3. Return Book\n4. Search for a book\n5. Have a query?\n6. Update entry\n7. Add entry\n8. Delete entry\n9. Close");
	    		x1 = sc.nextInt();
    			switch(x1) {
    			case 1:
    				System.out.println("Choose one of the following.");
    				System.out.println("\n1. Display all books.\n2. Display all books in a spesific category.\n3. Display categories.");
    				int y = sc.nextInt();
    				if(y == 1)
    					library.displayBooks();
    				else if(y == 3)
    					library.displayCategories();
    				else {
    					library.displayBooksByCategory();
    				}break;
    			case 2:
    				u.issueBook(library);
    				break;
    			case 3:
    				u.returnBook(library);
    				break;
    			case 4:
    				u.search(library);
    				break;
    			case 5:
    				u.query();
    				break;
    			case 6:
    				System.out.println("Choose one of the following.");
    				System.out.println("\n1. Update book.\n2. Update user.");
    				int z = sc.nextInt();
    				if(z == 1) {
    					System.out.println("Enter book id");
    					int id = sc.nextInt();
    					System.out.println("Choose what do you want to update.");
    					System.out.println("\n1. Title.\n2. Aouther\n3. Category.\n4 Availability.");
    					int l = sc.nextInt();
    					if(l == 1) {
    						((Admin)u).updateBookTitle(library, id);
    					}else if(l == 2) {
    						((Admin)u).updateAouther(library, id);
    					}else if(l == 3) {
    						((Admin)u).updateBookCategory(library, id);
    					}else if(l == 4) {
    						((Admin)u).updateBookAvailability(library, id);
    					}else {
    						System.out.println("Invalid Input.");
    					}
    				}else if(z == 2) {
    					System.out.println("enter username.");
    					String username = sc.next();
    					System.out.println("Choose what do you want to update.");
    					System.out.println("\n1. Username.\n2. Password.");
    					int l = sc.nextInt();
    					if(l == 1) {
    						((Admin)u).updateUsername(library, username);
    					}else if(l == 2) {
    						((Admin)u).updatepassword(library, username);
    					}else {
    						System.out.println("Invalid Input.");
    					}
    				}else {
    					System.out.println("Invalid Input.");
    				}
    				break;
    			case 8:
    				System.out.println("\n1. Delete user.\n2. Delete book.");
    				int h = sc.nextInt();
    				if(h == 1) {
                        ((Admin)u).deleteUser(library);
    				}else if(h == 2) {
                        ((Admin)u).deleteBook(library);
    				}else {
    					System.out.println("Invalid Input.");
    				}
    				break;
    			case 9: return;
    			case 7:
    				System.out.println("\n1. Add user.\n2. Add book.");
    				int e = sc.nextInt();
    				if(e == 1) {
    					((Admin)u).addUser(library);
    				}else if(e == 2) {
    					((Admin)u).addBook(library);
    				}else {
    					System.out.println("Invalid Input.");
    				}
    				break;
    			}
    		}
    		break;
    	case 3:
    		System.out.println("These are all the Books in our library.");
    		library.displayBooks();
    		break;
    	case 4: return;
    	}

    }
}
