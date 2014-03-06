/**
 * 
 */

//TODO Add README

package com.zuora.csvvalidator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.csvreader.*;

/**
 * @author msullivan
 *
 */
public class TemplateReader {

	private static String PROPERTIES_FILE_PROPERTY_NAME = "config.properties";
	private static Properties properties;
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		loadProperties();
		CsvReader csvIn = null;
		CsvReader csvTemplate = null;
		String[] headers = new String[50];
		try {
			//create CsvReaders
			csvIn = new CsvReader(args[0]);
			csvTemplate = new CsvReader(args[1]);
			
			System.out.println("### Start");
			System.out.println("### Checking headers");
			
			//read headers
			csvIn.readHeaders();
			csvTemplate.readHeaders();
			
			//check header count
			if(csvIn.getHeaderCount() != csvTemplate.getHeaderCount()){
				System.out.println("### Error: Input header count does not match Template");
				System.exit(1);
			}
			else{
				//check header values
				for(int i =0; i < csvIn.getHeaderCount(); i++){
					String inHeader = csvIn.getHeader(i);
					String templateHeader = csvTemplate.getHeader(i);
					if(!inHeader.equals(templateHeader)){
						System.out.println("### Error: Input header does not match Template");
						System.exit(1);
					}
					else {
						System.out.print(inHeader + ", ");
						//Debug
						headers[i] = inHeader;
					}
				}
				
				System.out.println("### Parsing");
				while (csvIn.readRecord()){
					int i = 0;
					System.out.println("### Reading row " + i);
					//csvIn.get(headerName);
					System.out.println("### Reading reading " + csvIn.getCurrentRecord());
					String[] records = csvIn.getValues();
					for(int l=0; l <= records.length; l++){
						//check Is Product Begin
						if(!StandarValidator.validateBool(csvIn.get("Is Product Begin"))){
							System.out.println("### Error in row " + i);
							break;
						}	
						//check Product Name
						if(!StandarValidator.validateLength(csvIn.get("Product Name"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//check Product Description
						if(!StandarValidator.validateLengthLong(csvIn.get("Product Description"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//check Product SKU
						/*
						 * 
						 */
						//Product Effective Start Date
						if(!StandarValidator.validateDate(csvIn.get("Product Effective Start Date"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Product Effective End Date
						if(!StandarValidator.validateDate(csvIn.get("Product Effective End Date"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Product Category
						/*
						 * 
						 */
						//Is Rate Plan Begin
						if(!StandarValidator.validateBool(csvIn.get("Is Rate Plan Begin"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Rate Plan Name
						if(!StandarValidator.validateLength(csvIn.get("Rate Plan Name"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Rate Plan Description
						if(!StandarValidator.validateLengthLong(csvIn.get("Rate Plan Description"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Rate Plan Effective Start Date
						if(!StandarValidator.validateDate(csvIn.get("Rate Plan Effective Start Date"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Rate Plan Effective End Date
						if(!StandarValidator.validateDate(csvIn.get("Rate Plan Effective End Date"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Is Charge Begin
						if(!StandarValidator.validateBool(csvIn.get("Is Charge Begin"))){
							System.out.println("### Error in row " + i);
							break;
						}	
						//Charge Name
						if(!StandarValidator.validateLength(csvIn.get("Charge Name"))){
							System.out.println("### Error in row " + i);
							break;
						}
						//Charge Type
						if(!ProductCatalogValidator.validateChargeType("Charge Type")){
							System.out.println("### Error in row " + i);
							break;
						}
						//Charge Description
						if(!StandarValidator.validateLengthLong(csvIn.get("Charge Description"))){
							System.out.println("### Error in row " + i);
							break;
						}
						/*
						 * 
						 * Accounting Code
						   Revenue Recognition Code
						   Revenue Recognition Trigger
						   Charge Model
						   UOM
						   Default Qty
						   Min Qty
						   Max Qty
						   Overage Included Units
						   Overage Smoothing Model
						   Overage Smoothing Period Number
						   Trigger Condition
						   Billing Period
						   Specific Billing Period
						   Billing Cycle Type
						   Billing Cycle Day
						   Billing Period Alignment
						   Tax Able
						   Tax Code
						   Tier Number
						   Starting Unit
						   Ending Unit
						   Price Format
						   Currency
						   Price
						 * 
						 */
					}
					i++;
				}
				csvIn.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		

	}
	

	public static void loadProperties() {

		try {
			properties = new Properties();
			properties.load(new FileInputStream(PROPERTIES_FILE_PROPERTY_NAME));
		} catch (IOException e) {
			System.out.println("Error while reading input data file: " + PROPERTIES_FILE_PROPERTY_NAME);
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println("Error while loading: " + e.getMessage());
		}
	}//loadProperties()
 
	public Properties getProperties() {
		if (properties == null) {
			loadProperties();
		}
		return properties;
	}//getProperties()
	 

}
