package comp3350.tests.business;

import java.util.ArrayList;

import junit.framework.TestCase;
import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.business.ValidationCheck;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Prescription;
import comp3350.dpa.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessStub;
import comp3350.dpa.business.AccessPrescriptions;

public class AccessPrescriptionsTest extends TestCase {


	private static String dbName = Main.dbName;

	public AccessPrescriptionsTest(String arg0)
	{
		super(arg0);
	}

public void testNullInput()
{
	DataAccess db;
    String pName = null;
    String pDosage = null;
    int pRefills = 0;
    String healthId = null;
    Prescription pres = null;
    AccessPrescriptions prescAcess;

	db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
	 prescAcess = new AccessPrescriptions();
	System.out.print("\nRunning testNullInput");
//	public String addPrescription(String pName, String pDosage, int pRefills,
	//		String healthID)
	//{
	//	return accessPatient.addPrescription(pName, pDosage, pRefills, healthID);
	//} 
	
	assertNull(pres);
	pres =  prescAcess.getPrescription(pName, healthId);
			
	
	assertNull(pres);

	System.out.println("...PASSED");
	Services.closeDataAccess();
}


}
