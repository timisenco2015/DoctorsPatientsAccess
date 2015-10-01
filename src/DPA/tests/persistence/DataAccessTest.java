package comp3350.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.application.Services;
import comp3350.dpa.application.Main;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.persistence.DataAccess;

public class DataAccessTest extends TestCase
{
	private static String dbName = Main.dbName;

	public DataAccessTest(String arg0)
	{
		super(arg0);
	}

	public static void testDataAccess()
	{
		DataAccess db;

		db = (DataAccess)Services.createDataAccess(new DataAccessStub(dbName));

		ArrayList<Patient> patients;
		ArrayList<Doctor> doctors;
		List<DoctorPatients> dps;

		Patient patient;
		Doctor doctor;
		DoctorPatients dp;

		String result;
		System.out.print("\nRunning dataAccessTest");

		patients = new ArrayList<Patient>();
		result = db.getAllPatients(patients);
		assertNull(result);
		assertNotNull(patients);
		assertEquals(7, patients.size());
		patient = (Patient)patients.get(0);
		assertEquals("553125", patient.getHealthID());

		doctors = new ArrayList<Doctor>();
		result = db.getAllDoctors(doctors);
		assertNull(result);
		assertNotNull(doctors);
		assertEquals(3, doctors.size());
		doctor = (Doctor)doctors.get(0);
		assertEquals("351222", doctor.getID());

		dps = db.getDoctorPatientsByDoctorID("351222");
		dp = dps.get(0);
		assertNotNull(dp);
		assertEquals("351222", dp.getDoctorID());
		assertEquals("553125", dp.getPatientID());

		System.out.println("...PASSED");
		Services.closeDataAccess();
	}
}