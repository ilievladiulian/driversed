package ilie.vlad.iulian.application;

import ilie.vlad.iulian.application.service.AppService;
import ilie.vlad.iulian.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
	@Autowired
	private AppService appService;

	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getHomePage() {
		return this.appService.getResource(Constants.XML_RESOURCE_NAME);
	}

	@RequestMapping(value = Constants.DTD_RESOURCE_NAME, method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getDTD() {
		return this.appService.getResource(Constants.DTD_RESOURCE_NAME);
	}

	@RequestMapping(value = Constants.XSL_RESOURCE_NAME, method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getXSL() {
		return this.appService.getResource(Constants.XSL_RESOURCE_NAME);
	}

	@RequestMapping(value = "/parse", method = RequestMethod.GET)
	public String parseXMLFile(@RequestParam(name = "file") String fileName, Model model) {
		this.appService.parseXMLFile(fileName, model);
		return "parsedFile";
	}
}
