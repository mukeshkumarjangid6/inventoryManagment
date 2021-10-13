package kiranaStore.inventoryManagment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kiranaStore.inventoryManagment.dao.CustomerDao;
import kiranaStore.inventoryManagment.daoImpl.CustomerDaoImpl;
import kiranaStore.inventoryManagment.dto.Customer;

public class CustomerTest {
	CustomerDao customerDao;

	@Before
	public void setUp() {
		customerDao = new CustomerDaoImpl();
	}

	// @Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustomerage(31);
		customer.setCustomerId(3);
		customer.setCustomerName("Kalpana");
		customer.setCustomerphone("8855669977");
		Assert.assertTrue(customerDao.add(customer));
	}

	@Test
	public void testSearchById() {
		// Customer customer = customerDao.searchById(1);
		Assert.assertNotNull(customerDao.searchById(2));
		// Assert.assertEquals(customer, customerDao.searchById(1));

	}

	@Test
	public void testCustomerList() {
		Assert.assertTrue(customerDao.customersList().size() > 0);
	}
}