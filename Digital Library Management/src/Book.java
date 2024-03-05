
public class Book {

	public static int id;
	private String title;
    private String author;
    private boolean available;
    private String category;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.available = true;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }
    
    public String getCategory() {
    	return category;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "" + id + ". Book title:" + title + ", author:" + author + ", available:" + available + ", category:" + category;
	}

}
