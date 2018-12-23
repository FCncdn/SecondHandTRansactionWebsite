package Backend.db;

public class test {
	public static void main(String args[]) {
		MySQLDemo mysql=new MySQLDemo();
		mysql.open();
//		mysql.search("username","小神");
//		String s=mysql.show("power");
////		mysql.update("power", "哈哈哈","username","小神" );
//		mysql.printAll();
		int a=mysql.getRowNum();
		mysql.close();
		System.out.println(a);
	}
}
