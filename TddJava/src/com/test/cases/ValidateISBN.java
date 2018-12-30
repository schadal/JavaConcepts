package com.test.cases;

public class ValidateISBN {

	public void ValidateISBN() {}
	
	public Boolean checkISBN(String isbnNo) {

		if(isbnNo.length() != 10) throw new NumberFormatException("ISBN Numbers must be 10 digits in length.");
		
		int total = 0;
		for(int i=0; i<10; i++) {
			
			if(!Character.isDigit(isbnNo.charAt(i))) {
				if(i==9 && isbnNo.charAt(i) == 'X') {
					total += 10;
				}else {
					throw new NumberFormatException("Character is not a numeric digit.");	
				}
				
			}else {
				total += Character.getNumericValue(isbnNo.charAt(i)) * (10 -i);	
			}
			
		}
		
		if(total % 11 == 0) {
			return true;
		}else {
			return false;
		}
	}
}
