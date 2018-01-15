package dke.pr.g3.model;

public enum Role {
	RD("rule developer"), RA("repository admin"), D("domain expert"), U("user");
	
	private String role;
	
	private Role(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
