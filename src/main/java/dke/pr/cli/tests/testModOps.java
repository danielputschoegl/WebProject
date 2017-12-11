package dke.pr.cli.tests;

import java.io.IOException;
import java.util.Arrays;

import dke.pr.cli.CBRInterface;

public class testModOps {

	public static void main(String[] args) throws IOException {
		CBRInterface fl = new CBRInterface("C:/Users/Uni/Flora-2/CBRM/ctxModelAIM.flr",
				"C:/Users/Uni/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");

		fl.setDebug(false);

		System.out
				.println("addCtx:     "
						+ fl.addCtx("${aircraft_arrival_closure:AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'OO/Contexts/aircraft_arrival_closure.flr']@ctxModel}"));
		System.out.println("Contexts:   " + fl.getCtxs());

		System.out.println("\ndelCtx:     "
				+ fl.delCtx("aircraft_onground_closure"));
		System.out.println("Contexts:   " + fl.getCtxs());

		System.out.println("\nUnusedVal:  " + fl.detUnusedParameterValues());

		System.out.println("\ndelCtx:     "
				+ fl.delCtx("helicopter_allFlightPhases_obstruction"));
		System.out.println("Contexts:   " + fl.getCtxs());

		System.out
				.println("\naddParam:   "
						+ fl.addParameter(
								"MeteorologicalCondition",
								"allMeteorologicalConditions",
								"${(MeteorologicalCondition[detParamValue(?bc)->?v]:-?v=allMeteorologicalConditions)@ctxModel}"));
		System.out.println("Params:     " + fl.getParameters());

		System.out.println("\ndelParam:   "
				+ fl.delParameter("MeteorologicalCondition"));
		System.out.println("Params:     " + fl.getParameters());
		System.out.println("Values:     " + fl.getParameterValues());
		System.out.print("CTx Infor:  ");
		for (String[] strings : fl
				.getCtx("aircraft_allFlightPhases_obstruction")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}

		System.out.println("\n\ndelParam:   " + fl.delParameter("FlightPhase"));
		System.out.println("Params:     " + fl.getParameters());
		System.out.println("Values:     " + fl.getParameterValues());
		System.out.print("CTx Infor:  ");
		for (String[] strings : fl
				.getCtx("aircraft_allFlightPhases_obstruction")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}

		System.out.println("\n\naddvalLeaf: "
				+ fl.addParameterValueLeaf("area", "aerodrome"));
		System.out.print("Val Hier:   ");
		for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}

		System.out
				.println("\n\naddValNode: "
						+ fl.addParameterValueNode("aircraft",
								"specifiedAircraft", new String[] {
										"landplane", "seaplane", "helicopter" }));
		System.out.print("Val Hier:   ");
		for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}

		System.out.println("\n\naddValRoot: "
				+ fl.addParameterValueRoot("events", "allEventScenarios"));
		System.out.print("Val Hier:   ");
		for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}

		System.out.println("\n\ndelValTree: "
				+ fl.delParameterValueSubgraph("closure"));
		System.out.print("Val Hier:   ");
		for (String[] strings : fl.getParameterValuesHiearchy("EventScenario")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}
		System.out.println("\ndelCtxByVal:" + fl.delCtxByParameterValue());
		System.out.println("Contexts:   " + fl.getCtxs());

		System.out.println("\n\ndelVal:     " + fl.delParameterValue("aircraft"));
		System.out.print("Val Hier:   ");
		for (String[] strings : fl.getParameterValuesHiearchy("Interest")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}
		System.out.println("\nupdCtxByVal:"
				+ fl.modifyCtxByParameterValue("aircraft", "landplane"));
		System.out.print("context:    ");
		for (String[] strings : fl
				.getCtx("aircraft_onground_aerodromeEquipment")) {
			System.out.print(Arrays.toString(strings) + ", ");
		}
	}

}
