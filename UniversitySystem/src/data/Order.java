package data;

import java.io.IOException;
import java.time.LocalDateTime;

import enumerations.OrderStatus;
import university.UniversitySystem;
import university.User;

public class Order extends Message {
	private OrderStatus orderStatus;
	private LocalDateTime time;
	
	protected Order(User from, User to, String text) {
		super(from, to, text);
		this.orderStatus = OrderStatus.PENDING;
		this.time = UniversitySystem.getCurrentTime();
	}
	
	public OrderStatus orderStatus() {
		return orderStatus;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String toString() {
		return super.toString() + "\n" + orderStatus + "\n" + UniversitySystem.getFormatter().format(time);
	}
}
