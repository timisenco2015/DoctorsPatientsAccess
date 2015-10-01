package comp3350.dpa.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.PatientPrescription;
import comp3350.dpa.persistence.DataAccess;

public class AccessPatientPrescriptions {
	private DataAccess dataAccess;
	
    private String result;
    private ArrayList<PatientPrescription> patientprescs;
	

	private String gpa;

	public AccessPatientPrescriptions()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
		
		
	}

	public List<PatientPrescription> PatientPresc(String healthID )
	{
		
		return dataAccess.getPatientPrescriptions(healthID);
					
	}

}
