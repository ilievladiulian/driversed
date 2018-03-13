package ilie.vlad.iulian.application;

import ilie.vlad.iulian.application.service.AppService;
import ilie.vlad.iulian.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getHomePage() {
		return this.appService.getResource(Constants.XML_RESOURCE_NAME);
	}

	@RequestMapping(value = Constants.DTD_RESOURCE_NAME,  method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getDTD() {
		return this.appService.getResource(Constants.DTD_RESOURCE_NAME);
	}

	@RequestMapping(value = Constants.XSL_RESOURCE_NAME,  method = RequestMethod.GET, produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
	public HttpEntity<byte[]> getXSL() {
		return this.appService.getResource(Constants.XSL_RESOURCE_NAME);
	}
}
