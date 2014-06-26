package com.codeslinger.resume.resource;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

	private void buildNodeList( ClassPathResource pathToXMLFile )
	{
		try{
			SAXBuilder builder = new SAXBuilder();
			Document document = (Document) builder.build(pathToXMLFile.getFile());
			Element rootNode = document.getRootElement();
			nodes = rootNode.getChildren("data");
		}
		catch(Exception e){ /*do nothing, XML document failed to process */ }
	}

	private void buildSetFromNodes(){
		for(int i = 0; nodes != null && i < nodes.size();i++) {
			Element el = (Element)nodes.get(i);
			Attribute nameAttribute = (Attribute)el.getAttribute("name");
			Attribute valueAttribute = (Attribute)el.getAttribute("value");
			requestResponse.put(nameAttribute.getValue(),valueAttribute.getValue());
		}
	}
}