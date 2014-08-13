package com.priceit.services.parseService;

public class ParseService {

	
   public long parseLong(String number) {
		long result = 0;
		String num = number;
		try {
			result = Long.parseLong(num);
		} catch (Exception e) {	
		}
		return result;
   }
}

