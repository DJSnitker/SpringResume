package com.codeslinger.resume.resource;

import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Attribute;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.HashMap;
import java.util.List;
import org.springframework.core.io.ClassPathResource;

public class ResumeData{
	private List nodes;
	private HashMap<String, String> requestResponse;

	public String getDataValue(String key){
		return requestResponse.get(key);
	}

	public ResumeData(ClassPathResource pathToXMLFile){
		requestResponse = new HashMap<String, String>();	
		buildNodeList( pathToXMLFile );
		buildSetFromNodes();
	}

	private void buildNodeList( ClassPathResource pathToXMLFile ){
		try{
			SAXBuilder builder = new SAXBuilder();
			Document document = (Document) builder.build(pathToXMLFile.getFile());
			nodes = document.getRootElement().getChildren("data");
		}
		catch(Exception e){ /*do nothing, XML document failed to process */ }
	}

	private void buildSetFromNodes(){
		for(Object node : nodes ) {
			Element el = (Element)node;
			Attribute nameAttribute = (Attribute)el.getAttribute("name");
			Attribute valueAttribute = (Attribute)el.getAttribute("value");
			requestResponse.put(nameAttribute.getValue(),valueAttribute.getValue());
		}
	}
}