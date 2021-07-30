package com.ssafy.happyhouse.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyhouse.model.dto.Environment;
import com.ssafy.happyhouse.view.HouseInfoView;

public class UseJson {

    @SuppressWarnings("unchecked")
	public static int enData(String dong) throws JsonParseException, JsonMappingException, IOException {
    	int count = 0;
        ObjectMapper mapper = new ObjectMapper();
        
        File json = new File("./res/서울시 종로구 환경 지도점검 내역 현황.json");

        // 배열은 List
        Map<String, Map<String, Object>> enResult = mapper.readValue(json, Map.class);
        List<Map<String, Object>> enList = (List<Map<String, Object>>)enResult.get("DATA");
        for(Map<String, Object> info: enList) {
            // 필요한 객체 형으로 변환
            Environment environment = mapper.convertValue(info,  Environment.class);
            String[] str = environment.getWrkp_addr().split(" ");
            if(str[2].equals(dong)) {
            	count++;
            }
        }
        return count;
    }
    
}

