package dke.pr.g3.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "notamDetails", eager = true)
@ViewScoped
public class NotamDetailsBean {
	// gibt notam nicht mit

	private Flora2Interface flora = new Flora2Interface();
	private Map<String, String> notamDetails;
	private String notam;

	public Map<String, String> getNotamDetails() throws Exception {
		if (this.notamDetails == null) {
			flora.init();
			notamDetails = new HashMap<String, String>();
			List<String[]> notamInfos = flora.getNOTAMInfo(this.notam);
			for (String[] notamInfo : notamInfos) {
				notamDetails.put(notamInfo[0], notamInfo[1]);
			}
		}
		return this.notamDetails;
	}

	public String getNotam() {
		return notam;
	}

	public void setNotamDetails(Map<String, String> notamDetails) {
		this.notamDetails = notamDetails;
	}

	public void setNotam(String notam) {
		this.notam = notam;
	}
}