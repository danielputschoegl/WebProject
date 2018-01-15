package dke.pr.g3.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.g3.entities.Message;

@ManagedBean(name = "messages", eager = true)
@ViewScoped
public class MessageBean {
	public List<Message> getAllMessages() {
		return null;
	}
}
