package en.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {
	
	private StringBuffer sb = new StringBuffer();
	private HashMap<String,String> hm = new HashMap<String,String>(); 

	
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        //���һ���ɱ��ַ���
    	sb.delete(0, sb.length());
    }

    public HashMap<String, String> getHashMap() {
    	return hm;
		
	}

    
    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
        // �ѿɱ��ַ����浽ĳ���ַ�����
    	hm.put(qName.toLowerCase(), sb.toString().trim());
    }

   

   
    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        //�Ѷ�����ch����浽�ɱ��ַ�����
    	sb.append(ch,start,length);
    }	
}
