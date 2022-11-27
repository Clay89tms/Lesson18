import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main18 {
    static String scPathFind;

    public static void main(String[] args) throws JAXBException, IOException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Path:\n>>>");
            //C:\Users\Clay\TMS School\Lesson 18 21.11.2022\src\res - null
            //C:\Users\Clay\TMS School\Lesson 18 21.11.2022\src\resources - list
            String scPath = scanner.nextLine();
            File path = new File(scPath);
            File[] paths = path.listFiles();
            findFile(paths, scPath);

            LineJAXB lineJAXB = new LineJAXB();
            lineScan(scPathFind);

        }catch (NullPointerException npe){
            System.out.println("Path is Bad");
        }catch (UnmarshalException un) {
            System.out.println("File is Null");
        }
    }

    private static String findFile(File[] paths, String scPath) {
        Scanner scEnter = new Scanner(System.in);
        String regexNameFile = "([A-Za-z0-9._%+-]+\\.xml)";
        if (paths.length == 0) {
            System.out.println("don't have a file!");
        } else {
            System.out.println("Folder have (file.xml):");
            for (int i = 0; i < paths.length; i++) {
                if (Pattern.matches(regexNameFile, paths[i].getName())) {
                    System.out.println((i) + ") " + paths[i].getName());
                }
            }
            System.out.print("Enter number file: ");
            if (scEnter.hasNextInt()) {
                int enterFile = scEnter.nextInt();
                if ((enterFile >= 0) && (enterFile < paths.length)) {
                    System.out.println(paths[enterFile].getName());
                    scPathFind = scPath + "\\" + paths[enterFile].getName();
                }
            }
        }
        return scPathFind;
    }

    private static void lineScan(String scPathFind) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(LineJAXB.class);
        LineJAXB lineJAXB = (LineJAXB) context.createUnmarshaller().unmarshal(new FileReader(scPathFind));
        Path path = Paths.get("src/" + lineJAXB.lineReturn() + ".txt");
        if (!Files.exists(path)) {
            Path pathValid = Files.createFile(path);
        }
    }
}
