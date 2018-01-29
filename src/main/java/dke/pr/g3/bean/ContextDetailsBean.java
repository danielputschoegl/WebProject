package dke.pr.g3.bean;

import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "contextDetails", eager = true)
@ViewScoped
public class ContextDetailsBean implements Serializable{

	private static final long serialVersionUID = -4754936333401369656L;
	private Flora2Interface flora = new Flora2Interface();
	private Map<String, String> rules;
	private String context;
	private String rule;
	
	public Map<String, String> getRules() throws Exception {
		if (this.rules == null) {
			flora.init();
			this.rules = flora.getRules(this.context);
		}
		return this.rules;
	}
	
	public void deleteRule(String id) throws Exception {
		flora.init();
		flora.delRule(this.context, id);
		this.rules = flora.getRules(this.context);
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	public void addRule() throws Exception {
		flora.addRule(this.context, this.rule);
		this.rule = null;
		this.rules = flora.getRules(this.context);
	}
}