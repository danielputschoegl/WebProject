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
