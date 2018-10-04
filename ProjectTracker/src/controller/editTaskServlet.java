package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editTaskServlet
 */
@WebServlet("/editTaskServlet")
public class editTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editTaskServlet() {
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

		String department = request.getParameter("department");
		String task = request.getParameter("task");
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		ListItem taskToUpdate = lih.searchForTaskById(tempId);
		taskToUpdate.setTask(task);
		taskToUpdate.setDepartment(department);

		lih.updateTask(taskToUpdate);

		getServletContext().getRequestDispatcher("/viewAllTasksServlet").forward(request, response);

	}

}