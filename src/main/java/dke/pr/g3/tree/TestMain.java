package dke.pr.g3.tree;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONWriter;

import dke.pr.cli.CBRInterface;
import dke.pr.g3.bean.IndexBeanAndi;

public class TestMain {
	static CBRInterface fl;
	static String out;

	public static void main(String[] args) throws Exception {
		// try {
		// fl = new CBRInterface("C:/Users/Anderas/Flora-2/CBRM/ctxModelAIM.flr",
		// "C:/Users/Anderas/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");
		//
		// fl.setDebug(false);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		IndexBeanAndi abc = new IndexBeanAndi();
		abc.init();
		System.out.println(abc.getCtxs());
		System.out.println();
		System.out.println(abc.getCtxHierarchy());
		System.out.println();
		System.out.println(abc.getCtxFile("landplane_onground_runwayClosure"));
		System.out.println();
		System.out.println(abc.getCtxInfo("landplane_onground_runwayClosure"));
		System.out.println();
		System.out.println(abc.getParameters());
		System.out.println();
		System.out.println(abc.getParameterValues());
		System.out.println();
		System.out.println(abc.getParameterParameterValues("EventScenario"));
		System.out.println();
		System.out.println(abc.getParameterValuesHiearchy("EventScenario"));
		System.out.println();
		System.out.println(abc.getDetParamValue("FlightPhase"));
		System.out.println();
		System.out.println(abc.getNOTAMS());
		System.out.println();

		// List<String[]> hir;
		//
		// hir = fl.getCtxHierarchy();
		// String message = "";
		// String[][] treeBase = new String[hir.size()][2];
		// for (int i = 0; i < hir.size(); i++) {
		// out = "" + hir.get(i).length + " sub: " + hir.get(i)[0] + ", super: " +
		// hir.get(i)[1] + "<br>";
		// treeBase[i][0] = hir.get(i)[0];
		// treeBase[i][1] = hir.get(i)[1];
		// System.out.println(treeBase[i][0] + " vs " + treeBase[i][1]);
		// // System.out.println(treeBase[i][0].hashCode() + " vs " +
		// // treeBase[i][1].hashCode() );
		// }
		// boolean heady = true;
		// String head = "";
		// for (int i = 0; i < treeBase.length; i++) {
		// heady = true;
		// for (int j = 0; j < treeBase.length; j++) {
		// // System.out.println(treeBase[i][1] + " vs " + treeBase[j][0]);
		// // System.out.println(i + " vs " + j);
		// if (treeBase[i][1].equals(treeBase[j][0])) {
		// System.out.println("heady:" + treeBase[i][0]);
		// heady = false;
		// }
		// }
		// if (heady) {
		// System.out.println("top:" + treeBase[i][1]);
		// head = treeBase[i][1];
		// }
		// }
		// boolean connectedToTwo = false;
		// int count = 0;
		// for (int i = 0; i < treeBase.length; i++) {
		// count = 0;
		// for (int j = 0; j < treeBase.length; j++) {
		// if (treeBase[i][0].equals(treeBase[j][0])) {
		// if (treeBase[j][0].equals(head)) {
		// treeBase[j][1] = null;
		// }
		// count++;
		// }
		// }
		// if (count > 1) {
		// System.out.println("doppelt:" + treeBase[i][0]);
		// }
		// }
		//
		// JSONObject jo = new JSONObject();
		// JSONObject jojo = new JSONObject();
		// JSONArray ja = new JSONArray();
		// JSONArray jaja = new JSONArray();
		// jo.put("name", "Andreas");
		// jojo.put("name", "Stranger");
		// ja.put(jo);
		// ja.put(jojo);
		// jaja.put(jo);
		// jaja.put(jojo);
		// ja.put(jaja);
		//
		// JSONObject end = new JSONObject();
		// end.put("name", "Peter");
		// end.put("children", ja);
		//
		// System.out.println(end.toString());
		//
		// System.out.println("Hallo!");
		// System.out.println(message);
		//
		// List<JSONObject> herbert = createJSONObj();
		// for (JSONObject o : herbert) {
		// System.out.println(o.toString());
		// }
		// }
		//
		// public static List<JSONObject> createJSONObj() throws IOException,
		// JSONException {
		// List<String> strobj = fl.getCtxs();
		// List<JSONObject> jobj = new ArrayList<JSONObject>();
		// // List<JSONObject> jobj = new List<JSONObject>();
		// for (String j : strobj) {
		// JSONObject jo = new JSONObject();
		// jo.put("name", j);
		// jobj.add(jo);
		// }
		// return jobj;
		//
	}
}
