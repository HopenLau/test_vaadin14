package com.test.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;

@Route("gridview")
@CssImport("./styles/gridView.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class GridView extends VerticalLayout {

	public GridView() {

		Grid<Person> grid = new Grid<>(Person.class, false);
		grid.addColumn(TemplateRenderer.<Person>of("<div class=\"foobar\">[[item.test]]</div>").withProperty("test",
				u -> u.getFirstName())).setHeader("TEST");
		grid.addColumn(Person::getFirstName).setHeader("First name");
		grid.addColumn(Person::getLastName).setHeader("Last name");

		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Lucas", "Kane"));
		personList.add(new Person("Peter", "Buchanan"));
		personList.add(new Person("Samuel", "Lee"));
		grid.setItems(personList);

		add(grid);
	}

	public static class Person {

		private String firstName;

		private String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
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

		public String getFullName() {
			return firstName + " " + lastName;
		}

	}

}
