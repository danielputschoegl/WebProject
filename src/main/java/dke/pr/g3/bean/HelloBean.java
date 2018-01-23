package dke.pr.g3.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String allRules;
	private String[] rules;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSayWelcome() {
		if ("".equals(name) || name == null) {
			return "";
		} else {
			IndexBeanAndi abc = new IndexBeanAndi();
			
			try {
				abc.init();
				allRules = abc.getRules(name);
				rules = allRules.split(".");
				return allRules;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "Fail";
		}
	}

}