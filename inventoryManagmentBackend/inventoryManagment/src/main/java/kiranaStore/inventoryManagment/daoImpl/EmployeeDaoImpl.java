package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.EmployeeDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private DbConfig dbConfig;
	private PreparedStatement stmt;

	public EmployeeDaoImpl() {
		dbConfig = DbConfig.getDbConfig();
	}

	@Override
	public Boolean add(Employee employee) {
		try {
			stmt = dbConfig.getCon().prepareStatement(
					"INSERT INTO Employee (employeeId, emloyeeName,salary, jobTitle)VALUES (?,?,?,?);");
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getEmloyeeName());
			stmt.setInt(3, employee.getSalary());
			stmt.setString(4, employee.getJobTitle());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean update(Employee employee) {
		try {
			stmt = dbConfig.getCon()
					.prepareStatement("UPDATE Employee SET emloyeeName=?,salary=?, jobTitle=? WHERE employeeId=?");
			stmt.setString(1, employee.getEmloyeeName());
			stmt.setInt(2, employee.getSalary());
			stmt.setString(3, employee.getJobTitle());
			stmt.setInt(4, employee.getEmployeeId());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(Integer employeeId) {
		try {
			stmt = dbConfig.getCon().prepareStatement("delete from Employee where employeeId = " + employeeId);
			int n = stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee searchById(Integer employeeId) {
		ResultSet rs = null;
		Employee employee = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Employee where employeeId=" + employeeId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setEmloyeeName(rs.getString("emloyeeName"));
				employee.setSalary(rs.getInt("salary"));
				employee.setJobTitle(rs.getString("jobTitle"));
				return employee;
			}
			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Employee> employeesList() {
		ResultSet rs = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Employee");
			rs = stmt.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setEmloyeeName(rs.getString("emloyeeName"));
				employee.setSalary(rs.getInt("salary"));
				employee.setJobTitle(rs.getString("jobTitle"));
			}
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}