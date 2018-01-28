package dke.pr.g3.db;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.TypedQuery;

import org.hibernate.*;

import dke.pr.g3.model.Role;
import dke.pr.g3.model.Status;
import dke.pr.g3.model.Type;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.MessageRecipient;
import dke.pr.g3.entities.User;

@SessionScoped
public class DBConnection {

	public static void deleteAllFromDB() {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			TypedQuery<MessageRecipient> qMr = session.createQuery("delete FROM MessageRecipient");
			qMr.executeUpdate();
			session.flush();

			@SuppressWarnings("unchecked")
			TypedQuery<MessageRecipient> qM = session.createQuery("delete FROM Message");
			qM.executeUpdate();
			session.flush();

			@SuppressWarnings("unchecked")
			TypedQuery<MessageRecipient> qU = session.createQuery("delete FROM User");
			qU.executeUpdate();
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static List<User> getAllUsers() {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<User> resultList = session.createQuery("FROM User").list();
			transaction.commit();
			return resultList;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	public static User getUserByUsername(String username) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			User user = (User) session.createQuery("FROM User u WHERE u.username = :username")
					.setParameter("username", username).uniqueResult();
			transaction.commit();
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	public static List<User> getUsersByRole(Role role) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			@SuppressWarnings("unchecked")
			List<User> resultList = session.createQuery("FROM User WHERE role = :role").setParameter("role", role)
					.list();
			return resultList;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public static User checkUserInformation(String username, String password) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<User> resultList = session
					.createQuery("FROM User u WHERE u.username = :username AND u.password = :password")
					.setParameter("username", username).setParameter("password", password).list();
			transaction.commit();
			for (User next : resultList) {
				return next;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	public static void newUser(User user) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static void newUser(String username, String password, Role role) {
		DBConnection.newUser(new User(username, password, role));
	}

	public static Message getMessageById(Long id) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			return (Message) session.get(Message.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public static List<Message> getAllMessages() {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			@SuppressWarnings("unchecked")
			List<Message> messages = session.createQuery("FROM Message").list();
			Collections.sort(messages);
			return messages;
		} finally {
			session.close();
		}
	}

	public static List<MessageRecipient> getMessageListForUser(User user) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			@SuppressWarnings("unchecked")
			List<MessageRecipient> messages = session
					.createQuery("FROM MessageRecipient WHERE user = :user OR role = :role OR toAll = 1")
					.setParameter("user", user).setParameter("role", user.getRole()).list();
			return messages;
		} finally {
			session.close();
		}
	}

	public static List<Message> getAllMessagesForUser(User user) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Message> messages = session
					.createQuery(
							"FROM Message WHERE id IN " + "(SELECT messageId FROM MessageRecipient WHERE user = :user)")
					.setParameter("user", user).list();
			transaction.commit();
			Collections.sort(messages);
			return messages;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	public static List<Message> getAllSentMessagesForUser(User user) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Message> messages = session.createQuery("FROM Message WHERE createdBy = :user")
					.setParameter("user", user).list();
			transaction.commit();
			Collections.sort(messages);
			return messages;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	public static void newMessage(User currentuser, String subject, String message, Type type, Status status,
			List<User> users) {
		DBConnection.newMessage(currentuser, subject, message, type, status, users, null);
	}

	public static void newMessage(User currentuser, String subject, String message, Type type, Status status,
			Collection<Role> role) {
		DBConnection.newMessage(currentuser, subject, message, type, status, null, (List<Role>) role);
	}

	public static void newMessage(User currentUser, String subject, String message, Type type, Status status,
			List<User> users, List<Role> roles) {
		DBConnection.newMessage(new Message(currentUser, new Date(), subject, message, type, status, currentUser),
				users, roles);
	}

	public static void newMessage(Message msg, List<User> users, List<Role> roles) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(msg);
			transaction.commit();
			if (users != null) {
				for (User user : users) {
					transaction = session.beginTransaction();
					session.save(new MessageRecipient(msg.getId(), user));
					transaction.commit();
				}
			}
			if (roles != null) {
				for (Role role : roles) {
					for (User user : DBConnection.getUsersByRole(role)) {
						transaction = session.beginTransaction();
						session.save(new MessageRecipient(msg.getId(), user));
						transaction.commit();
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static void updateMessage(Long messageId, User currentUser, Status status, String text) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Message message = (Message) session.get(Message.class, messageId);
			if (text != null && !text.isEmpty()) {
				message.setMessage(text.concat("             <---------------->             ").concat(message.getMessage()));
			}
			message.setStatus(status);
			message.setStatusBy(currentUser);
			message.setCreatedAt(new Date());
			session.update(message);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static void deleteMessage(Long messageId) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<MessageRecipient> messages = session
					.createQuery("FROM MessageRecipient WHERE messageId = :id").setParameter("id", messageId).list();
			for(MessageRecipient msg : messages) {
				session.delete(msg);
			}
			Message message = (Message) session.get(Message.class, messageId);
			session.delete(message);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static void deleteMessageForUser(User user, Long messageId) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			MessageRecipient msg = (MessageRecipient) session
					.createQuery("FROM MessageRecipient WHERE user = :user AND messageId = :id")
					.setParameter("user", user).setParameter("id", messageId).uniqueResult();
			session.delete(msg);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
}
