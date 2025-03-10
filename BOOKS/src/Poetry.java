import java.io.Serializable;
public class Poetry extends Book implements LiteraryAnalysis,Serializable{
    private static final long serialVersionUID = 1L;
    private String poeticForm;
    private int verseCount;

    public Poetry(String title, String author, int pageCount, String poeticForm,int verseCount){
        super(title,author,pageCount);
        setPoeticForm(poeticForm);
        setVerseCount(verseCount);
    }

    public String getPoeticForm() {
        return poeticForm;
    }

    public int getVerseCount() {
        return verseCount;
    }

    public void setPoeticForm(String poeticForm) {
        if (poeticForm == null || poeticForm.trim().isEmpty()) {
            throw new IllegalArgumentException("Поетичната форма не може да бъде празна или null.");
        }
        this.poeticForm = poeticForm;
    }

    public void setVerseCount(int verseCount) {
        if(verseCount<=0){
            throw new IllegalArgumentException("Трябва да е положително!");
        }
        this.verseCount = verseCount;
    }

    @Override
    void openBook() {
        System.out.println("Отваряте стихотворението \"" + getTitle() + "\".");
    }
    @Override
    void closeBook() {
        System.out.println("Затваряте стихотворението \"" + getTitle() + "\".");
    }
   public void analyzeMeter(){
       System.out.println("Анализ на метъра на поетичната форма \"" + poeticForm + "\".");
   }
   public void recitePoem(){
       System.out.println("Рецитиране на стихотворението \"" + getTitle() + "\"...");
   }

    @Override
    public void analyzeLiteraryElements() {
        System.out.println("Анализ на литературните елементи в стихотворението \"" + getTitle() + "\".");
    }

    @Override
    public void interpretTheme() {
        System.out.println("Тълкуване на темата на стихотворението \"" + getTitle() + "\".");
    }
}
