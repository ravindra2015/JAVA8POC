package org.springframework.samples.mvc.javapoc.broker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {

    static NodeList nList1 = null;
    static Document basefile = null;
    
    public static List<String> getBrokers(String accNo) throws ParserConfigurationException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        List<String> nameList=new ArrayList<>();
		try {
			String resourcePath ="C:/TRAINING/JAVA8POC/java8-poc/src/main/resources/lookupTableStub.xml";
			basefile = docBuilder.parse(new File(resourcePath));
			basefile.normalizeDocument();
			if (accNo == null)
	            return Collections.EMPTY_LIST;
			accNo = accNo.replaceAll("-", "");
	        if (accNo.length() < 4)
	            return Collections.EMPTY_LIST;
	        accNo = accNo.substring(0, 4);
			
        	nList1 = basefile.getElementsByTagName("table-value");
		    for (int temp = 0; temp < nList1.getLength(); temp++) {
         
		    	Node nNode = nList1.item(temp);
          
		    	//String accNo="6785";
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String from=eElement.getElementsByTagName("value").item(2).getTextContent();
                    String to=eElement.getElementsByTagName("value").item(3).getTextContent();
                    
                    if(accNo.compareTo(from)>=0 && accNo.compareTo(to)<=0){
                    	nameList.add(eElement.getElementsByTagName("value").item(1).getTextContent());
                    }
                    
                }   
           }

            System.out.println(nameList);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
		return nameList;
          
    }
}
