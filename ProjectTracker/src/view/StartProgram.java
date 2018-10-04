package view;

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addTask() {
			// TODO Auto-generated method stub
			System.out.print("Enter a department: ");
			String department = in.nextLine();
			System.out.print("Enter a task: ");
			String task = in.nextLine();
			
			ListItem toAdd = new ListItem(department, task);
			lih.insertTask(toAdd);

		}

		private static void deleteTask() {
			// TODO Auto-generated method stub
			System.out.print("Enter the department to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the task to delete: ");
			String item = in.nextLine();
			ListItem toDelete = new ListItem(store, item);
			
			lih.deleteTask(toDelete);
		}

		private static void editTask() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Department");
			System.out.println("2 : Search by Task");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the deparment name: ");
				String departmentName = in.nextLine();
				foundItems = lih.searchForTaskByDepartment(departmentName);
			} else {
				System.out.print("Enter the task: ");
				String taskName = in.nextLine();
				foundItems = lih.searchForTaskByTask(taskName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println("ID: " + l.getId() + " - " + l.returnTaskDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForTaskById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTask() + " from " + toEdit.getDepartment());
				System.out.println("1 : Update Store");
				System.out.println("2 : Update Item");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Department: ");
					String newDepartment = in.nextLine();
					toEdit.setDepartment(newDepartment);
				} else if (update == 2) {
					System.out.print("New Task: ");
					String newTask = in.nextLine();
					toEdit.setTask(newTask);
				}

				lih.updateTask(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Project Tracker ---");
			while (goAgain) {
				System.out.println("*  Select a task:");
				System.out.println("*  1 -- Add a task");
				System.out.println("*  2 -- Edit a task");
				System.out.println("*  3 -- Delete a task");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addTask();
				} else if (selection == 2) {
					editTask();
				} else if (selection == 3) {
					deleteTask();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allItems = lih.showAllTasks();
			for(ListItem l : allItems){
				System.out.println(l.returnTaskDetails());
			}

		}

	}