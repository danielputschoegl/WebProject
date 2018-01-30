package dke.pr.g3.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "parameterValueList", eager = true)
@ViewScoped
public class ParameterValueListBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Flora2Interface flora = new Flora2Interface();
	private List<String> parameters;
	private List<String> parameterValues;
	private String name;
	private String parameter;
	private List<String> parameterValueParents = new ArrayList<>();
	private List<String> parameterValueChildren = new ArrayList<>();

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

	public void deleteParameterValue(String parameterValue) throws IOException {
		if (flora.readFlag()) {
			flora.writeFlag("closed");
			flora.init();
			flora.delParameterValue(parameterValue);
			this.parameters = flora.getParametersAsList();
			flora.writeFlag("open");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public void addParentParameterValue(String parent) {
		if (this.parameterValueParents.contains(parent)) {
			this.parameterValueParents.remove(parent);
		} else {
			this.parameterValueParents.add(parent);
		}
	}

	public void addChildParameterValue(String child) {
		if (this.parameterValueChildren.contains(child)) {
			this.parameterValueChildren.remove(child);
		} else {
			this.parameterValueChildren.add(child);
		}
	}

	public void addParameterValue() throws Exception {
		flora.init();
		flora.addParameterValue(this.parameter, this.name, this.parameterValueParents.toArray(new String[0]),
				(String[]) this.parameterValueChildren.toArray(new String[0]));
		this.name = null;
		this.parameterValueParents = new ArrayList<>();
		this.parameterValueChildren = new ArrayList<>();
		this.parameters = flora.getParametersAsList();
	}
}
