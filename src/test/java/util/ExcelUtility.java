package util;
 import Models.Buy;
 import Models.Login;
 import Models.Search;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

 import java.io.File;
 import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ExcelUtility {

	static 	HSSFWorkbook  ObjWorkBook;
	static HSSFSheet sheet;
	public static FileInputStream fis;
	static  String sheetname;
	static public Map<String, Login> loginMap = new HashMap<>();
	static public Map<String, Search>   searchMap = new HashMap<>();
	static public Map<String, Buy>    buyMap = new HashMap<>();


	public static void CreateDatabase(){

		try {
            String basePath = null;
            String path;
            try {
                File currentDir = new File(".");
                basePath = currentDir.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            path = basePath + "/src/test/resources/RegressionTestSuite.xls";
			 readWorkBook(path);
			readLoginSheet("Login");
			readProductName("Search");
            readBuySheet("Buy");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readWorkBook(String path ) throws IOException {

		try {

			fis = new FileInputStream(path);

			if (fis != null) {
				ObjWorkBook = new HSSFWorkbook(fis);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);

		}
	}

	public static void readProductName(String sheetname) throws IOException {

		if (ObjWorkBook != null) {
			sheet = ObjWorkBook.getSheet(sheetname.trim());

			if (sheet.getRow(1) != null) {
				Row row = sheet.getRow(1);
				searchMap.put(sheetname, buildProductData(row));
			}
		}
	}
	public static void readLoginSheet(String sheetname) throws IOException {

		if (ObjWorkBook != null) {
			sheet = ObjWorkBook.getSheet(sheetname.trim());

			if (sheet.getRow(1) != null) {
				Row row = sheet.getRow(1);
				loginMap.put(sheetname, buildLoginData(row));
			}
		}
	}


	public static void readBuySheet(String sheetname  ) throws IOException {

		if (ObjWorkBook != null) {

			sheet = ObjWorkBook.getSheet(sheetname.trim());
			if (sheet.getRow(1) != null) {
				Row row = sheet.getRow(1);
				buyMap.put(sheetname, buildCheckout(row));

			}
		}
	}


	public static Login buildLoginData(Row row){

		Login login = new Login();
		Cell cell0 = row.getCell(0);
		Cell cell1 = row.getCell(1);
		login.setUsername(cell0.toString());
		login.setPassword(cell1.toString());
		return login;
	}
	public static Search buildProductData(Row row){

		Search productData = new Search();
		Cell cell0 = row.getCell(0);
		productData.setSearchtext(cell0.toString());
		return productData;
	}

	public static Buy buildCheckout(Row row){
		Buy buy = new Buy();
		Cell cell0 = row.getCell(0);
		Cell cell1 = row.getCell(1);
		Cell cell2 = row.getCell(2);
		buy.setCardName(cell0.toString());
		buy.setCardNumber(cell1.toString());
		buy.setcvc(cell2.toString());
		return buy;
	}



}		

		