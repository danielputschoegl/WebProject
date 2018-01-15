package dke.pr.g3.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import dke.pr.cli.CBRInterface;

public class IndexBeanAndi {
	CBRInterface fl;

	public String init() throws IOException {
		try {
			fl = new CBRInterface("C:/Users/Anderas/Flora-2/CBRM/ctxModelAIM.flr",
					"C:/Users/Anderas/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");

			fl.setDebug(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ready";
	}

	public String getCtxs() throws IOException {
		String out = "";
		List<String> contexts = fl.getCtxs();
		for (String element : contexts) {
			out += " " + element + "\n";
		}
		return out;
	}

	public String getCtxHierarchy() throws IOException {
		String out = "";
		List<String[]> hierarchy = fl.getCtxHierarchy();
		for (String[] element : hierarchy) {
			out += " " + element[0] + " unter " + element[1] + "\n";
		}
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

	public String getParameterValues() throws IOException {
		String out = "";
		List<String> parameterValues = fl.getParameterValues();
		for (String element : parameterValues) {
			out += " " + element + "\n";
		}
		return out;
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
	public String getNOTAMS() throws IOException{
		String out = "";
		List<String> NOTAMS = fl.getNOTAMS();
		for (String element : NOTAMS) {
			out += " " + element + "\n";
		}
		return out;
	}
	// public String setParameterValues() {
	// String out = "";
	// fl.addParameter(name, rootValue, detParamDef)
	// return out;
	// }
	//
	// public String getParameter() throws IOException {
	// String out = "";
	// out += fl.getParameters();
	// return out;
	// }
	//
	// public String getParameterValues() throws IOException {
	// String out = "";
	// out += fl.getParameterValues();
	// return out;
	// }
	//
	// public String delParameter() throws IOException {
	// String out = "";
	// fl.delParameter("Interest");
	// out += "delete: Interest";
	// return out;
	// }

	// public String getContextHierarchy() throws IOException {
	// String out = "";
	// List<String[]> hir = fl.getCtxHierarchy();
	// /*
	// * Object[] hier = fl.getCtxHierarchy().toArray(); for(int i = 0; i <
	// * hier.length; i++) { out+=hier[i].toString()+";<br>"; }
	// */
	// String[][] treeBase = new String[hir.size()][2];
	// for (int i = 0; i < hir.size(); i++) {
	// out += "" + hir.get(i).length + " sub: " + hir.get(i)[0] + ", super: " +
	// hir.get(i)[1] + "<br>";
	// treeBase[i][0] = hir.get(i)[0];
	// treeBase[i][1] = hir.get(i)[1];
	// }
	// for (int i = 0; i < treeBase.length; i++) {
	// for (int j = 0; j < treeBase[i].length; j++) {
	// System.out.println(treeBase[i][j]);
	// }
	// }
	// System.out.println();
	// for (int j = 0; j < treeBase.length; j++) {
	// System.out.println(treeBase[j][0] + " " + treeBase[j][1]);
	// }
	// // out += "hierarchy: ";
	// // out += fl.getCtxHierarchy();
	// return out;
	// }
	//
	// public String getContext() throws IOException {
	// String out = "";
	// out += fl.getCtxs();
	// return out;
	// }

}
