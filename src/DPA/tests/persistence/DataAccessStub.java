package comp3350.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.application.Main;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.PatientPrescription;
import comp3350.dpa.objects.Prescription;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.persistence.DataAccess;

public class DataAccessStub implements DataAccess
{
	private String dbName;
	private String dbType = "stub";

	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	private ArrayList<Prescription>prescriptions;
	private ArrayList<PatientPrescription>patientPrescs;
	private ArrayList<DoctorPatients> dps;

	public DataAccessStub(String dbName)
	{
		this.dbName = dbName;
	}

	public DataAccessStub()
	{
		this(Main.dbName);
	}

	public void open(String dbName)
	{
		Patient patient;
		Doctor doctor;
		DoctorPatients mydp;
		patients = new ArrayList<Patient>();
		doctors = new ArrayList<Doctor>();
		patientPrescs = new ArrayList<PatientPrescription>();
		prescriptions = new ArrayList<Prescription>();


		// prescription stub database
		prescriptions.add(new Prescription("Xanax", "100mg", 60));
		prescriptions.add(new Prescription("Lexapro", "200mg", 100));
		prescriptions.add(new Prescription("Paxil", "50mg", 10));

		prescriptions.add(new Prescription("Hydrocodone", "600mg", 0));
		prescriptions.add(new Prescription("Tramadol", "150mg", 100));
		prescriptions.add(new Prescription("Vicodin", "5mg", 5));
		prescriptions.add(new Prescription("Lyrica", "400mg", 40));
		prescriptions.add(new Prescription("Oxycodone", "1000mg", 300));
		prescriptions.add(new Prescription("Zoloft", "50mg", 0));
		prescriptions.add(new Prescription("Ambien", "500mg", 60));
		prescriptions.add(new Prescription("Lipitor", "80mg", 300));
		prescriptions.add(new Prescription("Prednisone", "2mg", 4));
		prescriptions.add(new Prescription("Advil", "500mg", 800));
		prescriptions.add(new Prescription("Tylenol", "200mg", 700));
		prescriptions.add(new Prescription("Lisinopril", "10mg", 80));
		// end of prescription stub database
		

		// patient stub database
		patient = new Patient("553125", "Master", "Chief", "1975/02/14",
				"53 Floodway Drive", "L5L 2E9", "2048996366", "Melatonin,Advil",
				"cortana4ever@hotmail.com");
		patients.add(patient);

		patient = new Patient("251153", "Arbiter", "Smith", "1956/01/01",
				"33 Covenant Avenue", "R3S 2I3", "2048991337", "",
				"covenant4life@gmail.com");
		patients.add(patient);

		patient = new Patient("991231", "John", "Shepard", "2154/04/11",
				"99 Normandy Circle", "X3Y 3Z5", "9901224", "Cats",
				"omgmiranda@aol.com");
		patients.add(patient);

		patient = new Patient("110211", "Super", "Mario", "1981/07/09",
				"99 Cashcow Road", "L0L 2I9", "2042862111", "Mushrooms",
				"wrongcastle@gmail.com");
		patients.add(patient);

		patient = new Patient("999199", "Michael", "DeSanta", "1973/09/09",
				"35 Vinewood Hills", "X3T 2Y6", "4001215353",
				"Vicodin,Diovan,Seroquel", "wtfjimmy@gmail.com");
		patients.add(patient);

		patient = new Patient("663112", "Michael", "DeSanta", "1988/01/16",
				"332 Prince Charles Pl", "R3T 2I1", "2042113563", "Sugar,Milk",
				"othermike@hotmail.com");
		patients.add(patient);

		patient = new Patient("111025", "Trevor", "Philips", "1984/12/01",
				"889 Trailerway Loop", "Y6W 3Q1", "9056082211", "Onions,Peanuts",
				"pinkteddybear@hotmail.com");
		patients.add(patient);

		// patientPrescription stub database
		patientPrescs.add(new PatientPrescription("553125","Xanax","100mg"));
		patientPrescs.add(new PatientPrescription("553125","Lexapro","200mg"));
		patientPrescs.add(new PatientPrescription("553125","Paxil","50mg"));
		
		patientPrescs.add(new PatientPrescription("251153","Hydrocodone","600mg"));
		patientPrescs.add(new PatientPrescription("251153","Tramadol","150mg"));
		
		patientPrescs.add(new PatientPrescription("991231","Vicodin","5mg"));
		patientPrescs.add(new PatientPrescription("991231","Lyrica","400mg"));
		patientPrescs.add(new PatientPrescription("991231","Oxycodone","1000mg"));
		
		patientPrescs.add(new PatientPrescription("110211","Lisinopril","10mg"));
		
		patientPrescs.add(new PatientPrescription("999199","Zoloft","50mg"));
		patientPrescs.add(new PatientPrescription("999199","Ambien","500mg"));
		patientPrescs.add(new PatientPrescription("999199","Liptor","80mg"));
		patientPrescs.add(new PatientPrescription("999199","Prednisone","2mg"));
		
		patientPrescs.add(new PatientPrescription("663112","Advil","500mg"));
		patientPrescs.add(new PatientPrescription("663112","Tylenol","200mg"));
		
		// end of patient stub database

		// doctor stub database
		doctor = new Doctor("351222", "Max", "Payne", "3401126948");
		doctors.add(doctor);

		doctor = new Doctor("933206", "Sam", "Fisher", "4566830121");
		doctors.add(doctor);

		doctor = new Doctor("785044", "Mona", "Sax", "7743298604");
		doctors.add(doctor);
		// end of doctor stub database

		// DoctorPatients stub database
		dps = new ArrayList<DoctorPatients>();
		mydp = new DoctorPatients("351222", "553125");
		dps.add(mydp);

		mydp = new DoctorPatients("351222", "251153");
		dps.add(mydp);

		mydp = new DoctorPatients("351222", "991231");
		dps.add(mydp);

		mydp = new DoctorPatients("933206", "110211");
		dps.add(mydp);

		mydp = new DoctorPatients("933206", "999199");
		dps.add(mydp);

		mydp = new DoctorPatients("933206", "663112");
		dps.add(mydp);

		mydp = new DoctorPatients("785044", "111025");
		dps.add(mydp);
		// end of doctorPatients stub database

		System.out.println("\nOpened "+dbType+" database "+dbName);
	}

