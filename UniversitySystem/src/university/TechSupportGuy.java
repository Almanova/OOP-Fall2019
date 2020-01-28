package university;

import java.util.ArrayList;

import data.Order;
import enumerations.OrderStatus;

public class TechSupportGuy extends Employee {
	private ArrayList<Order> newOrders;
	private ArrayList<Order> acceptedOrders;
	
	public TechSupportGuy(String id, String firstName, String lastName, String login,
			String password, double salary) {
		super(id, firstName, lastName, login, password, salary);
		newOrders = new ArrayList<Order>();
		acceptedOrders = new ArrayList<Order>();
	}
	
	public boolean recieveOrder(Order order) {
		return newOrders.add(order);
	}
	
	public void acceptOrder(Order order) {
		order.setOrderStatus(OrderStatus.ACCEPTED);
		acceptedOrders.add(order);
		newOrders.remove(order);
	}
	
	public void declineOrder(Order order) {
		order.setOrderStatus(OrderStatus.DECLINED);
		newOrders.remove(order);
	}
	
	public ArrayList<Order> viewNewOrders() {
		return newOrders;
	}
	
	public ArrayList<Order> viewAcceptedOrders() {
		return acceptedOrders;
	}

	@Override
	public void updateUser() {
		UserFactory.updateEmployee(this);
	}
	
	@Override 
	public boolean equals(Object object) {
		return super.equals(object);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public void userInterface() {
		TechSupportGuyController tsgc = new TechSupportGuyController(this);
		tsgc.techSupportGuyUserInterface();
	}
}
