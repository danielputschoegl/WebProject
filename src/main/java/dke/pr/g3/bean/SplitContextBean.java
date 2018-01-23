package dke.pr.g3.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "splitContext", eager = true)
@ViewScoped
public class SplitContextBean {
	public String contextToSplit;
	public String rulesToFirstContext;
	public String rulesToSecondContext;
	public String firstContext;
	public String secondContext;
	Flora2Interface base = new Flora2Interface();

	public String split() {
		try {
			base.init();
			base.addCtx(rulesToFirstContext, firstContext);
			base.addCtx(rulesToSecondContext, secondContext);
			base.delCtx(contextToSplit, true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index?faces-redirect=true";
	}

	public String getContextToSplit() {
		return contextToSplit;
	}

	public void setContextToSplit(String contextToSplit) {
		this.contextToSplit = contextToSplit;
	}

	public String getRulesToFirstContext() {
		return rulesToFirstContext;
	}

	public void setRulesToFirstContext(String rulesToFirstContext) {
		this.rulesToFirstContext = rulesToFirstContext;
	}

	public String getRulesToSecondContext() {
		return rulesToSecondContext;
	}

	public void setRulesToSecondContext(String rulesToSecondContext) {
		this.rulesToSecondContext = rulesToSecondContext;
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
