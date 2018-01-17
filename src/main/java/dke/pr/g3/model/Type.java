package dke.pr.g3.model;

public enum Type {
	S("Standard"), C("Confirmation"), A("Adjustmenet");
	
	private String type;
	
	private Type(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
}
