package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

@Service
public class XMLValidatorService {
	
	public boolean validate(File input, File xsd){
		StAXSource source=null;
		FileInputStream inputStream=null;
		
		boolean flag = false;
		
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(xsd);
			
			Validator validator = schema.newValidator();
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			inputStream = new FileInputStream(input);
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
			source = new StAXSource(xmlStreamReader);
			validator.validate(source);
			
			flag = true;
			
		}catch(SAXException e) {
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	
	

}
