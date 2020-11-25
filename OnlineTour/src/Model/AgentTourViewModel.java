package Model;

public class AgentTourViewModel
{
	int id,tour_id;
	float price;
	String name,shop_name,email,phone,shop_address,image,tour_name,place,city,pincode,day,hotel_name,hotel_address,hotel_pincode,hotel_manager,hotel_phone,description;
	public AgentTourViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentTourViewModel(int id, int tour_id, float price, String name, String shop_name, String email,
			String phone, String shop_address, String image, String tour_name, String place, String city,
			String pincode, String day, String hotel_name, String hotel_address, String hotel_pincode,
			String hotel_manager, String hotel_phone, String description) {
		super();
		this.id = id;
		this.tour_id = tour_id;
		this.price = price;
		this.name = name;
		this.shop_name = shop_name;
		this.email = email;
		this.phone = phone;
		this.shop_address = shop_address;
		this.image = image;
		this.tour_name = tour_name;
		this.place = place;
		this.city = city;
		this.pincode = pincode;
		this.day = day;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_pincode = hotel_pincode;
		this.hotel_manager = hotel_manager;
		this.hotel_phone = hotel_phone;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTour_name() {
		return tour_name;
	}
	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
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
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_pincode() {
		return hotel_pincode;
	}
	public void setHotel_pincode(String hotel_pincode) {
		this.hotel_pincode = hotel_pincode;
	}
	public String getHotel_manager() {
		return hotel_manager;
	}
	public void setHotel_manager(String hotel_manager) {
		this.hotel_manager = hotel_manager;
	}
	public String getHotel_phone() {
		return hotel_phone;
	}
	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
