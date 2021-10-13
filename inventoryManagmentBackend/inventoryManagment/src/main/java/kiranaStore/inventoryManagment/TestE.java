package kiranaStore.inventoryManagment;

import java.util.List;
import java.util.Scanner;

import kiranaStore.inventoryManagment.dao.CustomerDao;
import kiranaStore.inventoryManagment.dao.EmployeeDao;
import kiranaStore.inventoryManagment.dao.OrderDao;
import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.daoImpl.CustomerDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.EmployeeDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.OrderDaoImpl;
import kiranaStore.inventoryManagment.daoImpl.ProductDaoImpl;
import kiranaStore.inventoryManagment.dto.Customer;
import kiranaStore.inventoryManagment.dto.Employee;
import kiranaStore.inventoryManagment.dto.Order;
import kiranaStore.inventoryManagment.dto.Product;

public class TestE {
	CustomerDao customerDao = new CustomerDaoImpl();
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	ProductDao productDao = new ProductDaoImpl();

	Customer customer;
	Employee employee = new Employee();
	Product product = new Product();
	Order order = new Order();
	Scanner sc = new Scanner(System.in);

	public TestE() {
		customerDao = new CustomerDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		orderDao = new OrderDaoImpl();
		productDao = new ProductDaoImpl();

		customer = new Customer();
		employee = new Employee();
		product = new Product();
		order = new Order();
	}

	public void addCustomer() {
		Customer customer = new Customer();
		customer.setCustomerage(29);
		customer.setCustomerId(1);
		customer.setCustomerName("Rohit");
		customer.setCustomerphone("8855669977");
		System.out.println(customerDao.add(customer));

		customer = new Customer();
		customer.setCustomerage(25);
		customer.setCustomerId(2);
		customer.setCustomerName("Komal");
		customer.setCustomerphone("7788554466");
		System.out.println(customerDao.add(customer));
	}

	public void displayCustomer(Integer customerId) {
		customer = customerDao.searchById(customerId);
		System.out.println(customer);
	}

	public void displayCustomers() {
		List<Customer> list = customerDao.customersList();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

	public void addEmployee(Employee employee) {
		employee.setEmployeeId(1);
		employee.setEmloyeeName("E1");
		employee.setSalary(25000);
		employee.setJobTitle("Sales Person");
		System.out.println(employeeDao.add(employee));

	}

	public void displayEmployee(Integer employeeId) {
		employee = employeeDao.searchById(employeeId);
		System.out.println(employee);
	}

	public void displayEmployees() {
		List<Employee> list = employeeDao.employeesList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void addProduct() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mi 8");
		product.setProductPrice(15000);
		product.setProductAvailability(10);
		System.out.println(productDao.add(product));

		product = new Product();
		product.setProductId(2);
		product.setProductName("Iphone 12");
		product.setProductPrice(80000);
		product.setProductAvailability(5);
		System.out.println(productDao.add(product));
	}

	public void displayProduct(Integer productId) {
		product = productDao.searchById(productId);
		System.out.println(product);
	}

	public void displayProducts() {
		List<Product> list = productDao.productsList();
		for (Product product : list) {
			System.out.println(product);
		}
	}

	public void addOrder(Integer productId, Integer customerId, Integer orderQuantity) {
		order = new Order();
		order.setCustomerId(customerId);
		order.setEmployeeId(1);
		order.setOrderDate(null);
		order.setProductId(productId);
		order.setOrderQuantity(orderQuantity);
		Integer totalPrice = (order.getOrderQuantity() * productDao.searchById(productId).getProductPrice());
		order.setTotalPrice(totalPrice);
		System.out.println(orderDao.add(order));

	}

	public void displayOrder(Integer orderId) {

	}

	public void displayOrders() {

	}
}