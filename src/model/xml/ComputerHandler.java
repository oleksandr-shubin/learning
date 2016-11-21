package model.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ComputerHandler extends DefaultHandler {

    List<Computer> computers = new ArrayList<Computer>();
    boolean bTitle = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("computer")) {
            Computer computer = new Computer();
            computer.setId(attributes.getValue("id"));
            computers.add(computer);
        } else if(qName.equals("title")) {
            bTitle = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTitle) {
            Computer computer = computers.get(computers.size() - 1);
            computer.setTitle(new String(ch, start, length));
            bTitle = false;
        }
    }

    public void displayResult() {
        if (computers.size() == 0) {
            System.out.println("No computers found");
        }

        for (Computer computer : computers) {
            System.out.println("id: " + computer.getId() +
                    " - title: " + computer.getTitle());
        }
    }

    class Computer {
        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
