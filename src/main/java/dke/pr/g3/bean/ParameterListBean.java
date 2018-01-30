package dke.pr.g3.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;
import dke.pr.g3.entities.User;
import dke.pr.g3.utils.Utils;

@ManagedBean(name = "parameterList", eager = true)
@ViewScoped
public class ParameterListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Flora2Interface flora = new Flora2Interface();
	private List<String> parameters;
	private String parameterName;
	private Utils utils = new Utils();

	public void delete(String parameter) throws IOException {
		if (flora.readFlag()) {
			flora.writeFlag("closed");
			flora.init();
			flora.delParameter(parameter);
			this.parameters = flora.getParametersAsList();
			flora.writeFlag("open");
		}
	}

	public String sendEditMessage(String parameter, User user) {
		return this.utils.sendEditMessage(parameter, user, "parameter");
	}

	public void add() throws IOException {
		if (flora.readFlag()) {
			flora.writeFlag("closed");
			flora.init();
			String[] parser = parameterName.split(",");
			if (parser[0] != null && parser[1] != null && parser[2] != null) {
				flora.addParameter(parser[0], parser[1], parser[2]);
			}
			this.parameterName = null;
			this.parameters = flora.getParametersAsList();
			flora.writeFlag("open");
		}
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