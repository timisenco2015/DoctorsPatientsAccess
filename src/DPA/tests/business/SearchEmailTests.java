package comp3350.tests.business;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.business.SearchEmail;
import junit.framework.TestCase;
import comp3350.tests.persistence.DataAccessStub;
import comp3350.dpa.persistence.DataAccess;

public class SearchEmailTests extends TestCase
{
	private static String dbName = Main.dbName;

	public SearchEmailTests(String arg0)
	{
		super(arg0);
	}

	public void testNullEmail()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testNullEmail");

		assertEquals(SearchEmail.search(null, db), null);

		System.out.println("...PASSED");

		Services.closeDataAccess();

	}

	public void testNonexistentEmail()
	{
		DataAccess db;
		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testNonexistentEmail");

		assertEquals(SearchEmail.search("duke_4ever@hotmail.com", db), null);

		System.out.println("...PASSED");

		Services.closeDataAccess();
	}

	public void testExistentEmail()
	{
		DataAccess db;
		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testExistentEmail");

		assertEquals(SearchEmail.search("pinkteddybear@hotmail.com", db)
				.getHealthID(), "111025");

		System.out.println("...PASSED");

		Services.closeDataAccess();

	}

	public void testEmptyEmail()
	{
		DataAccess db;
		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testEmptyEmail");

		assertEquals(SearchEmail.search("", db), null);

		System.out.println("...PASSED");

		Services.closeDataAccess();
	}

	public void testInvalidEmail()
	{
		DataAccess db;
		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		System.out.print("\nRunning testInvalidEmail");

		assertEquals(SearchEmail.search("www.website.com", db), null);
		assertEquals(SearchEmail.search("duke_4ever.com@hotmail", db), null);
		assertEquals(SearchEmail.search("gmail.duke_4ever@com", db), null);
		assertEquals(SearchEmail.search("gmail.hotmail@.com", db), null);
		assertEquals(SearchEmail.search("@.com", db), null);

		System.out.println("...PASSED");
		Services.closeDataAccess();

	}
}