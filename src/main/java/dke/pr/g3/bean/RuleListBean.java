package dke.pr.g3.bean;

import dke.pr.cli.Flora2Interface;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Funktioniert nicht weil die RuleList immer null ist

@ManagedBean(name = "ruleList", eager = true)
@ViewScoped
public class RuleListBean {
	private Flora2Interface flora = new Flora2Interface();
	private String ruleName;
	private Map<String, String> rules;



	public void addRule(String ctx) throws Exception {
		String path = "C:/Users/Anderas/Flora-2/CBRM/Contexts/";

		flora.init();
		try {
			flora.addRule(ctx, this.ruleName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.rules = this.getRules();
		this.ruleName = null;
	}

	// public List<String> getRulesAsList() throws Exception {
	// if (rules == null) {
	// ruleList = new ArrayList<String>();
	// List<String> rules;
	// flora.init();
	// List<String> ctxs = flora.getCtxs();
	// for (String ctx : ctxs) {
	// rules = flora.getRulesAsList(ctx);
	// for (String rule : rules) {
	// if (rule != null) {
	// ruleList.add(rule);
	// }
	// }
	// }
	// }
	// return ruleList;
	// }

	public Map<String, String> getRules() throws Exception {
		if (this.rules == null) {
			rules = new HashMap<String, String>();
			flora.init();
			List<String> ctxs = flora.getCtxs();
			for (String ctx : ctxs) {
				Map<String, String> rls = flora.getRules(ctx);
				for (Map.Entry<String, String> entry : rls.entrySet()) {
					rules.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return rules;
	}

	public String getRuleName() {
		return ruleName;
	}
}
