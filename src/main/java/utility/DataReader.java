package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Imdadul Hoq
 *
 */

public class DataReader {
    XSSFWorkbook wb = null;
    XSSFSheet sheet = null;
    Cell cell = null;
    FileOutputStream fio = null;
    int numberOfRows, numberOfCol, rowNum;


    public String[][] fileReader1(String path) throws IOException {
        String[][] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        DataFormatter formatter = new DataFormatter();
        data = new String[numberOfRows+1][numberOfCol];
        for (int i = 1; i < data.length; i++) {
            XSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                XSSFCell cell = rows.getCell(j);
                data[i-1][j]= formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
