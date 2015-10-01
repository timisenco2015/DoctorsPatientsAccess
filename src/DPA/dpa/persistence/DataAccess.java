package comp3350.dpa.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.objects.PatientPrescription;
import comp3350.dpa.objects.Prescription;

public interface DataAccess
{
	public void open(String dbPath);

	public void close();

	public ArrayList<Patient> getSpecificPatients(String firstName,
			String lastName);
	public List<PatientPrescription> getPatientPrescriptions( String healthID );

	public String getAllPatients(List<Patient> patients);

	public Patient getPatientByID(String healthId);

	public String getAllDoctors(List<Doctor> doctors);

	public Doctor getDoctorByID(String id);

	public List<DoctorPatients> getDoctorPatientsByDoctorID(String id);

	public Patient getEmail(String email);

	public String addPrescription(String pName, String pDosage, int pRefills,
			String healthID);

	public String setPrescriptionStatus(Prescription prescription,
			String healthID);

	public boolean getPrescriptionStatus(Prescription prescription,
			String healthID);

	public Prescription getPrescription(String pName, String healthID);
}
