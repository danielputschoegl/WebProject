package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "updateContext", eager = true)
@ViewScoped
public class UpdateContextBean {
	Flora2Interface bean = new Flora2Interface();
	String contextname;
	String rules;

	public String update() throws IOException {
		try {
			
			bean.getCtxs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index?faces-redirect=true";
	}

	public List<String> returnRules(){
		List<String> rules = null;
		try {
			rules = bean.getRulesAsArrayList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rules;
 	}
	public String getContextname() {
		return contextname;
	}

	public void setContextname(String parametername) {
		this.contextname = parametername;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
}
