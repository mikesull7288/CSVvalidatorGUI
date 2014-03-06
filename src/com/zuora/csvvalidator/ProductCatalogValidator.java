package com.zuora.csvvalidator;

public class ProductCatalogValidator {
	
	public static boolean validateChargeType(String str){
		
		boolean result = true;
		
		if(!str.equals("OneTime") && !str.equals("Recurring") && !str.equals("Usage")){
			
			result = false;
			
		}
		
		return result;
		
	}
	//TODO add non-runtime/ required fields
	/*
	 * 
	 * Accounting Code- runtime
	   Revenue Recognition Code- runtime
	   Revenue Recognition Trigger- runtime
	   Charge Model
	   UOM- runtime
	   Default Qty- 0<int<9999999999999.99 
	   Min Qty- 0<int<9999999999999.99
	   Max Qty- 0<int<9999999999999.99
	   Overage Included Units- 0<int<9999999999999.99
	   Overage Smoothing Model- API
	   Overage Smoothing Period Number- 0<int<9999999999999.99
	   Trigger Condition- API
	   Billing Period- API
	   Specific Billing Period- API 
	   Billing Cycle Type- API
	   Billing Cycle Day- API
	   Billing Period Alignment- API
	   Tax Able- Boolean
	   Tax Code- runtime
	   Tier Number- int
	   Starting Unit- int
	   Ending Unit- int
	   Price Format- API
	   Currency- list
	   Price- 0<int< 9999999999999.99
	 * 
	 */

}
