package Model;
import java.util.Random;

public class AgentModel {
	private String name,email,password,sname,saddress,sphoto,phone;
	private int age;
	private int id=new Random().nextInt(100);
	public AgentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentModel(String name, String email, String password, String sname, String saddress, String sphoto,
			String phone, int age, int id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.sname = sname;
		this.saddress = saddress;
		this.sphoto = sphoto;
		this.phone = phone;
		this.age = age;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSphoto() {
		return sphoto;
	}
	public void setSphoto(String sphoto) {
		this.sphoto = sphoto;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	 

}
