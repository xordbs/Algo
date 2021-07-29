package com.ssafy.news;

import java.util.List;

public interface INewsDAO {

	List<News> getNewsList(String string);
	
	News search(int index);
}
