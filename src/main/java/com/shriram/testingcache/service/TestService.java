/**
 * 
 */
package com.shriram.testingcache.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author shriramsharma
 *
 */
@Service
@Qualifier("testService")
public class TestService {
	
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	private static Map<String, String> nameMap = new HashMap<String, String>();
	
	static {
		
		nameMap.put("Shriram", "Shriram Sharma");
		nameMap.put("Parul", "Parul chauhan");
		nameMap.put("Ashish", "Ashish Agrawal");
	}
	
	@Cacheable(value="fullName", key="#name")
	public String getFullName(String name, Map<String,Object> param) {
		logger.debug("Getting full name for: "+name);
		return nameMap.get(name);
	}

}
