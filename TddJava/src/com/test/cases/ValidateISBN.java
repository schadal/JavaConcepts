package com.test.cases;

public class ValidateISBN {

		
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int SHORT_ISBN_NUMBER = 10;

	/**
	 * checkISBN
	 * @param isbnNo
	 * @return Boolean
	 * @author sudhe
	 * @throws NumberFormatException
	 */
	public Boolean checkISBN(String isbnNo) {

		if(isbnNo.length() != SHORT_ISBN_NUMBER) throw new NumberFormatException("ISBN Numbers must be 10 digits in length.");
		
		return isValidShortISBN(isbnNo);
	}

	/**
	 * isValid10DigitISBNCode
	 * @param isbnNo
	 * @return Boolean
	 * @author sudheer
	 * @throws NumberFormatException
	 */
	private Boolean isValidShortISBN(String isbnNo) {
		int total = 0;
		for(int i=0; i<SHORT_ISBN_NUMBER; i++) {
			
			if(!Character.isDigit(isbnNo.charAt(i))) {
				if(i==9 && isbnNo.charAt(i) == 'X') {
					total += SHORT_ISBN_NUMBER;
				}else {
					throw new NumberFormatException("Character is not a numeric digit.");	
				}
				
			}else {
				total += Character.getNumericValue(isbnNo.charAt(i)) * (SHORT_ISBN_NUMBER -i);	
			}
			
		}
		
		return (total % SHORT_ISBN_MULTIPLIER == 0);
	}
}
