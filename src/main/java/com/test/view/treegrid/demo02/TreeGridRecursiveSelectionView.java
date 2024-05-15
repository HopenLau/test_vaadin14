package com.test.view.treegrid.demo02;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

/***
 * Select recursively an item and all its children in a TreeGrid<br>
 * How to select recursively an item and all its children in a tree<br>
 * 
 * @author liu.xue.xun.101236
 *
 */
@Route("view/treegrid/demo02/tree-grid-recursive-selection")
public class TreeGridRecursiveSelectionView extends VerticalLayout {

	public TreeGridRecursiveSelectionView() {
		this.setSizeFull();
		createBasicTreeGridUsage();
	}

	private void createBasicTreeGridUsage() {
		DepartmentData departmentData = new DepartmentData();

		TreeGrid<Department> grid = new RecursiveSelectTreeGrid<>();

		grid.setItems(departmentData.getRootDepartments(), departmentData::getChildDepartments);
		grid.addHierarchyColumn(Department::getName).setHeader("Department Name");
		grid.addColumn(Department::getManager).setHeader("Manager");

		grid.setSelectionMode(Grid.SelectionMode.MULTI);
		add(grid);
	}
}
