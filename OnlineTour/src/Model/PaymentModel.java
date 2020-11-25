package Model;

public class PaymentModel {
	private int payId,	userId,tourId;
	private float amount;
	private String paymentType;
	public PaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentModel(int payId, int userId, int tourId, float amount, String paymentType) {
		super();
		this.payId = payId;
		this.userId = userId;
		this.tourId = tourId;
		this.amount = amount;
		this.paymentType = paymentType;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	

}
