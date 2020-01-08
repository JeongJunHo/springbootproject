package com.ssafy.safefood.util;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.ssafy.safefood.dto.FoodDTO;



/**
 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용해서 식품 정보를 load하는 SAX Parser 프로 그램  
 *
 */
@Component
public class FoodSaxParser {
	private String nutritionFilePath = "res/FoodNutritionInfo.xml";
	private String foodFilePath = "res/FoodInfo.xml";
	private StringBuilder xml;
	private List<FoodDTO> foods;
 	public FoodSaxParser() {
		loadData();
	}
 	
 	/**
 	 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용 파싱한 식품 정보와 식품 영양 정보를  Food에 병합한다. 
 	 */
	private void loadData() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try{
			SAXParser parser = factory.newSAXParser();
			FoodSAXHandler handler = new FoodSAXHandler();
			FoodNutritionSAXHandler nHandler = new FoodNutritionSAXHandler();
			
			ClassPathResource nutritionResource = new ClassPathResource(nutritionFilePath);
	 		ClassPathResource foodResource = new ClassPathResource(foodFilePath);
			
//	 		parser.parse(foodFilePath,handler);
//			parser.parse(nutritionFilePath,nHandler);
			parser.parse(foodResource.getURI().toString(),handler);
			parser.parse(nutritionResource.getURI().toString(),nHandler);
			Map<String, FoodDTO> foodMap = handler.getFoods();
			foods = nHandler.getList();
			FoodDTO find;
			for (FoodDTO food : foods) {
				find = foodMap.get(food.getName());
				if(find!=null) {
					food.setCode(find.getCode());
					food.setName(find.getName());
					food.setMaker(find.getMaker());
					food.setMaterial(find.getMaterial());
					food.setImg(find.getImg());
				}
			}
//			System.out.println(foods);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<FoodDTO> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodDTO> foods) {
		this.foods = foods;
	}
	
}
