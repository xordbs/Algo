package com.ssafy.happyhouse;

import java.io.IOException;

import com.ssafy.happyhouse.util.UseCsv;
import com.ssafy.happyhouse.view.HouseInfoView;

public class Main {
	public static void main(String[] args) {
		try {
			UseCsv.setData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new HouseInfoView();
	}
}
