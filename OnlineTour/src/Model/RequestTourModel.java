package Model;

public class RequestTourModel 
{
	private String image,sname,tourname,place,city,pincode,day,hname,haddress,hpincode,hotel_manager_name,hphone,describeTour;
	private float price;
	private int agent_id,req_id,id;
	public RequestTourModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestTourModel(String image,String sname, String tourname, String place, String city, String pincode, String day,
			String hname, String haddress, String hpincode, String hotel_manager_name, String hphone,
			String describeTour, float price, int agent_id,int req_id, int id) {
		super();
		this.image= image;
		this.sname = sname;
		this.tourname = tourname;
		this.place = place;
		this.city = city;
		this.pincode = pincode;
		this.day = day;
		this.hname = hname;
		this.haddress = haddress;
		this.hpincode = hpincode;
		this.hotel_manager_name = hotel_manager_name;
		this.hphone = hphone;
		this.describeTour = describeTour;
		this.price = price;
		this.agent_id = agent_id;
		this.req_id = req_id;
		this.id = id;//tour_id
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTourname() {
		return tourname;
	}
	public void setTourname(String tourname) {
		this.tourname = tourname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHaddress() {
		return haddress;
	}
	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}
	public String getHpincode() {
		return hpincode;
	}
	public void setHpincode(String hpincode) {
		this.hpincode = hpincode;
	}
	public String getHotel_manager_name() {
		return hotel_manager_name;
	}
	public void setHotel_manager_name(String hotel_manager_name) {
		this.hotel_manager_name = hotel_manager_name;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getDescribeTour() {
		return describeTour;
	}
	public void setDescribeTour(String describeTour) {
		this.describeTour = describeTour;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
