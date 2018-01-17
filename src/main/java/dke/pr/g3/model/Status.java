package dke.pr.g3.model;

public enum Status {
	U("Undealt"), P("In progress"), R("Rejected"), C("Completed");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String toString() {
		return status;
	}
}
