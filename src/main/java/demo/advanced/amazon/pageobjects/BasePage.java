package demo.advanced.amazon.pageobjects;

import demo.advanced.helpers.ExcelHelper;

public abstract class BasePage {

	public boolean isPageLoaded() {
		boolean isLoaded = false;

		return isLoaded;
	}
	
	public String getXPath(String webElementName) {
		String sheetName = this.getClass().getSimpleName();
		String excelPath = "./resources/testdata/XPathWorkbook.xlsx";
		 String xPath = ExcelHelper.getXPathFromExcel(excelPath, sheetName,"WebElementName",webElementName);
		return xPath;
	}

}
