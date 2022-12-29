package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * This class used to read & write the data from property file
 * @author Rakesh
 */
public class ExcelFileUtil {
	public static HSSFWorkbook workbook;
	 public static HSSFSheet worksheet;
	 public static DataFormatter formatter= new DataFormatter();
	 
	 /**
     * Use this method to read data from excel sheet and file path are taken from FilePaths interface
     *
     * @param sheetName
     * @param rowNo
     * @param cellNo
     * @return Excel cell value in string
     */
	
	
	 
    public static String getExcelData(String sheetName, int rowNo, int cellNo) {
        try {
            FileInputStream file = new FileInputStream("");
            Workbook workbook = WorkbookFactory.create(file);
            return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method read data based on testcase id and the column name/test data cell
     *
     * @param sheetName
     * @param testcaseID
     * @param columnName
     * @return Cell String value
     */
    public static String getExcelData(String sheetName, String testcaseID, String columnName) {
        
        try {
            FileInputStream file = new FileInputStream("");
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();
            int testRow = 0;
            for (int i = 0; i <= lastRow; i++) {
                try {
                    String testcaseNum = sheet.getRow(i).getCell(0).getStringCellValue();
                    if (testcaseNum.equalsIgnoreCase(testcaseID)) {
                        testRow = i;
                        break;
                    }
                } catch (NullPointerException e) {

                }
            }
            int lastCell = sheet.getRow(testRow - 1).getLastCellNum();
            int testcell = 0;
            for (int i = 0; i <= lastCell; i++) {
                try {
                    String cellData = sheet.getRow(testRow - 1).getCell(i).getStringCellValue();
                    if (cellData.equalsIgnoreCase(columnName)) {
                        testcell = i;
                        break;
                    }
                } catch (NullPointerException e) {
                }
            }
            return getExcelData(sheetName, testRow, testcell);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "No Data found";
    }

    /**
     * Method used to write data into excel sheet
     *
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @param cellValue
     */
    public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String cellValue) {
       
        try {
            FileInputStream file = new FileInputStream("");
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            sheet.createRow(rowNum).createCell(cellNum).setCellValue(cellValue);
            FileOutputStream fileOut = new FileOutputStream("");
            workbook.write(fileOut);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Data provider used for 1 product
     *
     * 
     */
    @DataProvider(name="ReadVariant1")
	public static Object[][] ReadVariant() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream("./src/main/resources/TestData.xls"); //Excel sheet file location get mentioned here
	 HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
	  worksheet = workbook.getSheet("Sheet1");// get my sheet from workbook
	       HSSFRow Row=worksheet.getRow(0);   //get my Row which start from 0   
	   
	    	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	    	int ColNum= Row.getLastCellNum(); // get last ColNum 
	    	
	    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	    	
	     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	     {  
	     HSSFRow row= worksheet.getRow(i+1);
	     
	     for (int j=0; j<ColNum; j++) //Loop work for colNum
	     {
	     if(row==null)
	     Data[i][j]= "";
	     else 
	     {
	     HSSFCell cell= row.getCell(j);
	     if(cell==null)
	     Data[i][j]= ""; //if it get Null value it pass no data 
	     else
	     {
	     String value=formatter.formatCellValue(cell);
	     Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	     }
	     }
	     }
	     }
	 
	    	return Data;
	    }
    /**
     * Data provider used for 1 product
     *
     * 
     */
    @DataProvider(name="ReadVariant2")
	public static Object[][] ReadVariant2() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream("./src/main/resources/TestData.xls"); //Excel sheet file location get mentioned here
	 HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
	  worksheet = workbook.getSheet("Sheet3");// get my sheet from workbook
	       HSSFRow Row=worksheet.getRow(0);   //get my Row which start from 0   
	   
	    	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	    	int ColNum= Row.getLastCellNum(); // get last ColNum 
	    	
	    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	    	
	     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	     {  
	     HSSFRow row= worksheet.getRow(i+1);
	     
	     for (int j=0; j<ColNum; j++) //Loop work for colNum
	     {
	     if(row==null)
	     Data[i][j]= "";
	     else 
	     {
	     HSSFCell cell= row.getCell(j);
	     if(cell==null)
	     Data[i][j]= ""; //if it get Null value it pass no data 
	     else
	     {
	     String value=formatter.formatCellValue(cell);
	     Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	     }
	     }
	     }
	     }
	 
	    	return Data;
	    }
}
