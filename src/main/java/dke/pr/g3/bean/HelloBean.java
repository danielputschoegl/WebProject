package dke.pr.g3.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return "Peter";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSomething() {
		return "Penis";
	}
}