package dke.pr.g3.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.g3.model.Role;
import dke.pr.g3.model.Status;
import dke.pr.g3.model.Type;
import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.User;

@ManagedBean(name = "newMessage", eager = true)
@ViewScoped
public class NewMessageBean {
	private String subject;
	private List<User> users;
	private List<Role> selectedRoles = new ArrayList<>();
	private List<User> selectedUsers = new ArrayList<>();;
	private Type type;
	private String message;
	private Status status;

	public String save(User user) {
		DBConnection.newMessage(user, this.subject, this.message, this.type, this.status, this.selectedUsers, this.selectedRoles);
		return "messages?faces-redirect=true";
	}
	
	public void messageTo(Role role) {
		if(this.selectedRoles.contains(role)) {
			this.selectedRoles.remove(role);
		} else {
			this.selectedRoles.add(role);
		}
	}

	public void messageTo(User user) {
		if(this.selectedUsers.contains(user)) {
			this.selectedUsers.remove(user);
		} else {
			this.selectedUsers.add(user);
		}
	}
	
	public String getSelected() {
		String out = " ";
		for(Role role : this.selectedRoles) {
			out.concat(role.toString() + ", ");
		}
		for(User user : this.selectedUsers) {
			out.concat(user.getUsername() + ", ");
		}
		return out;
	}
	
	public boolean messageToContains(Role role) {
		System.out.println(this.selectedRoles.contains(role));
		return this.selectedRoles.contains(role);
	}

	public List<Role> getRoles() {
		return new ArrayList<Role>(Arrays.asList(Role.values()));
	}
	
	public List<User> getUsers() {
		if (this.users == null) {
			this.users = DBConnection.getAllUsers();
		}
		return users;
	}

	public Status[] getStatuses() {
		return Status.values();
	}

	public Type[] getTypes() {
		return Type.values();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
