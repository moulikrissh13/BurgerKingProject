package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./TestData.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		String data = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		return data;
	}
}
