package dke.pr.g3.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import dke.pr.g3.db.DBConnection;
import dke.pr.g3.entities.User;

@ManagedBean(name = "login", eager = true)
@SessionScoped
public class LoginBean {
	private User user;
	private String username;
	private String password;
	private boolean loggedIn = false;

	public String validateUsernamePassword() {
		this.user = DBConnection.checkUserInformation(username, password);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (this.user != null) {
			this.loggedIn = true;
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("loginBean", this);
			return "secured/index?faces-redirect=true";
		} else {
			facesContext.addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login?faces-redirect=true";
		}
	}
	
	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		this.user = null;
		this.password = null;
		this.username = null;
		this.loggedIn = false;
		session.setAttribute("loginBean", this);
		return "/login?faces-redirect=true";
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.loggedIn = logedIn;
	}
}
