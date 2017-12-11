package dke.pr.g3.db;

import java.util.Date;
import java.util.List;
import org.hibernate.*;

import dke.pr.g3.Role;
import dke.pr.g3.Status;
import dke.pr.g3.Type;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.User;

public class DBConnection {
	public static User currentUser = new User("test", "test", Role.U);

	public static boolean checkUserInformation(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			@SuppressWarnings("unchecked")
			List<User> resultList = session
					.createQuery("FROM User u WHERE u.username = :username AND u.password = :password")
					.setParameter("username", username).setParameter("password", password).list();
			for (User next : resultList) {
				currentUser = next;
				return true;
			}
			return false;
		} finally {
			session.close();
		}
	}
	
	public static void newUser(String username, String password, Role role) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(new User(username, password, role));
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static void newMessage(Date createdAt, String message, Type type, Status status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(new Message(currentUser, createdAt, message, type, status, currentUser));
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public static void updateMessageStatus(Long id, Status status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.createQuery("UPDATE Message m SET m.status = :status AND m.statusBy = :statusBy WHERE m.id = :id")
					.setParameter("status", status).setParameter("statusBy", currentUser).setParameter("id", id)
					.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
