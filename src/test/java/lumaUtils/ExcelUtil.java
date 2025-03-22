package lumaUtils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private Workbook workbook;

    public ExcelUtil(String filePath) {
        try {
//        	System.out.println("Loading excel from "+filePath);
            FileInputStream file = new FileInputStream("C:\\Users\\Dinesh\\OneDrive\\Documents\\Desktop\\loginDataExcel.xlsx");
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
        	throw new RuntimeException("Error loading Excel file: " + e.getMessage());
        }
    }

    public String getCellData(String sheetName, int row, int col) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet != null) {
            Row sheetRow = sheet.getRow(row);
            if (sheetRow != null) {
                Cell cell = sheetRow.getCell(col);
                if (cell != null) {
                    return cell.toString();
                }
            }
        }
        return "";
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return (sheet != null) ? sheet.getLastRowNum() : 0;
    }
}





































//package lumaUtils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.File;
//import java.io.FileInputStream;
//
//public class ExcelUtil {
//    public static Object[][] getExcelData(String filePath, String sheetName) {
//        Object[][] data = null;
//        try {
//            FileInputStream fis = new FileInputStream(new File(filePath));
//            Workbook workbook = new XSSFWorkbook(fis);
//            Sheet sheet = workbook.getSheet(sheetName);
//            int rowCount = sheet.getPhysicalNumberOfRows();
//            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//            data = new Object[rowCount - 1][colCount];
//            for (int i = 1; i < rowCount; i++) {
//                Row row = sheet.getRow(i);
//                for (int j = 0; j < colCount; j++) {
//                    Cell cell = row.getCell(j);
//                    data[i - 1][j] = cell.getStringCellValue();
//                }
//            }
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//}