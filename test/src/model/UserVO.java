package model;

public class UserVO {
	
	private String user_no;
	private String user_id;
	
	public UserVO (String user_no, String user_id) {
		this.user_no = user_no;
		this.user_id = user_id;
	}

	public String getUser_no() {
		return user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	

}
