package dke.pr.cli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dke.pr.cli.CBRInterface;

public class Flora2Interface {
	CBRInterface fl;

	public String init() throws IOException {
		try {
			fl = new CBRInterface("C:/Users/Uni/Flora-2/CBRM/ctxModelAIM.flr",
					"C:/Users/Uni/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");

			fl.setDebug(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ready";
	}

	public List<String> getCtxs() throws IOException {
		return fl.getCtxs();
	}

	public String getCtxHierarchy() throws IOException {
		String out = "";
		List<String[]> hierarchy = fl.getCtxHierarchy();
		for (String[] element : hierarchy) {
			out += "{source: \"" + element[0] + "\", target: \"" + element[1] + "\", type: \"suit\"},";
		}
		return out;
	}

	public String getParameterValuesHiearchy() throws IOException {
		String out = "";
		List<String[]> hierarchy;
		List<String> parameterValues = fl.getParameters();
		for (String parameterValue : parameterValues) {
			// {source: "Oracle", target: "Google", type: "suit"},
			hierarchy = fl.getParameterValuesHiearchy(parameterValue);
			for (String[] element : hierarchy) {
				// {source: "Oracle", target: "Google", type: "suit"},
				out += "{source: \"" + element[1] + "\", target: \"" + element[0] + "\", type: \"suit\"},";
				System.out.println("{source: \"" + element[0] + "\", target: \"" + element[1] + "\", type: \"suit\"},");
				System.out.println();
			}
		}
		return out;
	}

	public boolean delParameter(String pName) throws IOException {
		boolean out = false;
		out = fl.delParameter(pName);
		return out;
	}

	public boolean delCtx(String ctx, boolean fileAlso) throws Exception {
		boolean out = false;
		out = fl.delCtx(ctx, fileAlso);
		return out;
	}

	public String getCtxFile(String ctx) throws Exception {
		String out = "";
		out = fl.getCtxFile(ctx);
		return out;
	}

	public String getCtxInfo(String ctx) throws IOException {
		String out = "";
		List<String[]> contextsInfo = fl.getCtxInfo(ctx);
		for (String[] element : contextsInfo) {
			out += " " + element[0] + " unter " + element[1] + "\n";
		}
		return out;
	}

	public String getParameters() throws IOException {
		String out = "";
		List<String> parameters = fl.getParameters();
		for (String element : parameters) {
			out += " " + element + "\n";
		}
		return out;
	}

	public List<String> getParametersAsList() {

		try {
			fl = new CBRInterface("C:/Users/Uni/Flora-2/CBRM/ctxModelAIM.flr",
					"C:/Users/Uni/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		fl.setDebug(false);
		List<String> parameters = null;
		
		try {
			parameters = fl.getParameters();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parameters;
	}

	public boolean restart() throws IOException {
		boolean out = false;
		out = fl.restart();
		return out;
	}

	public boolean updateDetParamValue(String param, String def) throws IOException {
		boolean out = false;
		out = fl.updateDetParamValue(param, def);
		return out;
	}

	public List<String> getParameterValues() throws IOException {
		return fl.getParameterValues();
	}

	public String getParameterParameterValues(String param) throws IOException {
		String out = "";
		List<String> parameterParameterValues = fl.getParameterParameterValues(param);
		for (String element : parameterParameterValues) {
			out += " " + element + "\n";
		}
		return out;
	}

	public String getParameterValuesHiearchy(String parameter) throws IOException {
		String out = "";
		List<String[]> parameterValuesHiearchy = fl.getParameterValuesHiearchy(parameter);
		for (String[] element : parameterValuesHiearchy) {
			out += " " + element[0] + " unter " + element[1] + "\n";
		}
		return out;
	}

	public String getDetParamValue(String param) throws IOException {
		String out = "";
		List<String> detParamValue = fl.getDetParamValue(param);
		for (String element : detParamValue) {
			out += " " + element + "\n";
		}
		return out;
	}

	public String getInterestSpecClass() throws IOException {
		String out = "";
		List<String[]> interestSpecClass = fl.getInterestSpecClass();
		for (String[] element : interestSpecClass) {
			out += " " + element[0] + " unter " + element[1] + "\n";
		}
		return out;
	}

	public String getNOTAMS() throws IOException {
		String out = "";
		List<String> NOTAMS = fl.getNOTAMS();
		for (String element : NOTAMS) {
			out += " " + element + "\n";
		}
		return out;
	}

	public boolean addParameter(String pName, String rootValue, String detParamDef) throws IOException {
		boolean out = false;
		out = fl.addParameter(pName, rootValue, detParamDef);
		return out;
	}

	public boolean addParameter(String name) throws IOException {
		boolean out = false;
		out = fl.addParameter(name, "all" + name, name + "[detParamValue(?bc)->?v]:-?v=all" + name + ".");
		return out;
	}

	public boolean addParameterValue(String pName, String vName, String[] parents, String[] children) throws Exception {
		boolean out = false;
		out = fl.addParameterValue(pName, vName, parents, children);
		return out;
	}

	public boolean delParameterValue(String vName) throws IOException {
		boolean out = false;
		out = fl.delParameterValue(vName);
		return out;
	}

	public boolean addCtx(String ctxDef, String fCtx) throws IOException {
		boolean out = false;
		out = fl.addCtx(ctxDef, fCtx);
		return out;
	}

	public HashMap<String, String> getRules(String ctx) throws Exception {
		return fl.getRules(ctx);
	}

	public String getRules() throws Exception {
		String out = "";
		HashMap<String, String> rules;
		List<String> ctxs = fl.getCtxs();
		for (String ctx : ctxs) {
			rules = fl.getRules(ctx);
			for (Entry<String, String> entry : rules.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				out += key + " " + value;
			}
		}
		return out;
	}

	public ArrayList<String> getRulesAsArrayList() throws Exception {
		ArrayList<String> out = new ArrayList<String>();
		HashMap<String, String> rules;
		List<String> ctxs = fl.getCtxs();
		for (String ctx : ctxs) {
			rules = fl.getRules(ctx);
			for (Entry<String, String> entry : rules.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				out.add(key + " " + value);
			}
		}
		return out;
	}
	
	public boolean addRule(String ctx, String rule) throws Exception {
		return fl.addRule(ctx, rule);
	}

	public boolean delRule(String ctx, String ruleID) throws Exception {
		boolean out = false;
		out = fl.delRule(ctx, ruleID);
		return out;
	}

	public String getISpecs() throws IOException {
		String out = "";
		List<String> iSpecs = fl.getISpecs();
		for (String element : iSpecs) {
			out += " " + element + "\n";
		}
		return out;
	}
}
