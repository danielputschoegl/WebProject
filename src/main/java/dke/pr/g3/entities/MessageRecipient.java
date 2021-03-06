package dke.pr.g3.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import dke.pr.g3.model.Role;

@Entity
public class MessageRecipient {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private long messageId;
	
	@ManyToOne
	private User user;
	
	public MessageRecipient() {
	}

	public MessageRecipient(Long messageId, User user) {
		this.messageId = messageId;
		this.user = user;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
