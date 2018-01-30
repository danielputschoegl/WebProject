package dke.pr.g3.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dke.pr.cli.Flora2Interface;
import dke.pr.g3.entities.User;
import dke.pr.g3.utils.Utils;

@ManagedBean(name = "contextList", eager = true)
@ViewScoped
public class ContextListBean implements Serializable {

	private static final long serialVersionUID = -6762643095047566910L;
	private Flora2Interface flora = new Flora2Interface();
	private List<String> contexts;
	private List<String> parameters;
	private List<String> parameterValues;
	private String contextName;
	private String contextDescription = "";
	private Utils utils = new Utils();

	public String delete(String ctx) throws Exception {
		if (flora.readFlag()) {
			flora.writeFlag("closed");
			flora.init();
			flora.delCtx(ctx, true);
			this.contexts = flora.getCtxs();
			flora.writeFlag("open");
		}
		return "delContext?faces-redirect=true";
	}

	public String sendEditMessage(String ctx, User user) {
		return this.utils.sendEditMessage(ctx, user, "ctx");
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
		if (flora.readFlag()) {
			flora.writeFlag("closed");
			String path = flora.getContextPath();

			flora.init();
			String ctxDef = this.contextName + ":AIMCtx[" + this.contextDescription + ",file->'" + path
					+ this.contextName + ".flr'].";
			String fCtx = path + this.contextName + ".flr";

			flora.addCtx(ctxDef, fCtx);
			this.contextDescription = null;
			this.contextName = null;
			this.contexts = flora.getCtxs();
			flora.writeFlag("open");
		}
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
