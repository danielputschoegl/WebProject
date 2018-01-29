package dke.pr.BowlOfSpagehtti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dke.pr.cli.CBRInterface;
import dke.pr.cli.Flora2Interface;

public class TestMain {
	static CBRInterface fl;
	static String out;

	public static void main(String[] args) throws Exception {
		Flora2Interface abc = new Flora2Interface();
		abc.init();

		System.out.println(abc.getISpecs());
		List<String[]> store = abc.getISpecInfo(abc.getISpecs().get(0));

		for (String[] stor : store) {
			System.out.println(stor[0] + ", " + stor[1]);
		}

		List<String> readTargetModule = abc.readTargetModule("m");
		System.out.println(readTargetModule);

		List<String> notams = abc.getNOTAMSAsList();
		System.out.println(notams);

		List<String[]> notaminfos = null;
		for (String notam : notams) {
			notaminfos = abc.getNOTAMInfo(notam);
			for (String[] notaminfo : notaminfos) {
				for (int i = 0; i < notaminfo.length; i++) {
					System.out.print(notaminfo[i] + ", ");
				}
				System.out.println();
			}
		}

		
		
		System.out.println(abc.getISpecs());
		List<String[]> interestSpecClasses = abc.getInterestSpecClass();
		for (String[] interestSpecClass : interestSpecClasses) {
			for (int i = 0; i < interestSpecClass.length; i++) {
				System.out.println(interestSpecClass[i]);
			}
		}

		// newBusinessCase(String bcDef);

		List<String> detRelevantCtxs = abc.detRelevantCtxs("bc1");
		System.out.println(detRelevantCtxs);
		// List<String> readTargetModule = readTargetModule(String
		// targetModule);
		// List<String> detCaseSpecificCtx = detCaseSpecificCtx(String bc,
		// String targetModule);
		// // System.out.println(abc.getCtxs());
		// System.out.println();
		// System.out.println(abc.getCtxHierarchy());
		// System.out.println("ContextFile:");
		// System.out.println(abc.getCtxFile("landplane_onground_runwayClosure"));
		// // System.out.println(abc.getCtxFile("vogel"));
		// System.out.println("Context Info: ");
		// System.out.println(abc.getCtxInfo("landplane_onground_runwayClosure"));
		// System.out.println();
		// System.out.println(abc.getParameters());
		// System.out.println(abc.getParametersAsList());
		// System.out.println();
		// System.out.println(abc.getParameterValues());
		// System.out.println();
		// System.out.println(abc.getParameterParameterValues("EventScenario"));
		// System.out.println();
		// System.out.println(abc.getParameterValuesHiearchy("Nadelbaum"));
		// System.out.println();
		// System.out.println(abc.getDetParamValue("Interest"));
		// System.out.println();
		// // System.out.println(abc.getNOTAMS());
		// System.out.println();
		// System.out.println(abc.getParameterValuesHiearchy());
		// //
		// // System.out.println(abc.delParameterValue("test"));
		// // String ctxDef =
		// //
		// "vogel:AIMCtx[Interest->aircraft,FlightPhase->arrival,EventScenario->closure,file->'C:/Users/Anderas/Flora-2/CBRM/Contexts/vogel.flr'].";
		// // String fCtx = "C:/Users/Anderas/Flora-2/CBRM/Contexts/vogel.flr";
		// // System.out.println(abc.addCtx(ctxDef, fCtx));
		// // System.out.println(abc.delCtx("vogel", true));
		//
		// System.out.println(abc.getRules());
		// ArrayList<String> affe = new ArrayList<String>();
		//
		// for (String a : affe) {
		// System.out.println(a);
		// }
		// System.out.println();
		//
		// System.out.println(abc.getInterestSpecClass());
		// System.out.println(abc.getISpecs());
		// System.out.println(abc.getISpecs());
		// System.out.println(abc.getNOTAMS());
		// System.out.println(abc.addParameter("Katze"));
		// EventscenariotortespecialPortheliport
		// System.out.println(abc.addParameterValue("Ente", "uniTeichEnte", new
		// String[] { "allEnte" }, null));
		// System.out.println(abc.addParameterValue("EventScenario", "torte",
		// new String[] { "specialPort" }, new String[] { "heliport" }));
		// System.out.println(abc.addParameter("Auto", "allAuto",
		// "Auto[detParamValue(?bc)->?v]:-?v=allAuto."));
		// neustart oder so
		// System.out.println(abc.addParameterValue("Auto", "nissangtr", new
		// String[] { "allAuto" }, null));
		// System.out.println(abc.delParameter("Nadelbaum"));
		// System.out.println(abc.delParameterValue("allBaum"));
		// System.out.println(abc.delParameterValue("tanne"));
		// System.out.println(abc.addParameter("Interest", "allBaum",
		// "Interest[detParamValue(?bc)->?v]:-?v=allBaum."));
		// System.out.println(abc.addParameterValue("Interest", "allBaum", new
		// String[] { "area" }, null));
		// System.out.println(abc.getParameterValuesHiearchy("area"));
		// System.out.println(abc.getParameterParameterValues("Nadelbaum"));
		// System.out.println(abc.addParameterValue("Interest", "test",
		// new String[] { "allInterests" }, new String[] {
		// "specifiedAircraft", "area" }));
	}
}
