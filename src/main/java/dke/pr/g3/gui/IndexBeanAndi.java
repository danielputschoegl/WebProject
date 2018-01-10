package dke.pr.g3.gui;

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

	public String detUnusedParameterValues() throws IOException {
		String out = "";
		out += ("UnusedVal:  " + fl.detUnusedParameterValues());
		return out;
	}

	public String newBC() throws IOException {
		String out = "";

		out += "new BusinessCase: Andi<br>";
		out += "" + fl.newBusinessCase("Andi");
		return out;
	}

	// public String setParameterValues() {
	// String out = "";
	// fl.addParameter(name, rootValue, detParamDef)
	// return out;
	// }
	//
	public String getParameter() throws IOException {
		String out = "";
		out += fl.getParameters();
		return out;
	}
	
	public String getParameterValues() throws IOException {
		String out = "";
		out += fl.getParameterValues();
		return out;
	}

	public String delParameter() throws IOException {
		String out = "";
		fl.delParameter("Interest");
		out += "delete: Interest";
		return out;
	}

	public String getContextHierarchy() throws IOException {
		String out = "";
		List<String[]> hir = fl.getCtxHierarchy();
		/*
		 * Object[] hier = fl.getCtxHierarchy().toArray(); for(int i = 0; i <
		 * hier.length; i++) { out+=hier[i].toString()+";<br>"; }
		 */
		String[][] treeBase = new String [hir.size()][2];
		for (int i = 0; i < hir.size(); i++) {
			out += ""+ hir.get(i).length + " sub: " + hir.get(i)[0] + ", super: " + hir.get(i)[1] + "<br>";
			treeBase[i][0] = hir.get(i)[0];
			treeBase[i][1] = hir.get(i)[1];
		}
		for(int i = 0; i < treeBase.length;i++) {
			for(int j = 0; j < treeBase[i].length;j++) {
				System.out.println(treeBase[i][j]);
			}
		}
		System.out.println();
		for(int j = 0; j < treeBase.length;j++) {
			System.out.println(treeBase[j][0] + " " + treeBase[j][1]);
		}
		// out += "hierarchy: ";
		// out += fl.getCtxHierarchy();
		return out;
	}

	
	
	public String getContext() throws IOException {
		String out = "";
		out += fl.getCtxs();
		return out;
	}

	public String delContext() throws IOException {
		String out = "";
		fl.delCtx("landplane_onground_runwayClosure");
		out += "delete: landplane_onground_runwayClosure";
		return out;
	}

	/*
	 * Funktioniert noch nicht ganz, weil anscheinend keine Schreibrechte
	 */
	public String addContext() throws IOException {
		String out = "";
		out += ("addCtx:     " + fl.addCtx(
				"${aircraft_name:AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'OO/Contexts/aircraft_name.flr']@ctxModel}"));
		return out;
	}

	public String getData() {

		String out = "";
		try {

			out += ("addCtx:     " + fl.addCtx(
					"${aircraft_arrival_closure:AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'OO/Contexts/aircraft_arrival_closure.flr']@ctxModel}"));
			out += ("Contexts:   " + fl.getCtxs());

			out += ("\ndelCtx:     " + fl.delCtx("aircraft_onground_closure"));
			out += ("Contexts:   " + fl.getCtxs());

			out += ("\nUnusedVal:  " + fl.detUnusedParameterValues());

			out += ("\ndelCtx:     " + fl.delCtx("helicopter_allFlightPhases_obstruction"));
			out += ("Contexts:   " + fl.getCtxs());

			out += ("\naddParam:   " + fl.addParameter("MeteorologicalCondition", "allMeteorologicalConditions",
					"${(MeteorologicalCondition[detParamValue(?bc)->?v]:-?v=allMeteorologicalConditions)@ctxModel}"));
			out += ("Params:     " + fl.getParameters());

			out += ("\ndelParam:   " + fl.delParameter("MeteorologicalCondition"));
			out += ("Params:     " + fl.getParameters());
			out += ("Values:     " + fl.getParameterValues());
			out += ("CTx Infor:  ");
			for (String[] strings : fl.getCtx("aircraft_allFlightPhases_obstruction")) {
				out += (Arrays.toString(strings) + ", ");
			}

			out += ("\n\ndelParam:   " + fl.delParameter("FlightPhase"));
			out += ("Params:     " + fl.getParameters());
			out += ("Values:     " + fl.getParameterValues());
			out += ("CTx Infor:  ");
			for (String[] strings : fl.getCtx("aircraft_allFlightPhases_obstruction")) {
				out += (Arrays.toString(strings) + ", ");
			}

			out += ("\n\naddvalLeaf: " + fl.addParameterValueLeaf("area", "aerodrome"));
			out += ("Val Hier:   ");
			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
				out += (Arrays.toString(strings) + ", ");
			}
			
			out += ("\n\naddValNode: " + fl.addParameterValueNode("aircraft", "specifiedAircraft",
					new String[] { "landplane", "seaplane", "helicopter" }));
			out += ("Val Hier:   ");
			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
				out += (Arrays.toString(strings) + ", ");
			}

			out += ("\n\naddValRoot: " + fl.addParameterValueRoot("events", "allEventScenarios"));
			out += ("Val Hier:   ");
			for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
				out += (Arrays.toString(strings) + ", ");
			}

			out += ("\n\ndelValTree: " + fl.delParameterValueSubgraph("closure"));
			out += ("Val Hier:   ");
			for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
				out += (Arrays.toString(strings) + ", ");
			}
			out += ("\ndelCtxByVal:" + fl.delCtxByParameterValue());
			out += ("Contexts:   " + fl.getCtxs());

			out += ("\n\ndelVal:     " + fl.delParameterValue("aircraft"));
			out += ("Val Hier:   ");
			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
				out += (Arrays.toString(strings) + ", ");
			}
			out += ("\nupdCtxByVal:" + fl.modifyCtxByParameterValue("aircraft", "landplane"));
			out += ("context:    ");
			for (String[] strings : fl.getCtx("aircraft_onground_aerodromeEquipment")) {
				out += (Arrays.toString(strings) + ", ");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}
}
