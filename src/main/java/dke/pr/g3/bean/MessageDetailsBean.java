package dke.pr.g3.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.Message;

@ManagedBean(name = "messageDetails", eager = true)
@ViewScoped
public class MessageDetailsBean {
	private Long id = new Long(0);
	private Message message;
	
	public void init(Long id) throws IOException {
		if (id == null) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        externalContext.redirect("messages.xhtml");
		}
		this.id = id;
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
}