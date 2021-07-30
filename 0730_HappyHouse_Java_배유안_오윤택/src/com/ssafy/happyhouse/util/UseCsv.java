package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.Shop;


public class UseCsv {

	static List<Shop> ret = new ArrayList<Shop>();
	@SuppressWarnings("unchecked")
    public static void setData() throws IOException {
		BufferedReader br=null;
        try{
        	br = Files.newBufferedReader(Paths.get("./res/소상공인시장진흥공단_상가(상권)정보_서울_202106.csv"));
            String line = br.readLine();
           
            while((line = br.readLine()) != null){
               //CSV 1행을 저장하는 리스트
                //List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                Shop s = new Shop(array[1].replaceAll("\"", ""),array[4].replaceAll("\"", ""),array[18].replaceAll("\"", ""));
               
                ret.add(s);
               
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
       }
   
    }
	
	public static String toString(String dong) {
		Map<String,Integer> result = new HashMap<>();
		
		for(Shop s: ret) {
			if(s.getAddr().equals(dong)) {
				if(result.containsKey(s.getSort())) {
					Integer val = result.get(s.getSort());
					result.put(s.getSort(), ++val);
				}else {
					result.put(s.getSort(), 1);
				}
			}
		}
		
		String str = "";
		for(String key:result.keySet()) {
			str+=key+":";
			str+=result.get(key)+"개"+"\n";
		}
		System.out.println(str);
		return str;
		
	}
	
//	public static void main(String[] args) {
//		try {
//			setData();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(toString("보광동"));
//		System.out.println(ret.get(0).toString());
//	}
}
