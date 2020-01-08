package com.ssafy.safefood.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class OpenApiServiceImpl implements OpenApiService {
	static final String KEY = "f61bf6d309b858a4ad9b8e5b341baf7f";
	
	@Override
	public List<HashMap<String, Object>> shoppingInfo(String name) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		String url = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=" + KEY + "&apiCode=ProductSearch&keyword="+ name +"&sortCd=I&pageSize=10";
		Document doc = dBuilder.parse(url);

		// root tag 
		doc.getDocumentElement().normalize();
//		System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result
		
		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("Product");
//		System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		for(int temp = 0; temp < nList.getLength(); temp++){		
			Node nNode = nList.item(temp);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				HashMap<String,Object> map = new HashMap<String, Object>();
				Element eElement = (Element) nNode;
//				System.out.println("######################");
				//System.out.println(eElement.getTextContent());
//				System.out.println("이미지  : " + getTagValue("ProductImage300", eElement));
//				System.out.println("상품명  : " + getTagValue("ProductName", eElement));
//				System.out.println("상품가격 : " + getTagValue("ProductPrice", eElement));
//				System.out.println("판매가격 : " + getTagValue("SalePrice", eElement));
//				System.out.println("할인가격 : " + getTagValue("Discount", eElement));
//				System.out.println("레이팅  : " + getTagValue("Rating", eElement));
//				System.out.println("구매만족도  : " + getTagValue("BuySatisfy", eElement));
//				System.out.println("URL  : " + getTagValue("DetailPageUrl", eElement));
				map.put("ProductImage300", getTagValue("ProductImage300", eElement));
				map.put("ProductName", getTagValue("ProductName", eElement));
				map.put("ProductPrice", getTagValue("ProductPrice", eElement));
				map.put("SalePrice", getTagValue("SalePrice", eElement));
				map.put("Discount", getTagValue("Discount", eElement));
				map.put("Rating", getTagValue("Rating", eElement));
				map.put("SellerGrd", getTagValue("SellerGrd", eElement));
				map.put("BuySatisfy", getTagValue("BuySatisfy", eElement));
				map.put("DetailPageUrl", getTagValue("DetailPageUrl", eElement));
				map.put("ReviewCount", getTagValue("ReviewCount", eElement));
				
				list.add(map);
			}	// if end
		}	// for end
		
		return list;
	}
	
    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
}
