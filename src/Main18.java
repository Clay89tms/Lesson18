import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main18 {
    public static void main(String[] args) throws JAXBException, IOException {

//        CityJAXB cityJAXB = new CityJAXB("nameTest", "mesTest");
        LineJAXB lineJAXB = new LineJAXB();
        lineScan();
//        murshal(cityJAXB);
//        unmarshal();

    }

//    private static void murshal(CityJAXB cityJAXB) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(CityJAXB.class);
//        Marshaller mar = context.createMarshaller();
//        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal(cityJAXB, new File("src/resources/city.xml"));
//    }
//
//    private static void unmarshal() throws FileNotFoundException, JAXBException {
//        JAXBContext context = JAXBContext.newInstance(CityJAXB.class);
//        CityJAXB cityJAXB = (CityJAXB) context.createUnmarshaller().unmarshal(new FileReader("src/resources/city.xml"));
//        System.out.println(cityJAXB);
//    }

    private static void lineScan() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(LineJAXB.class);
        LineJAXB lineJAXB = (LineJAXB) context.createUnmarshaller().unmarshal(new FileReader("src/resources/line.xml"));
        Path path = Paths.get("src/" + lineJAXB.lineReturn() + ".txt");
        if (!Files.exists(path)) {
            Path pathValid = Files.createFile(path);
        }
//        System.out.println(lineJAXB);
    }
}
