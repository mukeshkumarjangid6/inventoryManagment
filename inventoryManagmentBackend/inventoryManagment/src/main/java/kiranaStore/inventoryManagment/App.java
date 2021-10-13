package kiranaStore.inventoryManagment;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		TestE test = new TestE();
		Scanner sc = new Scanner(System.in);
		System.out.println("Press\n1. Add Customer\n2. Display customer by Id\n3. Display CustomerList");
		System.out.println("Press\n4. Add Employee\n5. Display Employee by Id\n6. Display EmployeeList");
		System.out.println("Press\n7. Add Product\n8. Display Product by Id\n9. Display ProductList");
		System.out.println("Press\n10. Add Order\n11. Display Order by Id\n12. Display OrderList");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			test.addCustomer();
			break;
		case 2:
			Integer customerId = sc.nextInt();
			test.displayCustomer(customerId);
			break;
		default:
			break;
		}
	}
}