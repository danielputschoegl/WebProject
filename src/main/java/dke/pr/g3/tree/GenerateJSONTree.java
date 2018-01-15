package dke.pr.g3.tree;

import dke.pr.cli.CBRInterface;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;

import dke.pr.cli.CBRInterface;

public class GenerateJSONTree {

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

	public String getJSONTree() throws IOException, JSONException {
		String out = "";
		String jey = "";
		List<String[]> hir;

		hir = fl.getCtxHierarchy();

		/*
		 * Object[] hier = fl.getCtxHierarchy().toArray(); for(int i = 0; i <
		 * hier.length; i++) { out+=hier[i].toString()+";<br>"; }
		 */
		String[][] treeBase = new String[hir.size()][2];
		for (int i = 0; i < hir.size(); i++) {
			out += "" + hir.get(i).length + " sub: " + hir.get(i)[0] + ", super: " + hir.get(i)[1] + "<br>";
			treeBase[i][0] = hir.get(i)[0];
			treeBase[i][1] = hir.get(i)[1];
		}
		for (int i = 0; i < treeBase.length; i++) {
			for (int j = 0; j < treeBase[i].length; j++) {
				System.out.println(treeBase[i][j]);
			}
		}
		System.out.println();
		for (int j = 0; j < treeBase.length; j++) {
			System.out.println(treeBase[j][0] + " " + treeBase[j][1]);
		}
		// out += "hierarchy: ";
		// out += fl.getCtxHierarchy();

		JSONObject jsonObj = new JSONObject();

		String message;
		JSONObject json = new JSONObject();
		json.put("name", "Herbert");
		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject();
		item.put("name", "test");
		array.put(item);

		json.put("children:", array);

		out = json.toString();
		return out;
	}

	public JSONObject happy() throws JSONException {

		JSONObject jo = new JSONObject();
		JSONObject jojo = new JSONObject();
		JSONObject io = new JSONObject();
		JSONObject ioio = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONArray jaja = new JSONArray();
		jo.put("name", "Andreas");
		jojo.put("name", "Stranger");
		io.put("name", "Andreas");
		ioio.put("name", "Stranger");
		ja.put(jo);
		ja.put(jojo);
		jaja.put(io);
		jaja.put(ioio);
		ja.put(jaja);

		JSONObject a = new JSONObject();
		a.put("name", "A");
		JSONObject b = new JSONObject();
		b.put("name", "B");
		JSONObject c = new JSONObject();
		c.put("name", "C");
		JSONObject d = new JSONObject();
		d.put("name", "D");
		JSONObject e = new JSONObject();
		e.put("name", "E");
		JSONObject f = new JSONObject();
		f.put("name", "F");
		JSONObject g = new JSONObject();
		g.put("name", "G");
		JSONObject h = new JSONObject();
		h.put("name", "H");

		JSONArray c1 = new JSONArray();
		c1.put(h);
		c.put("children", c1);
		JSONArray b1 = new JSONArray();
		b1.put(d);
		b1.put(e);
		b1.put(f);
		b.put("children", b1);
		JSONArray a1 = new JSONArray();
		a1.put(b);
		a1.put(c);
		a1.put(g);
		a.put("children", a1);

		JSONObject end = new JSONObject();
		end.put("name", "Peter");
		end.put("children", ja);
		return a;
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
