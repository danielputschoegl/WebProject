package dke.pr.cli.tests;

import dke.pr.g3.db.DBConnection;

public class testEverything {
	public static void main(String args[]) {
		System.out.println(DBConnection.checkUserInformation("test", "test"));
	}
}
