package ilie.vlad.iulian.application.service;

import ilie.vlad.iulian.generated.ScoalaSoferi;
import ilie.vlad.iulian.handling.DTDNotRespectedException;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AppService {

	HttpEntity<byte[]> getResource(String fileName);

	void parseXMLFile(String fileName, Model model) throws DTDNotRespectedException;

	void uploadXMLFile(MultipartFile file, Model model);

	void populateHomePage(Model model);

}