	public void close()
	{
		System.out.println("\nClosed "+dbType+" database "+dbName);
	}

	public ArrayList<Patient> getSpecificPatients(String firstName,
			String lastName)
	{
		ArrayList<Patient> results = new ArrayList<Patient>();

		if (firstName!=null&&lastName!=null)
			for (int i = 0; i<patients.size(); i++)
			{
				if (firstName.equalsIgnoreCase(patients.get(i).getFirstName())
						&&lastName.equalsIgnoreCase(patients.get(i).getLastName()))
				{

					results.add(patients.get(i));
				}
			}

		return results;
	}

	public String getAllPatients(List<Patient> patientResult)
	{
		patientResult.addAll(patients);
		return null;
	}

	public Patient getPatientByID(String id)
	{
		Patient patient = null;

		for (int i = 0; i<patients.size(); i++)
		{
			if (patients.get(i).getHealthID().equals(id))
			{
				patient = patients.get(i);
			}
		}

		return patient;
	}

	public String getAllDoctors(List<Doctor> doctorResult)
	{
		doctorResult.addAll(doctors);
		return null;
	}

	public Doctor getDoctorByID(String id)
	{
		Doctor doctor = null;

		for (int i = 0; i<doctors.size(); i++)
		{
			if (doctors.get(i).getID().equals(id))
			{
				doctor = doctors.get(i);
			}
		}

		return doctor;
	}

	public List<DoctorPatients> getDoctorPatientsByDoctorID(String id)
	{
		List<DoctorPatients> dpresults = new ArrayList<DoctorPatients>();

		for (int i = 0; i<dps.size(); i++)
		{
			if (dps.get(i).getDoctorID().equals(id))
			{
				dpresults.add(dps.get(i));
			}
		}

		return dpresults;
	}

	public Patient getEmail(String email)
	{
		Patient patient = null;

		for (int i = 0; i<patients.size(); i++)
		{
			if (patients.get(i).getEmail().equals(email))
			{
				patient = patients.get(i);
			}
		}

		return patient;
	}

	public String addPrescription(String pName, String pDosage, int pRefills,
			String healthID)
	{
		String result = null;
		Patient patient;
		Prescription prescription;
		ArrayList<Prescription> pres;
		patient = getPatientByID(healthID);
		pres = patient.getPrescriptions();
		boolean prescriptionExists = false;

		for (int i = 0; i<pres.size(); i++)
		{
			if (pres.get(i).getPrescriptionName().equals(pName))
			{
				pres.get(i).setPrescriptionDosage(pDosage);
				pres.get(i).setPrescriptionRefills(pRefills);
				pres.get(i).setOrderStatus(false);
				prescriptionExists = true;
			}
		}

		if (!prescriptionExists)
		{
			prescription = new Prescription(pName, pDosage, pRefills);
			pres.add(prescription);
		}

		return result;
	}

	public Prescription getPrescription(String pName, String healthID)
	{
		Prescription result = null;
		Patient patient;
		for (int i = 0; i<prescriptions.size(); i++)
		{
			if (prescriptions.get(i).getPrescriptionName().equals(pName))
			{
				result = prescriptions.get(i);
			}
		}

		return result;
	}

	public String setPrescriptionStatus(Prescription prescription,
			String healthID)
	{
		String result = "Problem setting order status!";
		Patient patient;
		for (int i = 0; i<prescriptions.size(); i++)
		{
			if (prescriptions.get(i).getPrescriptionName()
					.equals(prescription.getPrescriptionName()))
			{
				prescriptions.get(i).setOrderStatus(true);
				result = null;
			}
		}

		return result;
	}

	public boolean getPrescriptionStatus(Prescription prescription,
			String healthID)
	{
		boolean status = false;
		Patient patient;
		
		for (int i = 0; i<prescriptions.size(); i++)
		{
			if (prescriptions.get(i).getPrescriptionName()
					.equals(prescription.getPrescriptionName()))
			{
				status = prescriptions.get(i).getOrderStatus();
			}
		}

		return status;

	}

	@Override
	public List<PatientPrescription> getPatientPrescriptions(String healthID) {
			PatientPrescription pp;
			List<PatientPrescription> prescResult = new ArrayList<PatientPrescription>();
		for (int i = 0; i<patientPrescs.size(); i++)
		{
			if (patientPrescs.get(i).getPatientID().equalsIgnoreCase(healthID))
					{
				      pp = patientPrescs.get(i);
				      for (int j=0; j<prescriptions.size();j++)
				      {
				    	  if (pp.getprescName().equalsIgnoreCase(prescriptions.get(i).getPrescriptionName())
				    		&& pp.getpresDosage().equalsIgnoreCase(prescriptions.get(i).getPrescriptionDosage()) )
				    	  {
				    		  prescResult.add(new PatientPrescription(healthID,prescriptions.get(i).getPrescriptionName(),prescriptions.get(i).getPrescriptionDosage(),prescriptions.get(i).getPrescriptionRefills(),prescriptions.get(i).getOrderStatus()));
				    	  }
				      }
					}
		}
		return prescResult;
	}
}
