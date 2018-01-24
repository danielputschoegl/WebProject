package dke.pr.g3.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;
import dke.pr.g3.entities.User;

@ManagedBean(name = "splitContext", eager = true)
@ViewScoped
public class SplitContextBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> contexts;
	private String rootContext;
	private String firstContext;
	private String secondContext;

	public List<String> getContexts() throws IOException {
		if (contexts == null) {
			flora.init();
			this.contexts = flora.getCtxs();
		}

		return this.contexts;
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
