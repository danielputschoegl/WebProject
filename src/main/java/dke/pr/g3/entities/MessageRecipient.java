package dke.pr.g3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	
	@Column
	private boolean toAll;
	
	public MessageRecipient() {
	}

	public MessageRecipient(Long messageId, User user, Role role, boolean toAll) {
		this.messageId = messageId;
		this.user = user;
		this.role = role;
		this.toAll = toAll;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isToAll() {
		return toAll;
	}

	public void setToAll(boolean toAll) {
		this.toAll = toAll;
	}
}
