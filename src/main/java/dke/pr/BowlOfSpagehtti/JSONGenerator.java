package dke.pr.BowlOfSpagehtti;

import dke.pr.cli.CBRInterface;
import dke.pr.cli.Flora2Interface;

import java.io.IOException;

public class JSONGenerator {

	CBRInterface fl;

	public static String getJSON() throws IOException {
		return "test";
	}

	public String getParameterAsJSON() throws IOException {
		String out = "";
		Flora2Interface abc = new Flora2Interface();
		abc.init();
		out = abc.getParameterValuesHiearchy();
		return out;
	}

	public String getContextsAsJSON() throws IOException {
		String out = "";
		Flora2Interface abc = new Flora2Interface();
		abc.init();
		out = abc.getCtxHierarchy();
		return out;
	}

	// public List<JSONObject> createJSONObj() throws IOException, JSONException
	// {
	// List<String> strobj = fl.getCtxs();
	// List<JSONObject> jobj = null;
	// for (String j : strobj) {
	// JSONObject jo = new JSONObject();
	// jo.put("name", j);
	// jobj.add(jo);
	// }
	// return jobj;
	// }
}
