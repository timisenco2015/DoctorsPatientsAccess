package comp3350.tests.business;

import java.util.ArrayList;

import junit.framework.TestCase;
import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessStub;

public class AccessDoctorTest extends TestCase
{

	private static String dbName = Main.dbName;

	public AccessDoctorTest(String arg0)
	{
		super(arg0);
	}

	public void testValidInput()
	{
		DataAccess db;
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		String result = "";
		Doctor doctor;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testValidInput");

		result = db.getAllDoctors(doctors);
		assertEquals(result, null);
		assertFalse(doctors.isEmpty());
		assertEquals(doctors.size(), 3);

		doctors.clear();
		assertTrue(doctors.isEmpty());

		doctor = db.getDoctorByID("351222");
		assertEquals(doctor.getFirstName(), "Max");
		assertEquals(doctor.getLastName(), "Payne");

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNullInput()
	{
		DataAccess db;
		Doctor doctor;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testNullInput");

		doctor = db.getDoctorByID(null);
		assertNull(doctor);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testWrongInput()
	{
		DataAccess db;
		Doctor doctor;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testWrongInput");

		doctor = db.getDoctorByID(" ");
		assertNull(doctor);

		doctor = db.getDoctorByID("532523");
		assertNull(doctor);

		doctor = db.getDoctorByID("!@@%#%^");
		assertNull(doctor);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

}
