package Model;

public class BookingModel {
	
	private int booking_id,tour_id,userId,total_member,child,adult,citizen;

	public BookingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingModel(int booking_id, int tour_id, int userId, int total_member, int child, int adult, int citizen) {
		super();
		this.booking_id = booking_id;
		this.tour_id = tour_id;
		this.userId = userId;
		this.total_member = total_member;
		this.child = child;
		this.adult = adult;
		this.citizen = citizen;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getTour_id() {
		return tour_id;
	}

	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotal_member() {
		return total_member;
	}

	public void setTotal_member(int total_member) {
		this.total_member = total_member;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getCitizen() {
		return citizen;
	}

	public void setCitizen(int citizen) {
		this.citizen = citizen;
	}
	
	

}
