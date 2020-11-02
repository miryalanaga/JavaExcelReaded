package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ReadExcelData {
    public static void main(String args[]) throws Exception {
        FileInputStream fis = new FileInputStream("/Start.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Credentials");
        XSSFRow row = sheet.getRow(0);
        Map<Date, List<String>> data = new HashMap<>();

        int user_col_num = -1;
        int pass_col_num = -1;
        int noOfRows = row.getLastCellNum();
        int noOfColNum = 0;

        for (int i = 0; i < noOfRows; i++) {
            if (row.getCell(i).getStringCellValue().trim().equals("DateCreated")) {
                user_col_num = i;
            }
            if (row.getCell(i).getStringCellValue().trim().equals("PassWord")) {
                pass_col_num = i;
            }
            noOfColNum = i;
        }
        XSSFRow selectedRow = sheet.getRow(noOfColNum);
        for (int r = 1; r <= selectedRow.getLastCellNum(); r++) {
            row = sheet.getRow(r);
            XSSFCell user_cell = row.getCell(user_col_num);
            XSSFCell pass_cell = row.getCell(pass_col_num);

            Date user_value = user_cell.getDateCellValue();
            String pass_value = pass_cell.getStringCellValue();
            if (data.containsKey(user_value)) {
                data.get(user_value).add(pass_value);
            } else {
                List<String> pass = new ArrayList<>();
                pass.add(pass_value);
                data.put(user_value, pass);
            }
        }
        System.out.println(data);
    }
}
