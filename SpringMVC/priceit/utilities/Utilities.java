package com.priceit.utilities;

import org.springframework.stereotype.Component;

@Component
public class Utilities {

	
	/*Checks to see if the string is null or empty
	 */
	public boolean isNullOrEmpty(String stringToCheck){
		boolean isNull = false;
		try {
		if(stringToCheck.equals(null) || stringToCheck.equals("")){
			isNull = true;
		}
		}catch(NullPointerException e){
			isNull = true;
		}
		
		return isNull;
		
		
	}
	
	/*Checks if the string is parsable
	 */
	public boolean checkIfNumber(String stringToCheck){
		boolean isNumber = true;
		
		try {
			Integer.parseInt(stringToCheck);
			
		} catch(Exception e){
			if(e instanceof NumberFormatException){
				isNumber = false;
			}
			if(e instanceof NullPointerException){
				isNumber = true;
			}
		}
		
		return isNumber;
		
	}

	
	public static boolean UPCorPLC(String code) {

		boolean returnResult = true;

		returnResult = validString(code);


		if ((code.length() == 4) || (code.length() == 5)

				|| (code.length() == 12)) {


			try {

				int testInt = Integer.parseInt(code);

			} catch (Exception e) {

				returnResult = false;

			}

			if (code.length() == 12) {

				char[] charArray = code.toCharArray();

				int[] upc = new int[12];

				for (int i = 0; i < 12; i++) {

					upc[i] = Integer.parseInt(String.valueOf(charArray[i]));

				}
				int oddDigit = (upc[0] + upc[2] + upc[4] + upc[6] + upc[8] + upc[10]) * 3;

				int evenDigit = upc[1] + upc[3] + upc[5] + upc[7] + upc[9];

				int total = oddDigit + evenDigit;

				if ((oddDigit + evenDigit + upc[11]) % 10 == 0) {

					returnResult = true;

				} else {
					returnResult = false;

				}
			}


		} else {

			returnResult = false;
		}


		return returnResult;

	}

public static boolean validString(String string){

		boolean isValid = false;

		if(string.length() > 0){

			isValid = true;

		} 
		return isValid;

	}
}

	
	

