package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.MessageRecipient;
import dke.pr.g3.entities.User;

@ManagedBean(name = "message", eager = true)
@ViewScoped
public class MessageBean {
	private User user;
	private List<Message> messages;

	public List<Message> getAllMessages() {
		return null;
	}

	public List<Message> getMessages(User user) {
		this.user = user;
		if (this.messages == null) {
			this.messages = DBConnection.getAllMessagesForUser(user);
		}
		return messages;
	}

	public void deleteMessage(User user, Long id) throws IOException {
		DBConnection.deleteMessageForUser(user, id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("messages.xhtml");
	}
}
