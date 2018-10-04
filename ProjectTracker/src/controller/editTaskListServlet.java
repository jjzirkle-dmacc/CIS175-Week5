package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editTaskListServlet
 */
@WebServlet("/editTaskListServlet")
public class editTaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editTaskListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper lih = new ListItemHelper();
		String act = request.getParameter("doThisToTask");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllTasksServlet").forward(request, response);

		} else if (act.equals("Delete Selected Task")) {

			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem taskToDelete = lih.searchForTaskById(tempId);
			lih.deleteTask(taskToDelete);

			getServletContext().getRequestDispatcher("/viewAllTasksServlet").forward(request, response);

		} else if (act.equals("Edit Selected Task")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem taskToEdit = lih.searchForTaskById(tempId);
			request.setAttribute("taskToEdit", taskToEdit);
			getServletContext().getRequestDispatcher("/edit-task.jsp").forward(request, response);

		} else if (act.equals("Add New Task")) {
			getServletContext().getRequestDispatcher("/addTask.html").forward(request, response);
		}

	}

}