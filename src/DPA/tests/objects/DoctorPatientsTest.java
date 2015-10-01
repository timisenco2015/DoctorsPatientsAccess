package comp3350.tests.objects;

import junit.framework.TestCase;
import comp3350.dpa.objects.DoctorPatients;

public class DoctorPatientsTest extends TestCase
{

	public DoctorPatientsTest(String arg0)
	{
		super(arg0);
	}

	public void testNullDoctorPatients()
	{
		DoctorPatients dp = null;
		System.out.print("\nRunning testNullDoctorPatients");
		assertNull(dp);

		System.out.println("...PASSED");
	}

	public void testDoctorID()
	{
		DoctorPatients dp;
		System.out.print("\nRunning testDoctorID");
		dp = new DoctorPatients("241512", "");

		assertEquals(dp.getDoctorID(), "241512");

		System.out.println("...PASSED");
	}

	public void testPatientID()
	{
		DoctorPatients dp;
		System.out.print("\nRunning testPatientID");
		dp = new DoctorPatients("", "122512");
		assertEquals(dp.getPatientID(), "122512");

		System.out.println("...PASSED");
	}

	public void testEquals()
	{
		DoctorPatients dp1;
		DoctorPatients dp2;
		DoctorPatients dp3;
		DoctorPatients dp4;

		String doctorID = "211553";
		String patientID = "663121";
		System.out.print("\nRunning testEquals");

		dp1 = new DoctorPatients(doctorID, patientID);
		dp2 = new DoctorPatients(patientID, doctorID);
		dp3 = new DoctorPatients("111111", "222222");
		dp4 = new DoctorPatients(doctorID, patientID);

		assertTrue(dp1.equals(dp4));
		assertFalse(dp1.equals(dp2));
		assertFalse(dp1.equals(dp3));

		System.out.println("...PASSED");
	}

	public void testNullInputs()
	{
		DoctorPatients dp;
		System.out.print("\nRunning testNullInputs");

		dp = new DoctorPatients(null, null);

		assertEquals(dp.getDoctorID(), null);
		assertEquals(dp.getPatientID(), null);
		assertFalse(dp.equals(null));

		System.out.println("...PASSED");
	}
}