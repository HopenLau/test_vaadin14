package com.test.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

@Route("treegridview")
public class TreeGridView extends VerticalLayout {

	public TreeGridView() {
		// 使用方式01: constructor加上"Person.class"，自動加上全部Person的field。
		TreeGrid<Person> grid01 = new TreeGrid<>(Person.class);
		grid01.setItems(getManagers(), b -> b.getSlaves());
		grid01.setHierarchyColumn("firstName");
		grid01.setSelectionMode(Grid.SelectionMode.MULTI);
		add(grid01);

		// 使用方式02: constructor不用加上"Person.class"，需要自己加上Person的field。
		TreeGrid<Person> grid02 = new TreeGrid<>();
		List<Person> grid02_managers = getManagers();
		grid02.setItems(grid02_managers, b -> b.getSlaves());
		grid02.addHierarchyColumn(Person::getFirstName).setHeader("firstName");
		grid02.addColumn(Person::getLastName).setHeader("lastName");
		grid02.setSelectionMode(Grid.SelectionMode.MULTI);
		add(grid02);

		Button expand = new Button("Expand All"); // 收縮
		expand.addClickListener(event -> grid02.expand(grid02_managers));

		Button collapse = new Button("Collapse All"); // 伸展
		collapse.addClickListener(event -> grid02.collapse(grid02_managers));
		add(expand, collapse);
	}

	public List<Person> getManagers() {
		Person boss = new Person("Boss", "rrwew", 0); // root
		Person jorma = new Person("Jorma", "sfsf", 0);
		Person kalle = new Person("Kalle", "dgas", 0);
		Person tom = new Person("Tom", "rrlt", 0);

		jorma.setSupervisor(boss);
		kalle.setSupervisor(kalle);
		boss.getSlaves().add(kalle);
		boss.getSlaves().add(jorma);
		jorma.getSlaves().add(tom);

		Person manager01 = new Person("Päivi", "Sva", 1);
		// "Marcus"
		Person manager02 = new Person("Pekka", "Ömer", 1);
		Person manager03 = new Person("Gilberto", "Tomi", 1);
		kalle.getSlaves().add(manager01);
		jorma.getSlaves().add(manager02);
		tom.getSlaves().add(manager03);

		manager01.getSlaves().add(new Person("staff01", "01", 2));
		manager01.getSlaves().add(new Person("staff02", "02", 2));
		manager01.getSlaves().add(new Person("staff03", "03", 2));
		manager02.getSlaves().add(new Person("staff04", "04", 2));
		manager02.getSlaves().add(new Person("staff05", "05", 2));
		manager02.getSlaves().add(new Person("staff06", "06", 2));
		manager03.getSlaves().add(new Person("staff07", "07", 2));
		manager03.getSlaves().add(new Person("staff08", "08", 2));
		manager03.getSlaves().add(new Person("staff09", "09", 2));

		return Arrays.asList(boss);
	}

	public class Person {
		private String firstName;
		private String lastName;
		private int yearOfBirth;
		private Person supervisor;
		// set child
		private Collection<Person> slaves = new ArrayList<>();

		public Person(String firstName, String lastName, int yearOfBirth) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.yearOfBirth = yearOfBirth;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getYearOfBirth() {
			return yearOfBirth;
		}

		public void setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
		}

		public Person getSupervisor() {
			return supervisor;
		}

		public void setSupervisor(Person supervisor) {
			this.supervisor = supervisor;
		}

		public Collection<Person> getSlaves() {
			return slaves;
		}

		public void setSlaves(Collection<Person> slaves) {
			this.slaves = slaves;
		}

		@Override
		public String toString() {
			return "{" + firstName + "}";
		}

	}

}