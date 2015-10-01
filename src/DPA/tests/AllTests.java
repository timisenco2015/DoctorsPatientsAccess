package comp3350.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import comp3350.tests.business.BusinessTests;
import comp3350.tests.objects.ObjectTests;
import comp3350.tests.persistence.PersistenceTests;

public class AllTests
{
	public static TestSuite suite;

	public static Test suite()
	{
		suite = new TestSuite("All tests");
		suite.addTest(BusinessTests.suite());
		suite.addTest(ObjectTests.suite());
		suite.addTest(PersistenceTests.suite());

		System.out.println("\nRunning Test Suite...\n");
		System.out.println("---------------------------");

		return suite;
	}
}
