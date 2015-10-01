package comp3350.tests.objects;

import java.util.ArrayList;

import junit.framework.TestCase;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Prescription;

public class PatientTest extends TestCase
{

	public PatientTest(String arg0)
	{
		super(arg0);
	}

	public void testNullPatient()
	{
		Patient patient = null;
		System.out.print("\nRunning testNullPatient");
		assertNull(patient);

		System.out.println("...PASSED");
	}

	public void testPatientName()
	{
		Patient patient1;
		Patient patient2;
		Patient patient3;
		System.out.print("\nRunning testPatientName");
		patient1 = new Patient("123456789", "Franklin", "Clinton", "1978/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Peanuts,Almonds",
				"chopchop@aol.com");

		patient2 = new Patient("123456789", "Frank", "Clinton", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"clinton.f@aol.com");
		patient3 = new Patient("9986429", "John", "Braico", "1974/02/07",
				"91 Vinewood Hills", "Y3S 8S3", "2048331124", "Peanuts",
				"compsciyo@gmail.com");

		assertNotNull(patient1);
		assertEquals("Franklin", patient1.getFirstName());
		assertEquals("Clinton", patient1.getLastName());
		assertNotNull(patient2);
		assertEquals("Frank", patient2.getFirstName());
		assertEquals("Clinton", patient2.getLastName());
		assertNotNull(patient3);
		assertEquals("John", patient3.getFirstName());
		assertEquals("Braico", patient3.getLastName());

		System.out.println("...PASSED");

	}

	public void testPatientId()
	{
		Patient patient1;
		Patient patient2;
		Patient patient3;
		System.out.print("\nRunning testPatientId");
		patient1 = new Patient("123456789", "Franklin", "Clinton", "1978/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Peanuts,Almonds",
				"goodboychop@gmail.com");

		patient2 = new Patient("123456788", "Frank", "Clinton", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"clintfrank@hotmail.com");
		patient3 = new Patient("123456787", "John", "Braico", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"agileyo@hotmail.com");
		assertNotNull(patient1);
		assertEquals("123456789", patient1.getHealthID());
		assertNotNull(patient2);
		assertEquals("123456788", patient2.getHealthID());
		assertNotNull(patient3);
		assertEquals("123456787", patient3.getHealthID());

		System.out.println("...PASSED");
	}

	public void testPatientEmail()
	{
		Patient patient1;
		Patient patient2;
		Patient patient3;
		System.out.print("\nRunning testPatientEmail");
		patient1 = new Patient("123456789", "Franklin", "Clinton", "1978/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Peanuts,Almonds",
				"goodboychop@gmail.com");

		patient2 = new Patient("123456788", "Frank", "Clinton", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"clintfrank@hotmail.com");
		patient3 = new Patient("123456787", "John", "Braico", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"agileyo@hotmail.com");
		assertNotNull(patient1);
		assertEquals("goodboychop@gmail.com", patient1.getEmail());
		assertNotNull(patient2);
		assertEquals("clintfrank@hotmail.com", patient2.getEmail());
		assertNotNull(patient3);
		assertEquals("agileyo@hotmail.com", patient3.getEmail());

		System.out.println("...PASSED");
	}

	public void testPatientsDetails()
	{
		Patient patient1;
		Patient patient2;
		Patient patient3;
		System.out.print("\nRunning testPatientsDetails");
		patient1 = new Patient("123456789", "Franklin", "Clinton", "1978/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Peanuts,Almonds",
				"goodboychop@gmail.com");

		patient2 = new Patient("123456788", "Frank", "Clinton", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"clintfrank@hotmail.com");
		patient3 = new Patient("123456787", "John", "Braico", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"agileyo@hotmail.com");

		assertNotNull(patient1);
		assertEquals("1978/03/09", patient1.getBirthDate());
		assertEquals("91 Vinewood Hills", patient1.getAddress());
		assertEquals("V3S 1Q9", patient1.getPostalCode());
		assertEquals("2048990666", patient1.getPhoneNumber());

		assertNotNull(patient2);
		assertEquals("1984/03/09", patient2.getBirthDate());
		assertEquals("91 Vinewood Hills", patient2.getAddress());
		assertEquals("V3S 1Q9", patient2.getPostalCode());
		assertEquals("2048990666", patient2.getPhoneNumber());

		assertNotNull(patient3);
		assertEquals("1984/03/09", patient3.getBirthDate());
		assertEquals("91 Vinewood Hills", patient3.getAddress());
		assertEquals("V3S 1Q9", patient3.getPostalCode());
		assertEquals("2048990666", patient3.getPhoneNumber());

		System.out.println("...PASSED");
	}

	public void testpatientAllergies()
	{
		Patient patient1;
		Patient patient2;
		Patient patient3;
		Patient patient4;

		System.out.print("\nRunning testpatientAllergies");
		patient1 = new Patient("123456789", "Franklin", "Clinton", "1978/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Peanuts,Almonds",
				"goodboychop@gmail.com");

		patient2 = new Patient("123456788", "Frank", "Clinton", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"clintfrank@hotmail.com");

		patient3 = new Patient("123456787", "John", "Braico", "1984/03/09",
				"91 Vinewood Hills", "V3S 1Q9", "2048990666", "Cashew Nut,Almonds",
				"agileyo@hotmail.com");

		patient4 = new Patient("11111", "Mark", "Lol", null, null, null, null,
				null, null);
		assertNotNull(patient1);
		assertEquals("Peanuts,Almonds", patient1.getAllergies());
		assertNotNull(patient2);
		assertEquals("Cashew Nut,Almonds", patient2.getAllergies());
		assertNotNull(patient3);
		assertEquals("Cashew Nut,Almonds", patient3.getAllergies());
		assertNotNull(patient4);
		assertEquals("", patient4.getAllergies());

		System.out.println("...PASSED");
	}

	public void testPatientPrescriptions()
	{
		Patient patient1;
		Patient patient2;
		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();

		System.out.print("\nRunning testpatientPrescriptions");

		

		patient1 = new Patient("123456789", "Franklin", "Clinton", null, null,
				null, null, "Peanuts,Almonds", null);

		assertNotNull(patient1);
		assertNotSame(prescriptions.size(), 0);

		patient2 = new Patient("123456789", "Franklin", "Clinton", null, null,
				null, null, "Peanuts,Almonds", null);

		assertNotNull(patient2);
		assertNotSame(prescriptions.size(), 0);


		System.out.println("...PASSED");
	}

}