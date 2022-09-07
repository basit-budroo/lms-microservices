package org.lms.bean;

public class User {
	private String email;
	private String password;
	private int employeeId;
	private short type;

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public User(String email, String pass) {
		super();
		this.email = email;
		this.password = pass;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", employeeId=" + employeeId + ", type=" + type
				+ "]";
	}

}
