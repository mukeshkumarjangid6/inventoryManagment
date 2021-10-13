package kiranaStore.inventoryManagment.dto;

public class Employee {
	private Integer employeeId;
	private String emloyeeName;
	private Integer salary;
	private String jobTitle;

	public Employee() {

	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmloyeeName() {
		return emloyeeName;
	}

	public void setEmloyeeName(String emloyeeName) {
		this.emloyeeName = emloyeeName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", emloyeeName=" + emloyeeName + ", salary=" + salary
				+ ", jobTitle=" + jobTitle + "]";
	}
}