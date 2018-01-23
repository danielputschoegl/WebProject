package dke.pr.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.db.HibernateUtil;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.MessageRecipient;
import dke.pr.g3.entities.User;
import dke.pr.g3.model.Role;
import dke.pr.g3.model.Status;
import dke.pr.g3.model.Type;

public class Test {

	public static void main(String[] args) {
		DBConnection.deleteAllFromDB();
		User test = new User("test", "test", Role.D);
		User daniel = new User("daniel", "test", Role.RA);
		List<Role> roles = new ArrayList<>();
		roles.add(Role.D);
		roles.add(Role.RA);
		List<User> user = new ArrayList<>();
		user.add(test);
		user.add(daniel);
		DBConnection.newUser(test);
		DBConnection.newUser(daniel);
		DBConnection.newMessage(daniel, "testSubject1", "testMessage", Type.S, Status.U, roles);
		DBConnection.newMessage(test, "testSubject2", "testMessage", Type.S, Status.U, user);
//		
//		for (Message next : DBConnection.getAllMessages()) {
//			System.out.println(next.getId());
//		}
//		for (Message next : DBConnection.getAllMessagesForUser(user1)) {
//			System.out.println(next.getId());
//		}
//		for (MessageRecipient next : DBConnection.getMessageListForUser(user1)) {
//			System.out.println(next.getMessageId());
//		}
		
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		try {
//			@SuppressWarnings("unchecked")
//			List<MessageRecipient> messages = session.createQuery("FROM MessageRecipient").list();
//			for (MessageRecipient next : messages) {
//				System.out.println(next.getId());
//			}
//		} finally {
//			session.close();
//		}
	}
}
