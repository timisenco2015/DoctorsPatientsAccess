package comp3350.dpa.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.persistence.DataAccess;

public class AccessPatients
{
	private DataAccess dataAccess;

	public AccessPatients()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
	}

	public String getPatients(List<Patient> patients)
	{
		patients.clear();
		return dataAccess.getAllPatients(patients);
	}

	public ArrayList<Patient> getPatientByNames(String firstName, String lastName)
	{
		return dataAccess.getSpecificPatients(firstName, lastName);
	}

	public Patient getPatientByID(String id)
	{
		return dataAccess.getPatientByID(id);
	}

}
