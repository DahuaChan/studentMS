package cn.cdh.studentMS.model;

public class Student {
	private int stu_id;
	private String stu_name;
	private String stu_password;
	private int sub_id;
	private int maj_id;
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getMaj_id() {
		return maj_id;
	}
	public void setMaj_id(int maj_id) {
		this.maj_id = maj_id;
	}
	
	
}
