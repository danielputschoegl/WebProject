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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dke.pr.g3.model.Status;
import dke.pr.g3.model.Type;

@Entity
public class Message {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdAt;
	
	@Column
	private String subject;
	
	@Column
	private String message;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Status status;
	
	@ManyToOne
	private User statusBy;
	
	public Message() {
	}
	
	public Message(User createdBy, Date createdAt, String subject, String message, Type type, Status status, User statusBy) {
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.subject = subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
