package comp3350.tests.business;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.business.SearchPatients;
import comp3350.dpa.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessStub;
import junit.framework.TestCase;

public class SearchPatientsTest extends TestCase
{
	private static String dbName = Main.dbName;
	SearchPatients sPatient;

	public SearchPatientsTest(String arg0)
	{
		super(arg0);
	}

	public void testNullString()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		sPatient = new SearchPatients(" ");
		System.out.print("\nRunning testNullNames");

		assertEquals(sPatient.validCheck(), 1);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNotNullString()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		sPatient = new SearchPatients("Ayobami Idowu ");
		System.out.print("\nRunning testNotNullString");
		assertNotSame(sPatient.validCheck(), 1);

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNotValidValue()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		sPatient = new SearchPatients("ayo@bami @idow-u ");
		System.out.print("\nRunning testNotValidValue");

		assertEquals(sPatient.validCheck(), 2);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testValidValue()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		sPatient = new SearchPatients("Ayobami Idowu ");
		System.out.print("\nRunning testValidValue");
		assertNotSame(sPatient.validCheck(), 2);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNotFullNames()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		System.out.print("\nRunning testNotFullnames");
		sPatient = new SearchPatients("Ayobami");
		assertEquals(sPatient.validCheck(), 3);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testFullNames()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		System.out.print("\nRunning testFullnames");
		sPatient = new SearchPatients("Ayobami Idowu ");

		assertNotSame(sPatient.validCheck(), 3);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNullPatientList()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		System.out.print("\nRunning testNullPatientList");
		sPatient = new SearchPatients("Ayobai Idwu");
		sPatient.getPatientsByNames();
		assertEquals(sPatient.getPatientsByNames().size(), 0);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

	public void testNotNullPatientList()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));
		System.out.print("\nRunning testNotNullPatientList");
		sPatient = new SearchPatients("Master Chief");

		assertNotSame(sPatient.getPatientsByNames(), 0);
		System.out.println("...PASSED");
		Services.closeDataAccess();
	}

}
