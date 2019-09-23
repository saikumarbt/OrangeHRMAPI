package com.orangehrm.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import com.orangehrm.utils.TestUtils;

public class RandomString {
	
	@Test
	public void generateRandomString() {
	  
	    int length = 3;
	    boolean useLetters = false;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    System.out.println(generatedString);
	}
	
	@Test
	public void getDetails() {
		System.out.println(TestUtils.getFirstName()+ TestUtils.getLastName()+ TestUtils.getCode());
	}

}
