package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "mergeContext")
@ViewScoped
public class MergeContextBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> contexts;
	private String firstContext;
	private String secondContext;
	
	public void merge() throws Exception {
		flora.init();
		List<String> rules = flora.getRulesAsList(this.firstContext);
		for(String rule : rules) {
			flora.addRule(secondContext, rule);
		}
		flora.delCtx(firstContext, true);
		this.firstContext = null;
		this.secondContext = null;
	}

	public List<String> getContexts() throws IOException {
		if (contexts == null) {
			flora.init();
			this.contexts = flora.getCtxs();
		}
		return this.contexts;
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