package dke.pr.g3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "splitRules", eager = true)
@ViewScoped
public class SplitRulesBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> rules;
	private String rootContext;
	private String firstContext;
	private String secondContext;
	private List<String> firstRules = new ArrayList<>();
	private List<String> secondRules = new ArrayList<>();

	public void init(String root, String first, String second) {
		this.rootContext = root;
		this.firstContext = first;
		this.secondContext = second;
	}

	public List<String> getRules() throws Exception {
		if (this.rules == null && this.rootContext != null && this.rootContext != "") {
			flora.init();
			this.rules = new ArrayList<String>();
			System.out.println(rootContext);
			this.rules = flora.getRulesAsList(rootContext);
		}

		return this.rules;
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
	
	public void addFirstRule(String rule) {
		if(this.firstRules.contains(rule)) {
			this.firstRules.remove(rule);
		} else {
			this.firstRules.add(rule);
		}
	}
	
	public void addSecondRule(String rule) {
		if(this.secondRules.contains(rule)) {
			this.secondRules.remove(rule);
		} else {
			this.secondRules.add(rule);
		}
	}
}
