package selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {

	public static void main(String[] args) throws IOException {
        //secified file location
		File src = new File("C:\\Selenium\\Demo.xlsx");
		//load the file
		FileInputStream fis= new FileInputStream(src);
		//Load the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//Load Worksheet
		XSSFSheet sh=wb.getSheet("DemoSheet");
		
		System.out.println("Sheet Name:"+sh.getSheetName());
		System.out.println("Printing total no of rows:"+sh.getPhysicalNumberOfRows());
		System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sh.getLastRowNum());
		System.out.println(sh.getFirstRowNum());
		
		System.out.println("Total no of columns:"+sh.getRow(0).getPhysicalNumberOfCells());
		System.out.println("Total no of columns:"+sh.getRow(0).getLastCellNum());
		
		int totalRows=sh.getPhysicalNumberOfRows();
		int totalCol=sh.getRow(0).getPhysicalNumberOfCells();
		
		for (int i=0;i<totalRows;i++) {
			for( int j=0;j<totalCol;j++) {
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		  
	}

}
