package dke.pr.g3.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import dke.pr.g3.bean.*;

@ManagedBean(name = "newParameterValue", eager = true)
@ViewScoped

public class NewParameterValueBean {
	IndexBeanAndi bean = new IndexBeanAndi();
	private String parameterValue;
	private String parameterValueParentName;
	private String parameterValueParents = "";
	private String parameterValueChildren = "";

	public String create() throws Exception {
		System.out.println(parameterValueChildren);
		bean.init();
		String[] parameterValueParentsArray = { "" };
		parameterValueParentsArray = parameterValueParents.split(",");

		String[] parameterValueChildrenArray = { "" };
		parameterValueChildrenArray = parameterValueChildren.split(",");

		System.out.println("" + parameterValueParentName + parameterValue + parameterValueParentsArray[0]
				+ parameterValueChildrenArray[0]);

//		if (parameterValueParentsArray == new String[] { "" }) {
//			parameterValueParentsArray = null;
//		}
//		if (parameterValueChildrenArray == new String[] { "" }) {
//			parameterValueChildrenArray = null;
//		}
		bean.addParameterValue(parameterValueParentName, parameterValue, parameterValueParentsArray,
				parameterValueChildrenArray);

		return "index?faces-redirect=true";
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getParameterValueParentName() {
		return parameterValueParentName;
	}

	public void setParameterValueParentName(String parameterValueParentName) {
		this.parameterValueParentName = parameterValueParentName;
	}

	public String getParameterValueParents() {
		return parameterValueParents;
	}

	public void setParameterValueParents(String parameterValueParents) {
		this.parameterValueParents = parameterValueParents;
	}

	public String getParameterValueChildren() {
		return parameterValueChildren;
	}

	public void setParameterValueChildren(String parameterValueChildren) {
		this.parameterValueChildren = parameterValueChildren;
	}
}
