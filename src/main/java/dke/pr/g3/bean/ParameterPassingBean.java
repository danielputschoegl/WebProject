package dke.pr.g3.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "parameterPassing", eager = true)
@RequestScoped
public class ParameterPassingBean {
	
	@ManagedProperty("#{param.messageId}")
	private Long messageId;
	@ManagedProperty("#{param.rootContext}")
	private String rootContext;
	@ManagedProperty("#{param.firstContext}")
	private String firstContext;
	@ManagedProperty("#{param.secondContext}")
	private String secondContext;
	
	public String goToSplitRules() {
		return "splitRules";
	}

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

	public String getRootContext() {
		return rootContext;
	}

	public void setRootContext(String rootContext) {
		this.rootContext = rootContext;
	}

	public String getFirstContext() {
		return firstContext;
	}

	public void setFirstContext(String firstContext) {
		this.firstContext = firstContext;
	}

	public String getSecondContext() {
		return secondContext;
	}

	public void setSecondContext(String secondContext) {
		this.secondContext = secondContext;
	}
	
}
