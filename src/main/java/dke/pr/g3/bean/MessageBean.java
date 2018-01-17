package dke.pr.g3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.MessageRecipient;
import dke.pr.g3.entities.User;

@ManagedBean(name = "message", eager = true)
@ViewScoped
public class MessageBean {
	private User user;
	
	public List<Message> getAllMessages() {
		return null;
	}
	
	public List<Message> getMessages(User user) {
		this.user = user;
		return DBConnection.getAllMessagesForUser(user);
	}
	
	public void deleteMessage(int id) {
		
	}
}
