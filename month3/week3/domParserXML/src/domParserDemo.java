import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class domParserDemo {
    public static void main(String[] args) {
        try {
            File f = new File("file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(f);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                System.out.println("\nCurrent Element: " + node.getNodeName());

                if (node.getNodeType() ==  Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    System.out.println("Student roll no : "
                            + e.getAttribute("rollno"));
                    System.out.println("First Name : "
                            + e
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + e
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Nick Name : "
                            + e
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Marks : "
                            + e
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
