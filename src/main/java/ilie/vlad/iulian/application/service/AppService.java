package ilie.vlad.iulian.application.service;

import ilie.vlad.iulian.generated.ScoalaSoferi;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;

public interface AppService {

	HttpEntity<byte[]> getResource(String fileName);

	void parseXMLFile(String fileName, Model model);

}
