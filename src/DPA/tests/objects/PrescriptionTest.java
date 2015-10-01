package comp3350.tests.objects;

import junit.framework.TestCase;
import comp3350.dpa.objects.Prescription;

public class PrescriptionTest extends TestCase
{

	public PrescriptionTest(String arg0)
	{
		super(arg0);
	}

	public void testNullPrescription()
	{
		Prescription prs = null;
		System.out.print("\nRunning testNullPrescription");
		assertNull(prs);
		System.out.println("...PASSED");
	}

	public void testPrescriptionName()
	{
		Prescription prs1;
		Prescription prs2;
		Prescription prs3;

		System.out.print("\nRunning testPrescriptionName");

		prs1 = new Prescription("Hydrocodone", "5mg tablet daily", 3);

		prs2 = new Prescription("Zocor", "40mg daily", 0);

		prs3 = new Prescription("Lisinopril", "45mg daily", 5);

		assertNotNull(prs1);
		assertEquals("Hydrocodone", prs1.getPrescriptionName());
		assertNotNull(prs2);
		assertEquals("Zocor", prs2.getPrescriptionName());
		assertNotNull(prs3);
		assertEquals("Lisinopril", prs3.getPrescriptionName());

		System.out.println("...PASSED");

	}

	public void testPrescriptionDosage()
	{
		Prescription prs1;
		Prescription prs2;
		Prescription prs3;

		System.out.print("\nRunning testPrescriptionDosage");

		prs1 = new Prescription("Prilosec", "40mg daily", 6);

		prs2 = new Prescription("Norvasc", "5mg daily", 1);

		prs3 = new Prescription("Synthroid", "12.5mcg daily", 2);

		assertNotNull(prs1);
		assertEquals("40mg daily", prs1.getPrescriptionDosage());
		assertNotNull(prs2);
		assertEquals("5mg daily", prs2.getPrescriptionDosage());
		assertNotNull(prs3);
		assertEquals("12.5mcg daily", prs3.getPrescriptionDosage());

		System.out.println("...PASSED");
	}

	public void testPrescriptionOrderStatus()
	{
		Prescription prs1;
		Prescription prs2;
		Prescription prs3;

		System.out.print("\nRunning testPrescriptionOrderStatus");

		prs1 = new Prescription("Prilosec", "40mg daily", 6);
		prs1.setOrderStatus(true);

		prs2 = new Prescription("Norvasc", "5mg daily", 1);
		prs2.setOrderStatus(false);

		prs3 = new Prescription("Synthroid", "12.5 mcg daily", 2);
		prs3.setOrderStatus(false);

		assertNotNull(prs1);
		assertTrue(prs1.getOrderStatus());
		assertNotNull(prs2);
		assertFalse(prs2.getOrderStatus());
		assertNotNull(prs3);
		assertFalse(prs3.getOrderStatus());

		System.out.println("...PASSED");
	}

	public void testPrescriptionFilled()
	{
		Prescription prs1;
		Prescription prs2;
		Prescription prs3;

		System.out.print("\nRunning testPrescriptionRefills");

		prs1 = new Prescription("Advil", "40mg daily", 6);

		prs2 = new Prescription("Tylenol", "5mg daily", 1);

		prs3 = new Prescription("Ibuprofen", "12.5 mcg daily", 2);

		assertNotNull(prs1);
		assertEquals(6, prs1.getPrescriptionRefills());
		assertNotNull(prs2);
		assertEquals(1, prs2.getPrescriptionRefills());
		assertNotNull(prs3);
		assertEquals(2, prs3.getPrescriptionRefills());

		System.out.println("...PASSED");
	}

	public void testNullInputs()
	{
		Prescription prs;

		System.out.print("\nRunning testNullInput");

		prs = new Prescription(null, null, 0);

		assertNull(prs.getPrescriptionName());
		assertNull(prs.getPrescriptionDosage());

		System.out.println("...PASSED");
	}

}