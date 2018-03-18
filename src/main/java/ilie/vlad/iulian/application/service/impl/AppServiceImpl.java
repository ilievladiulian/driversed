package ilie.vlad.iulian.application.service.impl;

import ilie.vlad.iulian.application.service.AppService;
import ilie.vlad.iulian.cache.Cache;
import ilie.vlad.iulian.generated.ScoalaSoferi;
import ilie.vlad.iulian.handling.DTDNotRespectedException;
import ilie.vlad.iulian.util.Constants;
import ilie.vlad.iulian.xml.parser.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xml.sax.SAXParseException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.UnmarshalException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private XMLParser xmlParser;

	@Override
	public HttpEntity<byte[]> getResource(String fileName) {
		String xml = "";
		String fullPath = Constants.PATH_TO_RESOURCE;
		if (fileName.contains(".xml")) {
			fullPath = fullPath + "uploaded/";
		}
		StreamSource source = new StreamSource(fullPath + fileName);
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

	@Override
	public void parseXMLFile(String fileName, Model model) throws DTDNotRespectedException {
		try {
			ScoalaSoferi scoalaSoferi = this.xmlParser.parseXMLResource(fileName);
			updateCache(scoalaSoferi);
			model.addAttribute("studenti", scoalaSoferi.getStudenti());
			model.addAttribute("informatie", scoalaSoferi.getInformatie());
			model.addAttribute("message", "After parsing " + fileName + ":");
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error parsing xml file");
			throw new DTDNotRespectedException();
		}
	}

	@Override
	public void uploadXMLFile(MultipartFile file, Model model) {
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file");
			return;
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(Constants.UPLOAD_DIR + file.getOriginalFilename());
			Files.write(path, bytes);
			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void populateHomePage(Model model) {
		File folder = new File(Constants.UPLOAD_DIR);
		File[] listOfFiles = folder.listFiles();
		List<String> fileNames = new ArrayList<>();
		for (int index = 0; index < listOfFiles.length; index++) {
			if (listOfFiles[index].getName().contains(".xml")) {
				fileNames.add(listOfFiles[index].getName());
			}
		}
		if (fileNames.isEmpty()) {
			model.addAttribute("message", "There are no files uploaded yet.");
		} else {
			model.addAttribute("message", "The files uploaded are:");
		}
		model.addAttribute("files", fileNames);
	}

	private void updateCache(ScoalaSoferi scoalaSoferi) {
		Cache.informatie = scoalaSoferi.getInformatie();
		Cache.studentList = scoalaSoferi.getStudenti().getStudent();
	}
}
