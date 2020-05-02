package dataproviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FlightDataprovider {
	
	@DataProvider(name="FlightData")
	public Object[][] getTestData(Method m) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\Flight.xlsx");
		System.out.println(m.getName());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Test_Data");
		fis.close();
		int start_row=0, end_row=0;
		
		String value ="";
	    Object[][] data = null;
		
		int row_num = (sheet.getLastRowNum());
		System.out.println("Lastrow="+row_num);
		for(int i=0;i<=row_num;i++)
		{
			
			if(m.getName().equals(sheet.getRow(i).getCell(0).toString()))
			{
				start_row=i+2;
				break;
			}
		}
		System.out.println("Start Row ="+start_row);
		int last_col = sheet.getRow(start_row).getLastCellNum();
		System.out.println("Last Coloumn"+last_col);
		for(int i= start_row;i<=row_num;i++)
		{
			if(sheet.getRow(i).getCell(0).toString().startsWith("TS"))
			{
				end_row=i-1;
				break;
			}
			else
			{
				end_row=row_num;
			}
		}
		System.out.println("End Row="+end_row);
		data = new Object[(end_row-start_row)+1][last_col];
		for(int i=0;i<(end_row-start_row)+1;i++)
		{
			Row row = sheet.getRow(start_row);
			for(int j=0; j<last_col;j++)
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
			start_row++;
		}
		return data;
		
	}
}
