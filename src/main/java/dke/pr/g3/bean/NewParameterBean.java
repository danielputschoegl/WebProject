package dke.pr.g3.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dke.pr.cli.Flora2Interface;
import dke.pr.g3.bean.*;

@ManagedBean(name = "newParameter", eager = true)
@ViewScoped
public class NewParameterBean {
	Flora2Interface bean = new Flora2Interface();
	private String parametername;

	public String create() throws IOException {

		//FacesContext facesContext = FacesContext.getCurrentInstance();

		//HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		//session.setAttribute("parametername", parametername);
		bean.init();
		bean.addParameter(parametername, "all" + parametername, parametername + "[detParamValue(?bc)->?v]:-?v=all" + parametername + ".");
		return "index?faces-redirect=true";
	}

	public String getParametername() {
		return parametername;
	}

	public void setParametername(String parametername) {
		this.parametername = parametername;
	}
}
