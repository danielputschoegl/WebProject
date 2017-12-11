package dke.pr.g3;

public enum Status {
	U("undealt"), P("in progress"), R("rejected"), C("completed");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
