package com.test.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

@Route("treegridview")
public class TreeGridView extends VerticalLayout {

	public TreeGridView() {

		Person boss = new Person("Boss", 0); // root
		Person jorma = new Person("Jorma", 0);
		Person kalle = new Person("Kalle", 0);
		Person tom = new Person("Tom", 0);

		jorma.setSupervisor(boss);
		kalle.setSupervisor(kalle);
		boss.getSlaves().add(kalle);
		boss.getSlaves().add(jorma);
		jorma.getSlaves().add(tom);

		TreeGrid<Person> grid = new TreeGrid<>(Person.class);
		grid.setItems(Arrays.asList(boss), b -> b.getSlaves());
		grid.setHierarchyColumn("name");

		grid.setSelectionMode(Grid.SelectionMode.MULTI);

		add(grid);
	}

	public static class Person {

		private String name;
		private int yearOfBirth;
		private Person supervisor;
		// set child
		private Collection<Person> slaves = new ArrayList<>();

		public Person(String name, int yearOfBirth) {
			this.name = name;
			this.yearOfBirth = yearOfBirth;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		@Override
		public String toString() {
			return "{" + name + '}';
		}

	}

}