import java.io.Serializable;
public abstract class  Book implements Serializable {
    private static final long serialVersionUID = 1L; //уникален идентификатор за версията на класа.
    private String title;
    private String author;
    private int pageCount;

    public Book(String title, String author, int pageCount){
        setTitle(title);
        setAuthor(author);
        setPageCount(pageCount);
    }
//get methods
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getPageCount(){
        return pageCount;
    }
    //set methods
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Името на автора не може да бъде празно или null.");
        }
        this.author = author;
    }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Заглавието не може да бъде празно или null.");
        }
        this.title = title;
    }
    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Броят на страниците трябва да бъде положително число.");
        }
        this.pageCount = pageCount;
    }

    abstract void openBook();
    abstract void closeBook();
}
