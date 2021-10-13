package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Employee;

public interface EmployeeDao {
	public Boolean add(Employee employee);

	public Boolean update(Employee employee);

	public Boolean delete(Integer employeeId);

	public Employee searchById(Integer employeeId);

	public List<Employee> employeesList();
}