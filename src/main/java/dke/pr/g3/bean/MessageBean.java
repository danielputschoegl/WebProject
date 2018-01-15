package dke.pr.g3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dke.pr.g3.entities.Message;

@ManagedBean(name = "message", eager = true)
@SessionScoped
public class MessageBean {
	public List<Message> getAllMessages() {
		return null;
	}
}
