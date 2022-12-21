package demo.advanced.helpers;

import java.util.*;
import java.io.*;
import java.lang.Object;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class ExcelHelper {

	static XSSFWorkbook workbook = new XSSFWorkbook();

	// Create a blank sheet
	static XSSFSheet sheet = workbook.createSheet("Mobile Data");

	public static void writeExcelData(Map<Integer, Object[]> data) {
		// This data needs to be written (Object[])

		// Iterate over data and write to sheet
		Set<Integer> keyset = data.keySet();
		int rownum = 0;
		for (Integer key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);

				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("Mobiles.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Mobiles.xlsx written successfully on disk.");
		} catch (Exception e) {

			System.out.println("Mobiles.xlsx Can not be written.");
			e.printStackTrace();
		}
	}

	public static void readExcelData(String workBookPath, String sheetName, String webElementName) {
		try {
			FileInputStream file = new FileInputStream(new File(workBookPath));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "t");
						break;
					}
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getXPathFromExcel(String workBookPath, String sheetName, String colName,
			String webElementName) {
		String xpath = "";
		try {
			FileInputStream file = new FileInputStream(new File(workBookPath));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			int colNum = -1;
			int rowNum = -1;
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row row;

			// 1. column index of column where webelements name is stored : C or 2 : colNum
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				{
					colNum = i;
					break;
				}
			}

			// 2. get the index of webelement name in the column recieved from previous step
			// [ which is in this case C or 2 ] colNum
			// 3. we located the webelement name's cell [in this case its 2,2 (rowNum,
			// colNum)]
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);

				// find the cell index which have webElementName
				for (int rowCounter = 0; rowCounter < row.getLastCellNum(); rowCounter++) {
					if (row.getCell(rowCounter).getStringCellValue().trim().equals(webElementName.trim()))
						rowNum = rowCounter;
				}
			}

			// 4. we are going to get the value using using index in step 3 [which is
			// (2,2+1) (rowNum, colNum+1) ]

			xpath = sheet.getRow(rowNum).getCell(colNum + 1).getStringCellValue();

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xpath;
	}

}
