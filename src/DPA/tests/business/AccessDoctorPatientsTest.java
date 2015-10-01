package comp3350.tests.business;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessStub;

public class AccessDoctorPatientsTest extends TestCase
{

	private static String dbName = Main.dbName;

	public AccessDoctorPatientsTest(String arg0)
	{
		super(arg0);
	}

	public void testValidInput()
	{
		DataAccess db;
		List<DoctorPatients> dp = new ArrayList<DoctorPatients>();

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testValidInput");

		dp = db.getDoctorPatientsByDoctorID("933206");
		assertEquals(dp.size(), 3);
		assertEquals(dp.get(0).getPatientID(), "110211");
		assertEquals(dp.get(1).getPatientID(), "999199");
		assertEquals(dp.get(2).getPatientID(), "663112");

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNullInput()
	{
		DataAccess db;
		List<DoctorPatients> dp = new ArrayList<DoctorPatients>();

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testNullInput");

		dp = db.getDoctorPatientsByDoctorID(null);
		assertTrue(dp.isEmpty());

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testWrongInput()
	{
		DataAccess db;
		List<DoctorPatients> dp = new ArrayList<DoctorPatients>();

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testWrongInput");

		dp = db.getDoctorPatientsByDoctorID("!@$#@%");
		assertTrue(dp.isEmpty());

		dp = db.getDoctorPatientsByDoctorID("333333");
		assertTrue(dp.isEmpty());

		dp = db.getDoctorPatientsByDoctorID(" ");
		assertTrue(dp.isEmpty());

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

}
