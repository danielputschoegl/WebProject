package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.User;

@ManagedBean(name = "sentMessage", eager = true)
@ViewScoped
public class SentMessageBean {
	private User user;
	private List<Message> messages;

	public List<Message> getAllMessages() {
		return null;
	}

	public List<Message> getMessages(User user) {
		this.user = user;
		if (this.messages == null) {
			this.messages = DBConnection.getAllSentMessagesForUser(user);
		}
		return messages;
	}
	
	public void deleteMessage(Long id) throws IOException {
		DBConnection.deleteMessage(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("sentMessages.xhtml");
	}
}
