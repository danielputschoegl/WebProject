package dke.pr.g3.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dke.pr.g3.Type;
import dke.pr.g3.Status;

@Entity
public class Message {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User createdBy;
	
	@Column(name = "created_by")
	private Date createdAt;
	
	@Column(name = "message")
	private String message;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@OneToOne
	private User statusBy;
	
	public Message() {
	}
	
	public Message(User createdBy, Date createdAt, String message, Type type, Status status, User statusBy) {
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.message = message;
		this.type = type;
		this.status = status;
		this.statusBy = statusBy;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(User statusBy) {
		this.statusBy = statusBy;
	}
}
