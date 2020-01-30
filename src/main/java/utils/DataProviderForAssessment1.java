package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderForAssessment1 {
	
	@DataProvider(name = "DPforAssessment1")
	
	public static String[][] dpForTest001() throws IOException{
		
		 String[][] testdata;
		
		FileInputStream temp = new FileInputStream("./TestDataForAssm1/Testcase001.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(temp);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		testdata = new String[rowcount][columncount];
		for (int i=1; i<= rowcount; i++){
			XSSFRow row = sheet.getRow(i);
			System.out.println("The value of row is "+i+" :" +row);
			for(int j=0; j<columncount; j++){
				String cellvalue = row.getCell(j).getStringCellValue();
				System.out.println("The value of cell "+j+" :" +cellvalue);
				testdata[i-1][j] = cellvalue;
			}
		}
		
		return testdata;
		
	}

}
