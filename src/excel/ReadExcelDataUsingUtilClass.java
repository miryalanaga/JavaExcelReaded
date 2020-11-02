package excel;

public class ReadExcelDataUsingUtilClass
{

    public static void main(String args[]) throws Exception
    {
        ExcelApiTest eat = new ExcelApiTest("/Start.xlsx");
        System.out.println(eat.getCellData("Credentials",0,2));
        System.out.println(eat.getCellData("Credentials",1,2));
        System.out.println(eat.getCellData("Credentials",2,2));
        System.out.println(eat.getCellData("Credentials",3,2));

        System.out.println(eat.getCellData("Credentials","UserName",2));
        System.out.println(eat.getCellData("Credentials","PassWord",2));
        System.out.println(eat.getCellData("Credentials","DateCreated",2));
        System.out.println(eat.getCellData("Credentials","NoOfAttempts",2));
    }
}
