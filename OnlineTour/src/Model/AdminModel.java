package Model;

public class AdminModel {
	private String admin_email,admin_password;

	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String admin_email, String admin_password) {
		super();
		this.admin_email = admin_email;
		this.admin_password = admin_password;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	

}
