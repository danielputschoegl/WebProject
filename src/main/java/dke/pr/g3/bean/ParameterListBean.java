package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;
import dke.pr.g3.entities.User;
import dke.pr.g3.utils.Utils;

@ManagedBean(name = "parameterList", eager = true)
@ViewScoped
public class ParameterListBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> parameters;
	private String parameterName;
	private Utils utils = new Utils();

	public void delete(String parameter) throws IOException {
		try {
			flora.init();
			flora.delParameter(parameter);
			this.parameters = flora.getParametersAsList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendEditMessage(String parameter, User user) {
		return this.utils.sendEditMessage(parameter, user, "parameter");
	}

	public void add() throws IOException {
		flora.init();
		flora.addParameter(parameterName);
		this.parameterName = null;
		this.parameters = flora.getParametersAsList();
	}

	public List<String> getParameters() throws IOException {
		if (this.parameters == null) {
			flora.init();
			this.parameters = flora.getParametersAsList();
		}
		return this.parameters;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
}
