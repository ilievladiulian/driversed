package ilie.vlad.iulian.cache;

import ilie.vlad.iulian.generated.ScoalaSoferi;
import ilie.vlad.iulian.xml.parser.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CacheInitializer {
	@Autowired
	private XMLParser xmlParser;

	@PostConstruct
	public void init() {
		ScoalaSoferi scoalaSoferi = null;
		try {
			scoalaSoferi = this.xmlParser.parseXMLResource("scoalasoferi.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (scoalaSoferi != null) {
			Cache.studentList = scoalaSoferi.getStudenti().getStudent();
			Cache.informatie = scoalaSoferi.getInformatie();
		}
	}
}
