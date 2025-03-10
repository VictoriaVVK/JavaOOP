import java.io.Serializable;
public class Novel extends Book implements LiteraryAnalysis,Serializable{
    private static final long serialVersionUID = 1L;
    private String genre;
    private String mainCharacter;

    public Novel(String name, String author, int pageCount, String genre, String mainCharacter){
        super(name,author,pageCount);
       setGenre(genre);
        setMainCharacter(mainCharacter);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Жанрът не може да бъде празен или null.");
        }
        this.genre = genre;
    }

    public void setMainCharacter(String mainCharacter) {
        if (mainCharacter == null || mainCharacter.trim().isEmpty()) {
            throw new IllegalArgumentException("Името на главния герой не може да бъде празно или null.");
        }
        this.mainCharacter = mainCharacter;
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    @Override
    public void openBook() {
        System.out.println("Отваряме книгата: "+getTitle() + " с автор"+ getAuthor());
    }

    @Override
   public void closeBook() {
        System.out.println("Затваряме книгата: "+getTitle() + " с автор"+ getAuthor());
    }

   public void summary(){
        System.out.println("Новелата: "+ getTitle()+ " e жанр: "+ getGenre()+" a главният герой е: "+getMainCharacter());
    }
    public void readExcerpt(){
        System.out.println("Четене на част от "+ getTitle());
    }

    @Override
    public void analyzeLiteraryElements() {
        System.out.println("Анализираме част от: "+getTitle() + " с автор"+ getAuthor());
    }

    @Override
    public void interpretTheme() {
        System.out.println("Тълкуване на темата в: "+getTitle() + " с автор"+ getAuthor());
    }
}
