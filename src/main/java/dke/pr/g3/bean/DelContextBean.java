package dke.pr.g3.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "delContext", eager = true)
@ViewScoped
public class DelContextBean {
	IndexBeanAndi bean = new IndexBeanAndi();
	String contextname;

	public String delete() throws IOException {

		try {
			bean.init();
			bean.delCtx(contextname, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index?faces-redirect=true";
	}

	public String getContextname() {
		return contextname;
	}

	public void setContextname(String parametername) {
		this.contextname = parametername;
	}
}
