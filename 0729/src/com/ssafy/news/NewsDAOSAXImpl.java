package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class NewsDAOSAXImpl implements INewsDAO{
	
	static List<News> list = new ArrayList<>();

	@Override
	public List<News> getNewsList(String string) {
		
    	try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SAXHandler hd = new SAXHandler();
			parser.parse(string, hd);
			
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
    	
        return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void connectNews(String url) {
		
	}

}
