package com.orangehrm.tests;

import java.util.Random;

import org.junit.Test;

import com.orangehrm.utils.TestUtils;

public class TestDataGen {

	@Test
	public void testDoBGen() {
		System.out.println(TestUtils.getDob()+TestUtils.getGender()+TestUtils.getMaritalStatus()+TestUtils.getNationality());
	
	}	
	
	

}
