package comp3350.dpa.business;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.persistence.DataAccess;

public class AccessEmail
{
	private DataAccess db;

	public AccessEmail()
	{
		db = Services.getDataAccess(Main.dbName);
	}

	public Patient getEmail(String email)
	{
		Patient patient = null;

		patient = SearchEmail.search(email, db);

		return patient;
	}

}
