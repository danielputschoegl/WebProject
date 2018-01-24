package dke.pr.g3.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "contextDetails", eager = true)
@ViewScoped
public class ContextDetailsBean {
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
	}
}
	
