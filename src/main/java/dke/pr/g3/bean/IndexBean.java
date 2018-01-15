//package dke.pr.g3.gui;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import dke.pr.cli.CBRInterface;
//
//public class IndexBean {
//	public String getData() {
//		CBRInterface fl;
//		String out = "";
//		try {
//			fl = new CBRInterface("C:/Users/Anderas/Flora-2/flora2/OO/ctxModelAIM.flr",
//					"C:/Users/Anderas/Flora-2/flora2/OO/bc.flr", "AIMCtx", "SemNOTAMCase");
//			//			fl = new CBRInterface("C:/Users/Uni/Flora-2/CBRM/ctxModelAIM.flr", "C:/Users/Uni/Flora-2/CBRM/bc.flr",
//			//		"AIMCtx", "SemNOTAMCase");
//
//			fl.setDebug(false);
//
//			out += ("addCtx:     " + fl.addCtx(
//					"${aircraft_arrival_closure:AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'OO/Contexts/aircraft_arrival_closure.flr']@ctxModel}"));
//			out += ("Contexts:   " + fl.getCtxs());
//
//			out += ("\ndelCtx:     " + fl.delCtx("aircraft_onground_closure"));
//			out += ("Contexts:   " + fl.getCtxs());
//
//			out += ("\nUnusedVal:  " + fl.detUnusedParameterValues());
//
//			out += ("\ndelCtx:     " + fl.delCtx("helicopter_allFlightPhases_obstruction"));
//			out += ("Contexts:   " + fl.getCtxs());
//
//			out += ("\naddParam:   " + fl.addParameter("MeteorologicalCondition",
//					"allMeteorologicalConditions",
//					"${(MeteorologicalCondition[detParamValue(?bc)->?v]:-?v=allMeteorologicalConditions)@ctxModel}"));
//			out += ("Params:     " + fl.getParameters());
//
//			out += ("\ndelParam:   " + fl.delParameter("MeteorologicalCondition"));
//			out += ("Params:     " + fl.getParameters());
//			out += ("Values:     " + fl.getParameterValues());
//			out += ("CTx Infor:  ");
//			for (String[] strings : fl.getCtx("aircraft_allFlightPhases_obstruction")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//			out += ("\n\ndelParam:   " + fl.delParameter("FlightPhase"));
//			out += ("Params:     " + fl.getParameters());
//			out += ("Values:     " + fl.getParameterValues());
//			out += ("CTx Infor:  ");
//			for (String[] strings : fl.getCtx("aircraft_allFlightPhases_obstruction")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//			out += ("\n\naddvalLeaf: " + fl.addParameterValueLeaf("area", "aerodrome"));
//			out += ("Val Hier:   ");
//			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//			out += ("\n\naddValNode: " + fl.addParameterValueNode("aircraft", "specifiedAircraft",
//					new String[] { "landplane", "seaplane", "helicopter" }));
//			out += ("Val Hier:   ");
//			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//			out += ("\n\naddValRoot: " + fl.addParameterValueRoot("events", "allEventScenarios"));
//			out += ("Val Hier:   ");
//			for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//			out += ("\n\ndelValTree: " + fl.delParameterValueSubgraph("closure"));
//			out += ("Val Hier:   ");
//			for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//			out += ("\ndelCtxByVal:" + fl.delCtxByParameterValue());
//			out += ("Contexts:   " + fl.getCtxs());
//
//			out += ("\n\ndelVal:     " + fl.delParameterValue("aircraft"));
//			out += ("Val Hier:   ");
//			for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//			out += ("\nupdCtxByVal:" + fl.modifyCtxByParameterValue("aircraft", "landplane"));
//			out += ("context:    ");
//			for (String[] strings : fl.getCtx("aircraft_onground_aerodromeEquipment")) {
//				out += (Arrays.toString(strings) + ", ");
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return out;
//	}
//}
