package university;

import data.Order;

public class TechSupportGuyController {
	private TechSupportGuy techSupportGuy;
	
	public TechSupportGuyController(TechSupportGuy techSupportGuy) {
		this.techSupportGuy = techSupportGuy;
	}
	
	public void techSupportGuyUserInterface() {
		String selection = "";
		while (!selection.equals("Quit")) {
			UniversitySystem.printConsole("1. Manage orders\n2. View List Of New Orders" +
					"\n3. View List of Accepted Orders\n4. Quit");
			selection = UniversitySystem.getConsoleInput();
			switch (selection) {
				case "1":
					manageOrders();
					break;
				case "2":
					printNewOrders();
					break;
				case "3":
					printAcceptedOrders();
					break;
				case "4":
					selection = "Quit";
					break;
			}
		}
	}
	
	private void manageOrders() {
		System.out.println("Choose the Order number:");
		UniversitySystem.printList(techSupportGuy.viewNewOrders());
		int selection = Integer.parseInt(UniversitySystem.getConsoleInput()) - 1;
		Order o = techSupportGuy.viewNewOrders().get(selection);
		System.out.println("1. Accept Order\n2. Decline Order");
		String in = UniversitySystem.getConsoleInput();
		if (in.equals("1")) 
			techSupportGuy.acceptOrder(o);
		else if (in.equals("2"))
			techSupportGuy.declineOrder(o);
	}
	
	private void printNewOrders() {
		UniversitySystem.printList(techSupportGuy.viewNewOrders());
	}
	
	private void printAcceptedOrders() {
		UniversitySystem.printList(techSupportGuy.viewAcceptedOrders());
	}
}
