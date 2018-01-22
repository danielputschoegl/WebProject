package dke.pr.g3.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "newContext", eager = true)
@ViewScoped
public class NewContextBean {
	IndexBeanAndi bean = new IndexBeanAndi();
	// List<String> parameters = bean.getParametersAsList();
	List<String> parameters = new LinkedList<>();

	private String contextname;

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
}
