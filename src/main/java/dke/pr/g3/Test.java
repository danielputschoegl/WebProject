package dke.pr.g3;

import java.util.Date;
import java.util.List;

import org.hibernate.*;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.db.HibernateUtil;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.User;

public class Test {

	public static void main(String[] args) {
//		DBConnection.newUser("testtest", "test", Role.RA);
//		DBConnection.newMessage(new Date(), "test", Type.S, Status.U);
		
		Session session = HibernateUtil.getSessionFactory().openSession();

			@SuppressWarnings("unchecked")
			List<Message> resultList = session.createQuery("FROM Message").list();
			for (Message next : resultList) {
				System.out.println(next.getCreatedBy().getUsername());
			}
	}
}
