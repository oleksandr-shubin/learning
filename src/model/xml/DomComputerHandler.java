package model.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DomComputerHandler {
    private List<Computer> computers = new ArrayList<Computer>();
    private Document document;

    public DomComputerHandler(Document document) {
        this.document = document;
    }


    public void handle() {
        NodeList computersNodeList = document.getElementsByTagName("computer");
        for (int i = 0; i < computersNodeList.getLength(); i++) {
            Node computerNode = computersNodeList.item(i);
            if (computerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element computerElement = (Element) computerNode;
                String title = computerElement
                        .getElementsByTagName("title").item(0).getTextContent();
                String type = computerElement
                        .getElementsByTagName("type").item(0).getTextContent();
                String amount = computerElement
                        .getElementsByTagName("amount").item(0).getTextContent();

                Computer computer = new Computer();
                computer.setTitle(title);
                computer.setType(type);
                computer.setAmount(amount);

                computers.add(computer);
            }
        }
    }

    public void displayResult() {
        String leftAlignFormat = "%-14s%-10s%-6s%n";
        System.out.printf(leftAlignFormat, "title", "type", "amount");
        for (Computer computer : computers) {
            System.out.printf(leftAlignFormat,
                    computer.getTitle(), computer.getType(),computer.getAmount());
        }
    }
}
