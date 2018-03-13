package ilie.vlad.iulian.application;

import ilie.vlad.iulian.xml.parser.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

@RestController
public class AppController {
	@Autowired
	private XMLParser xmlParser;

	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getHomePage() {
		String xml = "";
		StreamSource source = new StreamSource("src/main/resources/xml/scoalasoferi.xml");
		try {
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.transform(source,result);
			xml = writer.toString();
		} catch (Exception e) {e.printStackTrace();}
		byte[] documentBody = xml.getBytes();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<byte[]>(documentBody, header);
	}

	@RequestMapping(value = "scoalasoferi.dtd",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getDTD() {
		String xml = "";
		StreamSource source = new StreamSource("src/main/resources/xml/scoalasoferi.dtd");
		try {
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.transform(source,result);
			xml = writer.toString();
		} catch (Exception e) {e.printStackTrace();}
		byte[] documentBody = xml.getBytes();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<byte[]>(documentBody, header);
	}

	@RequestMapping(value = "scoalasoferi.xsl",  method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getXSL() {
		String xml = "";
		StreamSource source = new StreamSource("src/main/resources/xml/scoalasoferi.xsl");
		try {
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.transform(source,result);
			xml = writer.toString();
		} catch (Exception e) {e.printStackTrace();}
		byte[] documentBody = xml.getBytes();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "xml"));
		header.setContentLength(documentBody.length);
		return new HttpEntity<byte[]>(documentBody, header);
	}
}
