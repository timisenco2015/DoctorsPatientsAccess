package comp3350.tests.objects;

import junit.framework.TestCase;
import comp3350.dpa.objects.Doctor;

public class DoctorTest extends TestCase
{

	public DoctorTest(String arg0)
	{
		super(arg0);
	}

	public void testNullDoctor()
	{
		Doctor doc = null;
		System.out.print("\nRunning testNullDoctor");
		assertNull(doc);
		System.out.println("...PASSED");
	}

	public void testDoctorName()
	{
		Doctor doc1;
		Doctor doc2;
		Doctor doc3;

		System.out.print("\nRunning testDoctorName");

		doc1 = new Doctor("3325640", "Devin", "Weston", "2001531333");

		doc2 = new Doctor("9663011", "Niko", "Bellic", "9012012263");

		doc3 = new Doctor("5633166", "Tommy", "Vercetti", "5506112532");

		assertNotNull(doc1);
		assertEquals("Devin", doc1.getFirstName());
		assertEquals("Weston", doc1.getLastName());
		assertNotNull(doc2);
		assertEquals("Niko", doc2.getFirstName());
		assertEquals("Bellic", doc2.getLastName());
		assertNotNull(doc3);
		assertEquals("Tommy", doc3.getFirstName());
		assertEquals("Vercetti", doc3.getLastName());

		System.out.println("...PASSED");

	}

	public void testDoctorID()
	{
		Doctor doc1;
		Doctor doc2;
		Doctor doc3;

		System.out.print("\nRunning testDoctorID");

		doc1 = new Doctor("6603163", "John", "Williams", "6330121568");

		doc2 = new Doctor("1120563", "Hans", "Zimmer", "9067093673");

		doc3 = new Doctor("1215669", "Ramin", "Djawadi", "5506112532");

		assertNotNull(doc1);
		assertEquals("6603163", doc1.getID());
		assertNotNull(doc2);
		assertEquals("1120563", doc2.getID());
		assertNotNull(doc3);
		assertEquals("1215669", doc3.getID());

		System.out.println("...PASSED");
	}

	public void testDoctorPhoneNum()
	{
		Doctor doc1;
		Doctor doc2;
		Doctor doc3;

		System.out.print("\nRunning testDoctorPhoneNum");

		doc1 = new Doctor("5311210", "Snoop", "Dogg", "6301219331");

		doc2 = new Doctor("1552102", "Kevin", "Riepl", "9963301124");

		doc3 = new Doctor("9921205", "Jesper", "Kyd", "8086061299");

		assertNotNull(doc1);
		assertEquals("6301219331", doc1.getPhoneNumber());

		assertNotNull(doc2);
		assertEquals("9963301124", doc2.getPhoneNumber());

		assertNotNull(doc3);
		assertEquals("8086061299", doc3.getPhoneNumber());

		System.out.println("...PASSED");
	}

	public void testNullInput()
	{
		Doctor doc;

		System.out.print("\nRunning testNullInput");

		doc = new Doctor(null, null, null, null);

		assertNull(doc.getID());
		assertNull(doc.getFirstName());
		assertNull(doc.getLastName());
		assertNull(doc.getPhoneNumber());

		System.out.println("...PASSED");
	}

}