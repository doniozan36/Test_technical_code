package com.example.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entity.dto.ResponseApiDto;
import com.example.test.exception.GeneralException;
import com.example.test.tool.CommonUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/soal")
public class SoalController {
	
	@PostMapping("/satu")
	public ResponseApiDto soalSatu(@RequestBody Map<String, Object> map){
		try {
			if(!CommonUtil.isNumeric(map.get("number").toString())) {
				throw new GeneralException("Not Numeric");
			}
			return new ResponseApiDto(true, "Numeric", null);
		} catch (GeneralException e) {
			e.printStackTrace();
			return new ResponseApiDto(false, e.getMessage(), null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseApiDto(false, "Error occurred", null);
		}
	}
	
	@PostMapping("/empat")
	public ResponseApiDto soalEmpat(@RequestBody Map<String, Object> map){
		try {
			String numberString = map.get("number").toString();
			if(!CommonUtil.isNumeric(numberString)) {
				throw new GeneralException("Not Numeric");
			}
			String[] numberArray = numberString.split("");
			for(int i = 0; i < numberString.length(); i++) {
				String resultNumber = numberArray[i];
				for(int j = i+1; j > 0; j--) {
					resultNumber = resultNumber+"0";
				}
				numberArray[i] = resultNumber;
			}
			return new ResponseApiDto(true, "Numeric", numberArray);
		} catch (GeneralException e) {
			e.printStackTrace();
			return new ResponseApiDto(false, e.getMessage(), null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseApiDto(false, "Error occurred", null);
		}
	}
	
	@PostMapping("/lima")
	public ResponseApiDto soalLima(@RequestBody Map<String, Object> map){
		try {
			String numberString = map.get("number").toString();
			if(!CommonUtil.isNumeric(numberString)) {
				throw new GeneralException("Not Numeric");
			}
			List<String> result = new ArrayList<String>();
			for(int i = 0; i <= (int) map.get("number"); i++) {
				if(i % 2 == 1) {
					result.add(i+" Ganjil");
				}
			}
			return new ResponseApiDto(true, "Numeric", result);
		} catch (GeneralException e) {
			e.printStackTrace();
			return new ResponseApiDto(false, e.getMessage(), null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseApiDto(false, "Error occurred", null);
		}
	}
	
	@PostMapping("/enam")
	public ResponseApiDto soalEnam(@RequestBody Map<String, Object> map){
		try {
			String numberString = map.get("number").toString();
			if(!CommonUtil.isNumeric(numberString)) {
				throw new GeneralException("Not Numeric");
			}
			int bil;
			List<String> result = new ArrayList<String>();
			for (int i = 0; i <= (int) map.get("number"); i++){
	            bil=0;
	            for (int j=1;j<=i;j++){
	                if (i%j==0){
	                    bil=bil+1;
	                }
	            }
	            if (bil==2){
	            	result.add(i+" Bilangan Prima");
	            }             
	        }
			return new ResponseApiDto(true, "Numeric", result);
		} catch (GeneralException e) {
			e.printStackTrace();
			return new ResponseApiDto(false, e.getMessage(), null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseApiDto(false, "Error occurred", null);
		}
	}
}
