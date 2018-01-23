package dke.pr.g3.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "parameterPassing", eager = true)
@RequestScoped
public class ParameterPassingBean {
	
	@ManagedProperty("#{param.messageId}")
	private Long messageId;

	public String goToMessageDetails() {
		return "messageDetails";
	}
	
	public String goToEditMessage() {
		return "editMessage";
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	
}
