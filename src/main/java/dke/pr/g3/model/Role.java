package dke.pr.g3.model;

public enum Role {
	RD("Rule Developer"), RA("Repository Admin"), D("Domain Expert"), U("User");
	
	private String role;
	
	private Role(String role) {
		this.role = role;
	}
	
	public String toString() {
		return this.role;
	}
}
