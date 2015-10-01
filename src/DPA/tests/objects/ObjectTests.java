package comp3350.tests.objects;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ObjectTests
{
	public static TestSuite suite;

	public static Test suite()
	{
		suite = new TestSuite("Object tests");
		suite.addTestSuite(DoctorPatientsTest.class);
		suite.addTestSuite(DoctorTest.class);
		suite.addTestSuite(PatientTest.class);
		suite.addTestSuite(PrescriptionTest.class);

		return suite;
	}
}
