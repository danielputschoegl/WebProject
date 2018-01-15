package dke.pr.g3.model;

public enum Type {
	S("standard"), C("confirmation"), A("adjustmenet");
	
	private String type;
	
	private Type(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
