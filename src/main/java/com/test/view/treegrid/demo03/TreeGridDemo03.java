package com.test.view.treegrid.demo03;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

@Route("view/treegrid/demo03/tree-grid-view")
public class TreeGridDemo03 extends VerticalLayout {

	public TreeGridDemo03() {
		TreeGrid<TreeItem> treeGrid = new TreeGrid<>();
		treeGrid.addHierarchyColumn(TreeItem::getName);

		setSizeFull();
		treeGrid.setSizeFull();

		for (Company company : getCompanies()) {
			TreeItem companyItem = new TreeItem(company.getName());
			treeGrid.getTreeData().addItem(null, companyItem);

			for (Department department : company.getDepartments()) {
				TreeItem departmentItem = new TreeItem(department.getName());
				treeGrid.getTreeData().addItem(companyItem, departmentItem);

				for (Employee employee : department.getEmployees()) {
					TreeItem employeeItem = new TreeItem(employee.getName());
					treeGrid.getTreeData().addItem(departmentItem, employeeItem);
				}
			}
		}

		add(treeGrid);
	}

	private List<Company> getCompanies() {
		List<Company> companies = new ArrayList<Company>();

		Employee employee01 = new Employee();
		employee01.setName("William");
		Employee employee02 = new Employee();
		employee02.setName("Anthony");
		Employee employee03 = new Employee();
		employee03.setName("Joey");

		Department department01 = new Department();
		department01.setName("G20");
		department01.getEmployees().add(employee01);
		Department department02 = new Department();
		department02.setName("007");
		department02.getEmployees().add(employee02);
		Department department03 = new Department();
		department03.setName("844");
		department03.getEmployees().add(employee03);

		Company company01 = new Company();
		company01.setName("CSS");
		company01.getDepartments().add(department01);
		company01.getDepartments().add(department02);
		company01.getDepartments().add(department03);
		companies.add(company01);

		Employee employee04 = new Employee();
		employee04.setName("Ron");
		Employee employee05 = new Employee();
		employee05.setName("Sim");
		Employee employee06 = new Employee();
		employee06.setName("Alice");

		Department department04 = new Department();
		department04.setName("IT部");
		department04.getEmployees().add(employee04);
		Department department05 = new Department();
		department05.setName("市場部");
		department05.getEmployees().add(employee05);
		Department department06 = new Department();
		department06.setName("財務部");
		department06.getEmployees().add(employee06);

		Company company02 = new Company();
		company02.setName("GET");
		company02.getDepartments().add(department04);
		company02.getDepartments().add(department05);
		company02.getDepartments().add(department06);
		companies.add(company02);

		return companies;
	}

	public class Company {
		private String name;
		private List<Department> departments = new ArrayList<Department>();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Department> getDepartments() {
			return departments;
		}

		public void setDepartments(List<Department> departments) {
			this.departments = departments;
		}

	}

	public class Department {
		private String name;
		private List<Employee> employees = new ArrayList<Employee>();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

	}

	public class Employee {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public class TreeItem {
		private String name;

		public TreeItem(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
