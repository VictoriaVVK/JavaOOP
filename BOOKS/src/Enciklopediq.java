import java.util.List;

public class Enciklopediq extends ScientificBook{
    String citedSources;

    public Enciklopediq(String title, String author, int pageCount, String fieldOfStudy, List<String> references) {
        super(title, author, pageCount, fieldOfStudy, references);
        this.citedSources= citedSources;
    }
}
