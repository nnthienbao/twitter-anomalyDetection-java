/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ruananswer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static String toJSon(Object o) throws JsonProcessingException {
		return objectMapper.writeValueAsString(o);
	}
}