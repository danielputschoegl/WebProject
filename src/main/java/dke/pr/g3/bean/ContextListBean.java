package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "contextList", eager = true)
@ViewScoped
public class ContextListBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> contexts;
	private List<String> parameters;
	private List<String> parameterValues;
	private String contextName;
	private String contextDescription = "";

	public String delete(String ctx) throws IOException {

		try {
			flora.init();
			flora.delCtx(ctx, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "delContext?faces-redirect=true";
	}

	public List<String> getContexts() throws IOException {
		if (contexts == null) {
			flora.init();
			this.contexts = flora.getCtxs();
		}

		return this.contexts;
	}
	
	public List<String> getParameters() throws IOException {
		if (this.parameters == null) {
			flora.init();
			this.parameters = flora.getParametersAsList();
		}
		
		return this.parameters;
	}
	
	public List<String> getParameterValues() throws IOException {
		if (this.parameterValues == null) {
			flora.init();
			this.parameterValues = flora.getParameterValues();
		}
		
		return this.parameterValues;
	}
	
	public void addContext() throws IOException {
		String path = "C:/Users/Uni/Flora-2/CBRM/Contexts/";

		flora.init();
		String ctxDef = this.contextName
				+ ":AIMCtx[" + this.contextDescription + ",file->'" + path
				+ this.contextName + ".flr'].";
		String fCtx = path + this.contextName + ".flr";
		flora.addCtx(ctxDef, fCtx);
	}

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}
	
	public void addContextDescription(String add) {
		this.contextDescription = this.contextDescription.concat(add);
	}

	public String getContextDescription() {
		return contextDescription;
	}

	public void setContextDescription(String contextDescription) {
		this.contextDescription = contextDescription;
	}
}
