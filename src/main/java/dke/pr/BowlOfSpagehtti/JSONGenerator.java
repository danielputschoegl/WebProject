package dke.pr.BowlOfSpagehtti;

import dke.pr.cli.CBRInterface;
import dke.pr.g3.bean.IndexBeanAndi;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;

import dke.pr.cli.CBRInterface;

public class JSONGenerator {

	CBRInterface fl;

	public String getJSON() throws IOException, JSONException {
		String out = "";
		// {source: "Microsoft", target: "Amazon", type: "licensing"},
		// {source: "Nokia", target: "Apple", type: "resolved"},
		// {source: "Oracle", target: "Google", type: "suit"},
		IndexBeanAndi abc = new IndexBeanAndi();
		abc.init();
		out = abc.getCtxHierarchy();

		return out;
	}

	public String getParameterAsJSON() throws IOException, JSONException {
		String out = "";
		// {source: "Microsoft", target: "Amazon", type: "licensing"},
		// {source: "Nokia", target: "Apple", type: "resolved"},
		// {source: "Oracle", target: "Google", type: "suit"},
		IndexBeanAndi abc = new IndexBeanAndi();
		abc.init();
		out = abc.getParameterValuesHiearchy();

		return out;
	}

	public List<JSONObject> createJSONObj() throws IOException, JSONException {
		List<String> strobj = fl.getCtxs();
		List<JSONObject> jobj = null;
		// List<JSONObject> jobj = new List<JSONObject>();
		for (String j : strobj) {
			JSONObject jo = new JSONObject();
			jo.put("name", j);
			jobj.add(jo);
		}
		return jobj;
	}
}
