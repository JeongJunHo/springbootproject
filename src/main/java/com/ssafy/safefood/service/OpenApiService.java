package com.ssafy.safefood.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface OpenApiService {
	public List<HashMap<String,Object>> shoppingInfo(String name) throws SAXException, IOException, ParserConfigurationException;
}
