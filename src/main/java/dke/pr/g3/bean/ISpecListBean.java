package dke.pr.g3.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dke.pr.cli.Flora2Interface;

@ManagedBean(name = "iSpecList", eager = true)
@ViewScoped
public class ISpecListBean {
	private Flora2Interface flora = new Flora2Interface();
	private List<String> specifications;
	private String specificationName;

	public List<String> getSpecifications() throws IOException {
		if (this.specifications == null) {
			this.specifications = new ArrayList<String>();
			flora.init();
			List<String[]> store = flora.getISpecInfo(flora.getISpecs().get(0));

			for (String[] stor : store) {
				this.specifications.add(stor[0] + " --> " + stor[1]);
			}
		}
		return this.specifications;
	}

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

}
