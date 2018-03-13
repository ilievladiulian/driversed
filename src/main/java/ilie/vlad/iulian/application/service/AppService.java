package ilie.vlad.iulian.application.service;

import org.springframework.http.HttpEntity;

public interface AppService {

	HttpEntity<byte[]> getResource(String fileName);

}
