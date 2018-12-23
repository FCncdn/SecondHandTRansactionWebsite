package Backend.db;

import java.sql.*;

public class MySQLDemo {
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jc.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/System?serverTimezone=GMT%2B8&characterEncoding=utf8";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "fcncdn";
    
    Connection conn=null;
    Statement stmt=null;
    final String tableName="user";
    ResultSet rs; 
	String sql;

    public MySQLDemo() {
    }
    
    public void open() {
    	try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("\n连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
    public void search(String columnName,String columeValue) {

    	try{
            sql = "SELECT * FROM "+tableName+" where "+columnName+"='"+columeValue+"'";
            rs = stmt.executeQuery(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void search(String columnName,int columeValue) {
    	try{
            sql = "SELECT * FROM "+tableName+" where "+columnName+"="+columeValue;
            rs = stmt.executeQuery(sql);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public String show(String columeName) {
    	String result="don't exist";
    	try {
    		rs.next();
			return rs.getString(columeName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return result;
    }
    public void update(String updateIndex,String updateValue,String searchIndex,String searchValue) {
    	sql="update "+tableName+" set "+updateIndex+" = '"+updateValue+"' where "+searchIndex+" = '"+searchValue+"'";
    	try {
    		stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void update(String updateIndex,String updateValue,String searchIndex,int searchValue) {
    	sql="update "+tableName+" set "+updateIndex+" = '"+updateValue+"' where "+searchIndex+" = "+searchValue;
    	try {
    		stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public int getRowNum() {
    	String sql;
    	int count=0;
    	try {
    		sql = "SELECT * FROM "+tableName;
    		rs = stmt.executeQuery(sql);
			while(rs.next()){
			    count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return count;
    }
    public void printAll() {
    	String sql;
    	try {
    		sql = "SELECT * FROM "+tableName;
    		rs = stmt.executeQuery(sql);
			while(rs.next()){
			    // 通过字段检索
			    int id  = rs.getInt("userid");
			    String name = rs.getString("username");
			    String nickname = rs.getString("nickname");
			    String power = rs.getString("power");
			    String state = rs.getString("state");
			    System.out.print(id);
			    System.out.print(",  " +name);
			    System.out.print(",  " +nickname);
			    System.out.print(",  " +power);
			    System.out.print(",  " +state);
			    System.out.print("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void close() {
    	try {
    		if (stmt!=null)
    		stmt.close();
    		if (conn!=null)
            conn.close();
    		if(rs!=null)
            rs.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        System.out.println("\nGoodbye!");
    }
	
    
}
