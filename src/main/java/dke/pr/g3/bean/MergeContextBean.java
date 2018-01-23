package dke.pr.g3.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "mergeContext", eager = true)
@ViewScoped
public class MergeContextBean {
	public String rulesFromFirstContext;
	public String rulesFromSecondContext;
	public String firstContext;
	public String secondContext;
	Flora2Interface base = new Flora2Interface();

	public String merge() {
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index?faces-redirect=true";
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

	public String getRulesFromFirstContext() {
		return rulesFromFirstContext;
	}

	public void setRulesFromFirstContext(String rulesFromFirstContext) {
		this.rulesFromFirstContext = rulesFromFirstContext;
	}

	public String getRulesFromSecondContext() {
		return rulesFromSecondContext;
	}

	public void setRulesFromSecondContext(String rulesFromSecondContext) {
		this.rulesFromSecondContext = rulesFromSecondContext;
	}
}
