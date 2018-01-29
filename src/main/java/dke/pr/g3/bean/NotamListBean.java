package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "notamList", eager = true)
@ViewScoped
public class NotamListBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> notams;
	private String notamName;

	// public void delete(String notam) throws IOException {
	// try {
	// flora.init();
	// flora.delParameter(parameter);
	// this.notams = flora.getNOTAMSAsList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// public String getNotamInfo(String notam) throws IOException {
	// flora.init();
	// return flora.getNOTAMInfo(notam);
	// }

	public List<String> getNotams() throws IOException {
		if (this.notams == null) {
			flora.init();
			this.notams = flora.getNOTAMSAsList();
		}
		return this.notams;
	}

	public String getNotamName() {
		return notamName;
	}

	public void setNotamName(String notamName) {
		this.notamName = notamName;
	}

}
