package dke.pr.g3.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "delContext", eager = true)
@ViewScoped
public class DelContextBean {
	Flora2Interface bean = new Flora2Interface();
	
	@PostConstruct
	public void init() throws IOException {
		bean.init();
	}

	public String delete(String ctx) throws IOException {

		try {
			bean.init();
			bean.delCtx(ctx, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bean.restart();
		return "delContext?faces-redirect=true";
	}
	
	public List<String> getContexts() throws IOException {
		bean.init();
		return bean.getCtxs();
	}
}
