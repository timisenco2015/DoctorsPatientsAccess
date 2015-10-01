package comp3350.tests.business;

import java.util.ArrayList;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Patient;
import comp3350.tests.persistence.DataAccessStub;
import comp3350.dpa.persistence.DataAccess;
import junit.framework.TestCase;

public class AccessPatientsTest extends TestCase
{

	private static String dbName = Main.dbName;

	public AccessPatientsTest(String arg0)
	{
		super(arg0);
	}

	public void testValidInput()
	{
		DataAccess db;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		String result = "";
		Patient patient;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testValidInput");

		assertTrue(patients.isEmpty());
		patients = db.getSpecificPatients("Michael", "DeSanta");
		assertFalse(patients.isEmpty());
		assertEquals(patients.size(), 2);

		patients.clear();
		assertTrue(patients.isEmpty());

		result = db.getAllPatients(patients);
		assertEquals(result, null);
		assertFalse(patients.isEmpty());
		assertEquals(patients.size(), 7);

		patients.clear();
		assertTrue(patients.isEmpty());

		patient = db.getPatientByID("110211");
		assertEquals(patient.getFirstName(), "Super");
		assertEquals(patient.getLastName(), "Mario");

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNullInput()
	{
		DataAccess db;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		Patient patient;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testNullInput");

		assertTrue(patients.isEmpty());
		patients = db.getSpecificPatients(null, null);
		assertTrue(patients.isEmpty());

		patient = db.getPatientByID(null);
		assertNull(patient);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testWrongInput()
	{
		DataAccess db;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		Patient patient;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testWrongInput");

		assertTrue(patients.isEmpty());
		patients = db.getSpecificPatients("Vinni", "Gognitti");
		assertTrue(patients.isEmpty());

		patient = db.getPatientByID("987654321");
		assertNull(patient);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

}
