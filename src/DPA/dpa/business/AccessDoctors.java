package comp3350.dpa.business;

import java.util.List;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.persistence.DataAccess;

public class AccessDoctors
{
	private DataAccess dataAccess;

	public AccessDoctors()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
	}

	public String getDoctors(List<Doctor> doctors)
	{
		doctors.clear();
		return dataAccess.getAllDoctors(doctors);
	}

	public Doctor getDoctorByID(String id)
	{
		return dataAccess.getDoctorByID(id);
	}
}
