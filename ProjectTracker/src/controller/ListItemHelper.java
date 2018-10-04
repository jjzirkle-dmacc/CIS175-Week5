package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ProjectTracker");
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void insertTask(ListItem li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteTask(ListItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.department = :selectedDepartment and li.task = :selectedTask", ListItem.class);
		typedQuery.setParameter("selectedDepartment", toDelete.getDepartment());
		typedQuery.setParameter("selectedTask", toDelete.getTask());
		typedQuery.setMaxResults(1);
		ListItem result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListItem> searchForTaskByTask(String taskName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.task = :selectedTask", ListItem.class);
		typedQuery.setParameter("selectedTask", taskName);

		List<ListItem> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}

	public List<ListItem> searchForTaskByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.department = :selectedDepartment", ListItem.class);
		typedQuery.setParameter("selectedDepartment", departmentName);

		List<ListItem> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
		
	}
	
	public ListItem searchForTaskById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, id);
		em.close();
		return found;
	}

	public List<ListItem> showAllTasks(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li", ListItem.class);
		List<ListItem> allTasks = typedQuery.getResultList();
		em.close();
		return allTasks;
	}

	public void updateTask(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	
}   