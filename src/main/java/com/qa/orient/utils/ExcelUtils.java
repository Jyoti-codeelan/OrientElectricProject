package com.qa.orient.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	
	 public static String ExcelSheetPath = "./src/main/java/com/qa/orient/testData/ConfigSheet.xlsx";
	    public static FileInputStream fis;
	    public static XSSFWorkbook workbook;
	    public static Sheet sheet;
	    public static XSSFRow row;
	    public String sheetName =null;
	    

		public final String LOGINDATA_SHEET = "LoginData";
		public final String TESTDATA_SHEET = "TestData";
		

	    public  String loadExcel() {

	    	File file = new File(ExcelSheetPath);

	        try {
	            fis = new FileInputStream(file);
	            workbook = new XSSFWorkbook(fis);
	            //sheet = workbook.getSheet("LoginData");
	            
	            
	            System.out.println("=> " + sheet.getSheetName());
	            
	            
	            try {
	    			switch (sheetName) {
	    			case "Login":
	    				sheetName = LOGINDATA_SHEET;
	    				sheet = workbook.getSheet(sheetName);
	    			            
	    				break;

	    			 case "TestData":
	    				 sheetName = TESTDATA_SHEET;
	    				 sheet = workbook.getSheet(TESTDATA_SHEET);
	    				            
	    			 break;
	    			
	    			}

	    			 fis.close();
	            }
	        
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	            }
	            catch (IOException e) {
	            e.printStackTrace();
	        }


	        
	    
	        
	        return sheetName;
	        
    
	    }

	    public  Map<String,Map<String,String>> getDataMap() { 
	        if(sheetName==null){
	            loadExcel();
	        }

	        Map<String, Map<String,String>> parentMap = new HashMap<String, Map<String,String>>();
	        Map<String, String> childMap = new HashMap<String, String>();

	        Iterator<Row> rowIterator = sheet.iterator();

	        while( rowIterator.hasNext() )
	        {
	            Row row = rowIterator.next();
	            childMap.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
	        }

	        parentMap.put("MASTERDATA", childMap);

	        return parentMap;


	    }

	    public  String getValue(String key) {
	        Map<String,String> mapValue = getDataMap().get("MASTERDATA");
	        String retValue = mapValue.get(key);

	        return retValue;
	    }
	    
	    
	   


	    public static void main(String []args){
	    ExcelUtils obj = new ExcelUtils();
		System.out.println(obj.getValue("Browser"));
	    	
		}


}
