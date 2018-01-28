package dke.pr.g3.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import dke.pr.cli.CBRInterface;

public class IndexBean {
	CBRInterface fl;

	public String init() throws IOException {
		try {
			fl = new CBRInterface("C:/Flora-2/CBRM/ctxModelAIM.flr",
					"C:/Flora-2/CBRM/bc.flr", "AIMCtx", "SemNOTAMCase");

			fl.setDebug(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ready";
	}
}
