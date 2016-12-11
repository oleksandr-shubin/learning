package com.shubin.model.xml;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StAXComputerHandler {
    private List<Computer> computers = new ArrayList<Computer>();
    private XMLEventReader reader;
    boolean bTitle;
    boolean bType;
    boolean bAmount;


    public StAXComputerHandler(XMLEventReader eventReader) {
        this.reader = eventReader;
    }

    public void handle() throws XMLStreamException {
        while (reader.hasNext()) {
            XMLEvent event = reader.peek();
            if (event.isStartElement()) {
                StartElement start = event.asStartElement();
                String qName = start.getName().getLocalPart();
                if (qName.equals("computer")) {
                    Iterator<Attribute> attributes = start.getAttributes();
                    String id = attributes.next().getValue();
                    Computer computer = new Computer();
                    computer.setId(id);
                    computers.add(computer);
                } else if (qName.equals("title")) {
                    bTitle = true;
                } else if (qName.equals("type")) {
                    bType = true;
                } else if (qName.equals("amount")) {
                    bAmount = true;
                }
            } else if (event.isCharacters() && !((Characters) event).isWhiteSpace()) {
                String data = event.asCharacters().getData();
                Computer computer = computers.get(computers.size() - 1);
                if (bTitle) {
                    computer.setTitle(data);
                    bTitle = false;
                } else if (bType) {
                    computer.setType(data);
                    bType = false;
                } else if (bAmount) {
                    computer.setAmount(data);
                    bAmount = false;
                }
            }
            reader.nextEvent();
        }
    }

    public void displayResult() {
        String alignFormat = "ID=%-2s Title=%-11s Type=%-8s Amount=%-3s\n";
        for (Computer computer : computers) {
            System.out.printf(alignFormat, computer.getId(), computer.getTitle(),
                    computer.getType(), computer.getAmount());
        }
    }
}
