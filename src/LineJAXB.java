import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "line")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineJAXB {

    @XmlElement
    private String firstName;
    private String lastName;
    private String title;

    public LineJAXB() {
    }

    public LineJAXB(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public String lineReturn() {
        return firstName + "_" + lastName + "_" + title;
    }
}
