package ilie.vlad.iulian.xml.parser;

import ilie.vlad.iulian.generated.ObjectFactory;
import ilie.vlad.iulian.generated.ScoalaSoferi;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Service
public class XMLParser {

	public ScoalaSoferi parseXMLResource(String fileName) throws Exception{
		//1. We need to create JAXContext instance
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

		//2. Use JAXBContext instance to create the Unmarshaller.
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		System.setProperty("javax.xml.accessExternalDTD", "all");

		//3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
		ScoalaSoferi unmarshalledObject = (ScoalaSoferi) unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream(fileName));

		//4. Get the instance of the required JAXB Root Class from the JAXBElement.
		return unmarshalledObject;
	}

}
