package dke.pr.g3.bean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "newContext", eager = true)
@ViewScoped
public class NewContextBean {
	static IndexBeanAndi bean = new IndexBeanAndi();
	// List<String> parameters = bean.getParametersAsList();
	static List<String> parameters = bean.getParametersAsList();
	// static List<String> parameterValues =
	// bean.getParameterParameterValuesAsList();

	private String contextname;
	private String context;

	// @PostConstruct
	// public void fillParameters() {
	// parameters = bean.getParametersAsList();
	// }

	public String create() throws IOException {

		bean.init();
		String ctxDef = contextname
				// for every parameter must be set a parameter value ?
				+ ":AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'C:/Users/Anderas/Flora-2/CBRM/Contexts/"
				+ contextname + ".flr'].";
		String fCtx = "C:/Users/Anderas/Flora-2/CBRM/Contexts/" + contextname + "vogel.flr";
		bean.addCtx(ctxDef, fCtx);
		return "index?faces-redirect=true";
	}

	public String getContextname() {
		return contextname;
	}

	public void setContextname(String parametername) {
		this.contextname = parametername;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
}
