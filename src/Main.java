import model.xml.StAXComputerHandler;

import javax.xml.stream.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("computerStore.xml"));

            StAXComputerHandler staxHandler = new StAXComputerHandler(eventReader);
            staxHandler.handle();
            staxHandler.displayResult();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
