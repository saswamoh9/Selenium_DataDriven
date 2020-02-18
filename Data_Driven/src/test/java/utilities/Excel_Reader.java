package utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	
	public  FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	
	
	public Excel_Reader(String path) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
	}
	
	/**************************************
	 * Excel function to read the Module Wise List of Test Cases
	 * @param sheetn
	 * @param row
	 * @param col
	 * @return
	 */
	public Map<String, String> getTestCaseList(String moduleName)
	{
		return null;
		
	}
	
	/*public Map<String, Integer> getLastRowLastCol(String Sheetname, int startRowNum){
		sheet = workbook.getSheet(Sheetname);
		int row_num = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(startRowNum);
		int col_num = row.getLastCellNum();
		
		Map<String, Integer> row_col = new HashMap<>();
		row_col.put("LastRow", row_num);
		row_col.put("LastCol", col_num);
		row_col.put("StartRow", startRowNum);
		System.out.println(row_col);
		return row_col;
	}*/
	
	
	public String[][] getSheetData(String sheetName, int startrow)
	{

	    String value ="";
	    String[][] data = null;
	    


	    int rowCount = workbook.getSheet(sheetName).getLastRowNum()+1;
	    
	    int colCount = workbook.getSheet(sheetName).getRow(startrow).getLastCellNum();
	    
	    data = new String[rowCount][colCount];

	    for(int i=1; i<rowCount;i++)
	    {           
	    	
	        Row row = workbook.getSheet(sheetName).getRow(i);
	        for(int j=0;j<colCount;j++)
	        {


	            Cell cell = row.getCell(j);
	            if(cell.getCellType()==cell.getCellType().NUMERIC)
	            {
	                value = ""+cell.getStringCellValue();
	            }
	            else
	            {
	                value = cell.getStringCellValue();
	            }
	            data[i][j] = value;
	            


	        }
	    }
	    return data;

	}
	
	
	
}
