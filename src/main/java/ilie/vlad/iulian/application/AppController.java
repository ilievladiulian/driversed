package ilie.vlad.iulian.application;

import ilie.vlad.iulian.application.service.AppService;
import ilie.vlad.iulian.handling.DTDNotRespectedException;
import ilie.vlad.iulian.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
	@Autowired
	private AppService appService;

	@RequestMapping(value = "/serve", method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getXML(@RequestParam(name = "file") String fileName) {
		return this.appService.getResource(fileName);
	}

	@RequestMapping(value = Constants.DTD_RESOURCE_NAME, method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getDTD() {
		return this.appService.getResource(Constants.DTD_RESOURCE_NAME);
	}

	@RequestMapping(value = Constants.XSL_RESOURCE_NAME, method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getXSL() {
		return this.appService.getResource(Constants.XSL_RESOURCE_NAME);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		this.appService.populateHomePage(model);
		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUploadPage() {
		return "uploadForm";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam(name = "file") MultipartFile file, Model model) {
		this.appService.uploadXMLFile(file, model);
		return "uploadStatus";
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String getSelection(Model model) {
		this.appService.populateHomePage(model);
		return "selection";
	}

	@RequestMapping(value = "/parse", method = RequestMethod.GET)
	public String parseXMLFile(@RequestParam(name = "file") String fileName, Model model) throws DTDNotRespectedException {
		this.appService.parseXMLFile(fileName, model);
		return "parsedFile";
	}
}
