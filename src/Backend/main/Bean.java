package Backend.main;

//import com.runoob.db.MySQLDemo;

import Backend.db.MySQLDemo;

public class Bean {
	private int userid=0;
    private String userName=null;
    private String nickName=null;
	private String power=null;
	private String state=null;
	MySQLDemo mysql=new MySQLDemo();
	public Bean(){
	}
	public int getRowNum() {
		int t=mysql.getRowNum();
		return t;
	}
	public void open() {
		mysql.open();
	}
	public void close() {
		mysql.close();
	}
	public void setIndex(int index){
		userid=index;
		mysql.search("iduser",index);
		userName=mysql.show("userName");
		mysql.search("iduser",index);
		nickName=mysql.show("nickname");
		mysql.search("iduser",index);
		power=mysql.show("power");
		mysql.search("iduser",index);
		state=mysql.show("state");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserid() {
		return userid;
	}
	   
	   
}
