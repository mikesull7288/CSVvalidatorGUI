/**
 * 
 */
package com.zuora.csvvalidator;

/**
 * @author msullivan
 *
 */
public class StandarValidator {

	public static boolean validateDate(String date){
		
		boolean result = true;
		
		String delims = "[/]";
		
		String[] tokens = date.split(delims);
		
		if(tokens[2].length() < 4 ){
			result = false;
		}
		
		return result;
		
	}
	
	public static boolean validateBool(String bool){
		
		boolean result = true;
		
		if(!bool.equals("TRUE") && !bool.equals("FALSE") && !bool.equals("")){
			
			result = false;
			
		}
		
		return result;
	}
	
	public static boolean validateLength(String str){
		
		boolean result = true;
		
		if(str.length() > 50){
			result = false;
		}
		
		return result;
	}
	
	public static boolean validateLengthLong(String str){
		
		boolean result = true;
		
		if(str.length() > 500){
			result = false;
		}
		
		return result;
	}
	
	public static boolean validateInt(String str){
		
		boolean result = true;
		Integer.parseInt(str);
		
		
		if(Double.parseDouble(str) > 9999999999999.99){
			result = false;
		}
		
		return result;
	}
	
}
