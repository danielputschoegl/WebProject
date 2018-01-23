package dke.pr.g3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cart")
@SessionScoped
public class CartBean {

	private List<String> items;

	public CartBean() {
		items = new ArrayList<>();
		items.add("shirt");
		items.add("skirt");
		items.add("trouser");
	}

	public List<String> getItems() {
		return items;
	}

}