package comp3350.tests.business;

import junit.framework.TestCase;
import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessStub;

public class AccessEmailTest extends TestCase
{

	private static String dbName = Main.dbName;

	public AccessEmailTest(String arg0)
	{
		super(arg0);
	}

	public void testValidInput()
	{
		DataAccess db;
		Patient patient;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testValidInput");

		patient = db.getEmail("othermike@hotmail.com");
		assertEquals(patient.getFirstName(), "Michael");
		patient = db.getEmail("pinkteddybear@hotmail.com");
		assertEquals(patient.getFirstName(), "Trevor");
		patient = db.getEmail("omgmiranda@aol.com");
		assertEquals(patient.getFirstName(), "John");

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}
}
