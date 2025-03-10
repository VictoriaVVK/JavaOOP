import java.util.List;
import java.io.Serializable;

public class ScientificBook extends Book implements Serializable{
    private static final long serialVersionUID = 1L;
    private String fieldOfStudy;
    private List<String> references;

    public ScientificBook(String title, String author, int pageCount, String fieldOfStudy, List<String> references){
        super(title, author, pageCount);
        setFieldOfStudy(fieldOfStudy);
        setReferences(this.references);
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        if (fieldOfStudy == null || fieldOfStudy.trim().isEmpty()) {
            throw new IllegalArgumentException("Научната област не може да бъде празна или null.");
        }
        this.fieldOfStudy = fieldOfStudy;
    }

    public List<String> getReferences() {
        return references;
    }
    public void setReferences(List<String> references) {
        if (references == null || references.isEmpty()) {
            throw new IllegalArgumentException("Списъкът със справки не може да бъде null или празен.");
        }
        for (String reference : references) {
            if (reference == null || reference.trim().isEmpty()) {
                throw new IllegalArgumentException("Справка в списъка не може да бъде null или празна.");
            }
        }
        this.references = references;
    }

    @Override
    public void openBook() {
        System.out.println("Отваряте научната книга \"" + getTitle() + "\".");
    }
    @Override
    public void closeBook() {
        System.out.println("Затваряте научната книга \"" + getTitle() + "\".");
    }

    public void conductExperiment(){
        System.out.println("Провеждане на експеримент в област \"" + fieldOfStudy + "\".");
    }
    public void reviewLiterature(){
        System.out.println("Преглед на литературата за област \"" + fieldOfStudy + "\".");
    }
}
