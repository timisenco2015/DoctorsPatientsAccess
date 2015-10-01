package comp3350.dpa.business;

import java.util.List;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.persistence.DataAccess;

public class AccessDoctorPatients
{
	private DataAccess dataAccess;

	public AccessDoctorPatients()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
	}

	public List<DoctorPatients> getDoctorPatientsByDoctorID(String id)
	{
		return dataAccess.getDoctorPatientsByDoctorID(id);
	}
}
