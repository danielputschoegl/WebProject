package dke.pr.g3.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;
import dke.pr.g3.entities.User;
import dke.pr.g3.model.Status;

@ManagedBean(name = "editMessage", eager = true)
@ViewScoped
public class EditMessageBean {
	private static final long serialVersionUID = 1L;
	private Long id = new Long(0);
	private Message message;
	private String text;
	private Status status;
	
	public void init(Long id) throws IOException {
		if (this.id == null) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        externalContext.redirect("messages.xhtml");
		}
		this.id = id;
		this.message = DBConnection.getMessageById(id);
		this.status = message.getStatus();
	}
	
	public void save(User user) throws IOException {
		DBConnection.updateMessage(id, user, this.status, this.text);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("messages.xhtml");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Message getMessage() {
		return this.message;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Status[] getStatuses() {
		return Status.values();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}