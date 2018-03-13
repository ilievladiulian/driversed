package ilie.vlad.iulian.application.service.impl;

import ilie.vlad.iulian.application.service.AppService;
import ilie.vlad.iulian.util.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

@Service
public class AppServiceImpl implements AppService {

	@Override
	public HttpEntity<byte[]> getResource(String fileName) {
		String xml = "";
		StreamSource source = new StreamSource(Constants.PATH_TO_RESOURCE + fileName);
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
