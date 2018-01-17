package dke.pr.g3.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;

@ManagedBean(name = "messageDetails", eager = true)
@ViewScoped
public class MessageDetailsBean {
	private Long id = new Long(0);
	private Message message;
	private boolean answer = false;
	private String newMessage;

	@PostConstruct
	public String redirect() {
		if (id == 0) {
			return "messages?faces-redirect=true";
		}

		else
			return null;
	}

	public String init(Long id) {
		this.id = id;
		return "messageDetails?faces-redirect=true";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Message getMessage() {
		if (this.message == null) {
			this.message = DBConnection.getMessageById(id);
		}
		return this.message;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	
	public void setAnswer() {
		this.answer = !this.answer;
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}
}