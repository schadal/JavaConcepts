package com.test.cases;

import static org.junit.Assert.*;

import org.junit.Test;//use this framework not juniper test framework

public class ValidateIsbnTest {

	// ISBN Number is either 10 or 13 digit numbers. 
	
	@Test
	public void checkForValidISBN() {
	
		ValidateISBN validator = new ValidateISBN();
		Boolean isValid = validator.checkISBN("111953271X");
		assertTrue("First Valid No", isValid);//second step
		
		Boolean isValid1 = validator.checkISBN("111953271X");
		assertTrue("Second Valid No", isValid1);//second step
	}
	
	@Test
	public void checkForInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		Boolean isValid = validator.checkISBN("1140056789");
		//fail();
		assertFalse(isValid);//assertFalse expects false but we got true, hence test fails
	}
	
	@Test (expected = NumberFormatException.class)
	public void nineDigitISBNNumberNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		Boolean isValid = validator.checkISBN("Hello World");
		assertFalse("Text is invalid", isValid);
	}
	
	@Test
	public void IsbnNumberEndingWithXIsValid() {
		ValidateISBN validator = new ValidateISBN();
		Boolean isValid = validator.checkISBN("111953271X");
		assertTrue(isValid);
	}

}
