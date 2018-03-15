package ilie.vlad.iulian.xml.parser;

import ilie.vlad.iulian.generated.ObjectFactory;
import ilie.vlad.iulian.generated.ScoalaSoferi;
import org.springframework.stereotype.Service;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;

@Service
public class XMLParser {
	private static final String RESOURCE_PATH = "xml/uploaded/";

	public ScoalaSoferi parseXMLResource(String fileName) throws Exception{
		//1. We need to create JAXContext instance
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

		//2. Use JAXBContext instance to create the Unmarshaller.
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		System.setProperty("javax.xml.accessExternalDTD", "all");

		final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		final XMLReader reader = saxParserFactory.newSAXParser().getXMLReader();
		reader.setEntityResolver(new EntityResolver() {

			@Override
			public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException, IOException {

				return new InputSource(ClassLoader.getSystemResourceAsStream("xml/scoalasoferi.dtd"));
			}
		});
		final SAXSource saxSource = new SAXSource(reader, new InputSource(ClassLoader.getSystemResourceAsStream(RESOURCE_PATH + fileName)));

		//3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
		return (ScoalaSoferi) unmarshaller.unmarshal(saxSource);
	}

}
