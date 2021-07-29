package com.ssafy.news;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler{
	
	 String b;
	 boolean flag;
	 News n;	
	
	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {
		if(qName.equals("item")) {
			n = new News();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(n != null) {
			if (qName.equals("title"))  {
				n.setTitle(this.b);
			} else if (qName.equals("description")) {
				n.setDesc(this.b);
			} else if (qName.equals("item")) {
				NewsDAOSAXImpl.list.add(n);
				n = null;
			}
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.b = new String(ch, start, length);
	}	
}
