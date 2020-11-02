package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelDemo
{
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Start.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet wbs = wb.getSheet("");
        XSSFRow wbr = wbs.getRow(0);
        XSSFCell wbc = wbr.getCell(3);

        String value = wbc.getStringCellValue();
        System.out.println(value);

    }
}
