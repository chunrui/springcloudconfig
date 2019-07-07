package en.edu.lingnan.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser {
	public static HashMap<String,String> parser(String xmlpath)
	{
	    HashMap<String,String> hm = new HashMap<String,String>(); 
	    String basepath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlpath = basepath+xmlpath;
		try {
	   		//ʵ����һ��SAXParserFactory����
			SAXParserFactory factory =  SAXParserFactory.newInstance();
			 //ͨ��factory���һ��saxParser���󣬼�SAX������
			SAXParser saxParser;
			File f = new File(xmlpath); //�¼�Դ
			XmlHandler xh = new XmlHandler();  //�¼�������
			saxParser = factory.newSAXParser();   //�¼�������
			saxParser.parse(f, xh);
			hm=xh.getHashMap();
//			System.out.println(hm.get("url"));
//			System.out.println(hm.get("driver"));
	 } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	
			 
		
		return hm;
	}
	public static void main(String[] args) {
		String xmlpath = "database.conf.xml";
	    System.out.println(XmlParser.parser(xmlpath));

	}

}
