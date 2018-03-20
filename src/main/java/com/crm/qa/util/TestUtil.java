package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String filesrc = "src/main/java/com/crm/qa/testdata/FreeCRMTestData.xls";
	public static String sheetName = "contacts";

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static String[][] getDataFromExcel() throws BiffException, IOException {

		Workbook workbook = Workbook.getWorkbook(new File(filesrc));

		Sheet sheet = workbook.getSheet(sheetName);

		int rCount = sheet.getRows();
		int cCount = sheet.getColumns();

		String data[][] = new String[rCount - 1][cCount];

		for (int rows = 1; rows < rCount; rows++) {

			for (int columns = 0; columns < cCount; columns++) {
				data[rows - 1][columns] = sheet.getCell(columns, rows).getContents();
			}
		}

		return data;
	}
	
	public void takeScreenShotAtEndOfTest() throws IOException{
		
	}

	
	
}
