package comp3350.tests.business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BusinessTests
{
	public static TestSuite suite;

	public static Test suite()
	{
		suite = new TestSuite("Business tests");
		suite.addTestSuite(SearchEmailTests.class);
		suite.addTestSuite(SearchPatientsTest.class);
		suite.addTestSuite(AccessPatientsTest.class);
		suite.addTestSuite(AccessDoctorTest.class);
		suite.addTestSuite(AccessDoctorPatientsTest.class);
		suite.addTestSuite(AccessEmailTest.class);
		return suite;
	}
}
