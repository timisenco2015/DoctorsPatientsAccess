package comp3350.dpa.persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.PatientPrescription;
import comp3350.dpa.objects.Prescription;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.DoctorPatients;

public class DataAccessObject implements DataAccess
{
	private Statement st1, st2, st3;
	private Connection c1;
	private ResultSet rs2, rs3, rs4, rs5;

	private String dbName;
	private String dbType;

	private String cmdString;
	private int updateCount;
	private String result;
	private static String EOF = "  ";

	public DataAccessObject(String dbName)
	{
		this.dbName = dbName;
	}

	public void open(String dbPath)
	{
		String url;
		try
		{
			dbType = "HSQL";
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			url = "jdbc:hsqldb:file:"+dbPath;
			c1 = DriverManager.getConnection(url, "SA", "");
			st1 = c1.createStatement();
			st2 = c1.createStatement();
			st3 = c1.createStatement();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		System.out.println("Opened "+dbType+" database "+dbPath);
	}

	public void close()
	{
		try
		{
			cmdString = "shutdown compact";
			rs2 = st1.executeQuery(cmdString);
			c1.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		System.out.println("Closed "+dbType+" database "+dbName);
	}

	public ArrayList<Patient> getSpecificPatients(String firstName,
			String lastName)
	{
		ArrayList<Patient> results = new ArrayList<Patient>();
		ArrayList<Prescription> presc;
		Patient currPatient;
		Prescription currPrescription;
		String id, fName, lName, birthDate, address, postalCode, phoneNumber, allergies, email, prescName, prescDosage;
		int prescRefills;
		boolean prescOrdered;
		id = EOF;
		fName = EOF;
		lName = EOF;
		birthDate = EOF;
		address = EOF;
		postalCode = EOF;
		phoneNumber = EOF;
		allergies = EOF;
		email = EOF;
		prescName = EOF;
		prescDosage = EOF;

		try
		{
			cmdString = "Select * from Patients where FIRSTNAME='"+firstName
					+"' AND LASTNAME='"+lastName+"'";
			rs3 = st1.executeQuery(cmdString);

			while (rs3.next())
			{
				id = rs3.getString("PATIENTID");
				fName = rs3.getString("FIRSTNAME");
				lName = rs3.getString("LASTNAME");
				birthDate = rs3.getString("BIRTHDATE");
				address = rs3.getString("ADDRESS");
				postalCode = rs3.getString("POSTALCODE");
				phoneNumber = rs3.getString("PHONENUMBER");
				allergies = rs3.getString("ALLERGIES");
				email = rs3.getString("EMAIL");

				presc = new ArrayList<Prescription>();

				cmdString = "Select * from Prescriptions where PATIENTID='"+id+"'";
				rs4 = st2.executeQuery(cmdString);
				while (rs4.next())
				{
					prescName = rs4.getString("NAME");
					prescDosage = rs4.getString("DOSAGE");
					prescRefills = rs4.getInt("REFILLS");
					prescOrdered = rs4.getBoolean("ORDERED");
					currPrescription = new Prescription(prescName, prescDosage,
							prescRefills, prescOrdered);

					presc.add(currPrescription);
				}
				rs4.close();

				currPatient = new Patient(id, fName, lName, birthDate, address,
						postalCode, phoneNumber, allergies, email);

				results.add(currPatient);
			}
			rs3.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return results;
	}

	public String getAllPatients(List<Patient> patientResult)
	{
		Patient patient;
		String id, fName, lName, birthDate, address, postalCode, phoneNumber, allergies, email, prescName, prescDosage;
		int prescRefills;
		boolean prescOrdered;
		ArrayList<Prescription> presc;
		Prescription currPrescription;
		id = EOF;
		fName = EOF;
		lName = EOF;
		birthDate = EOF;
		address = EOF;
		postalCode = EOF;
		phoneNumber = EOF;
		allergies = EOF;
		email = EOF;
		prescName = EOF;
		prescDosage = EOF;

		result = null;
		try
		{
			cmdString = "Select * from Patients";
			rs2 = st1.executeQuery(cmdString);
		} catch (Exception e)
		{
			processSQLError(e);
		}
		try
		{
			while (rs2.next())
			{
				id = rs2.getString("PATIENTID");
				fName = rs2.getString("FIRSTNAME");
				lName = rs2.getString("LASTNAME");
				birthDate = rs2.getString("BIRTHDATE");
				address = rs2.getString("ADDRESS");
				postalCode = rs2.getString("POSTALCODE");
				phoneNumber = rs2.getString("PHONENUMBER");
				allergies = rs2.getString("ALLERGIES");
				email = rs2.getString("EMAIL");

				presc = new ArrayList<Prescription>();

				cmdString = "Select * from Prescriptions where PATIENTID='"+id+"'";
				rs4 = st2.executeQuery(cmdString);
				while (rs4.next())
				{
					prescName = rs4.getString("NAME");
					prescDosage = rs4.getString("DOSAGE");
					prescRefills = rs4.getInt("REFILLS");
					prescOrdered = rs4.getBoolean("ORDERED");
					currPrescription = new Prescription(prescName, prescDosage,
							prescRefills, prescOrdered);

					presc.add(currPrescription);
				}
				rs4.close();

				patient = new Patient(id, fName, lName, birthDate, address,
						postalCode, phoneNumber, allergies, email);

				patientResult.add(patient);
			}
			rs2.close();
		} catch (Exception e)
		{
			result = processSQLError(e);
		}

		return result;

	}

	public Patient getPatientByID(String healthID)
	{
		ArrayList<Prescription> presc;
		Patient currPatient = null;
		Prescription currPrescription;
		String id, fName, lName, birthDate, address, postalCode, phoneNumber, allergies, email, prescName, prescDosage;
		int prescRefills;
		boolean prescOrdered;
		id = EOF;
		fName = EOF;
		lName = EOF;
		birthDate = EOF;
		address = EOF;
		postalCode = EOF;
		phoneNumber = EOF;
		allergies = EOF;
		email = EOF;
		prescName = EOF;
		prescDosage = EOF;

		try
		{
			cmdString = "Select * from Patients where PATIENTID='"+healthID+"'";
			rs3 = st1.executeQuery(cmdString);

			while (rs3.next())
			{
				id = rs3.getString("PATIENTID");
				fName = rs3.getString("FIRSTNAME");
				lName = rs3.getString("LASTNAME");
				birthDate = rs3.getString("BIRTHDATE");
				address = rs3.getString("ADDRESS");
				postalCode = rs3.getString("POSTALCODE");
				phoneNumber = rs3.getString("PHONENUMBER");
				allergies = rs3.getString("ALLERGIES");
				email = rs3.getString("EMAIL");

				presc = new ArrayList<Prescription>();

				cmdString = "Select * from Prescriptions where PATIENTID='"+id+"'";
				rs4 = st2.executeQuery(cmdString);
				while (rs4.next())
				{
					prescName = rs4.getString("NAME");
					prescDosage = rs4.getString("DOSAGE");
					prescRefills = rs4.getInt("REFILLS");
					prescOrdered = rs4.getBoolean("ORDERED");
					currPrescription = new Prescription(prescName, prescDosage,
							prescRefills, prescOrdered);

					presc.add(currPrescription);
				}
				rs4.close();

				currPatient = new Patient(id, fName, lName, birthDate, address,
						postalCode, phoneNumber, allergies, email);
			}
			rs3.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return currPatient;
	}

	public String getAllDoctors(List<Doctor> doctorResult)
	{
		Doctor doctor;
		String doctorID, firstName, lastName, phoneNumber;
		doctorID = EOF;
		firstName = EOF;
		lastName = EOF;
		phoneNumber = EOF;
		result = null;

		try
		{
			cmdString = "Select * from Doctors";
			rs2 = st1.executeQuery(cmdString);

			while (rs2.next())
			{
				doctorID = rs2.getString("DOCTORID");
				firstName = rs2.getString("FIRSTNAME");
				lastName = rs2.getString("LASTNAME");
				phoneNumber = rs2.getString("PHONENUMBER");

				doctor = new Doctor(doctorID, firstName, lastName, phoneNumber);
				doctorResult.add(doctor);
			}
			rs2.close();
		} catch (Exception e)
		{
			result = processSQLError(e);
		}
		return result;
	}

	public Doctor getDoctorByID(String id)
	{
		Doctor doctor = null;
		String doctorID, firstName, lastName, phoneNumber;
		doctorID = EOF;
		firstName = EOF;
		lastName = EOF;
		phoneNumber = EOF;

		try
		{
			cmdString = "Select * from Doctors where DOCTORID='"+id+"'";
			rs2 = st1.executeQuery(cmdString);

			while (rs2.next())
			{
				doctorID = rs2.getString("DOCTORID");
				firstName = rs2.getString("FIRSTNAME");
				lastName = rs2.getString("LASTNAME");
				phoneNumber = rs2.getString("PHONENUMBER");

				doctor = new Doctor(doctorID, firstName, lastName, phoneNumber);
			}
			rs2.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return doctor;
	}

	public List<DoctorPatients> getDoctorPatientsByDoctorID(String id)
	{
		DoctorPatients dp;
		List<DoctorPatients> results = null;
		String doctorID, patientID;
		doctorID = EOF;
		patientID = EOF;
		results = new ArrayList<DoctorPatients>();

		try
		{
			cmdString = "Select * from DOCTORPATIENTS where DOCTORID='"+id+"'";
			rs5 = st3.executeQuery(cmdString);

			while (rs5.next())
			{
				doctorID = rs5.getString("DOCTORID");
				patientID = rs5.getString("PATIENTID");
				dp = new DoctorPatients(doctorID, patientID);
				results.add(dp);
			}
			rs5.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return results;
	}

	public Patient getEmail(String newEmail)
	{
		ArrayList<Prescription> presc;
		Patient currPatient = null;
		Prescription currPrescription;
		String id, fName, lName, birthDate, address, postalCode, phoneNumber, allergies, email, prescName, prescDosage;
		int prescRefills;
		boolean prescOrdered;
		id = EOF;
		fName = EOF;
		lName = EOF;
		birthDate = EOF;
		address = EOF;
		postalCode = EOF;
		phoneNumber = EOF;
		allergies = EOF;
		email = EOF;
		prescName = EOF;
		prescDosage = EOF;

		try
		{
			cmdString = "Select * from Patients where EMAIL='"+newEmail+"'";
			rs3 = st1.executeQuery(cmdString);

			while (rs3.next())
			{
				id = rs3.getString("PATIENTID");
				fName = rs3.getString("FIRSTNAME");
				lName = rs3.getString("LASTNAME");
				birthDate = rs3.getString("BIRTHDATE");
				address = rs3.getString("ADDRESS");
				postalCode = rs3.getString("POSTALCODE");
				phoneNumber = rs3.getString("PHONENUMBER");
				allergies = rs3.getString("ALLERGIES");
				email = rs3.getString("EMAIL");

				presc = new ArrayList<Prescription>();

				cmdString = "Select * from Prescriptions where PATIENTID='"+id+"'";
				rs4 = st2.executeQuery(cmdString);
				while (rs4.next())
				{
					prescName = rs4.getString("NAME");
					prescDosage = rs4.getString("DOSAGE");
					prescRefills = rs4.getInt("REFILLS");
					prescOrdered = rs4.getBoolean("ORDERED");
					currPrescription = new Prescription(prescName, prescDosage,
							prescRefills, prescOrdered);

					presc.add(currPrescription);
				}
				rs4.close();

				currPatient = new Patient(id, fName, lName, birthDate, address,
						postalCode, phoneNumber, allergies, email);
			}
			rs3.close();
		} catch (Exception e)
		{
			processSQLError(e);
		}

		return currPatient;
	}

	public String addPrescription(String pName, String pDosage, int pRefills,
			String healthID)
	{
		result = null;
		boolean prescriptionExists = false;

		try
		{
			cmdString = "Select * from PRESCRIPTIONS where PATIENTID='"+healthID
					+"' AND NAME='"+pName+"'";
			rs2 = st1.executeQuery(cmdString);

			while (rs2.next())
			{
				prescriptionExists = true;
			}
		} catch (Exception e)
		{
			result = processSQLError(e);
		}

		if (prescriptionExists)
		{
			try
			{
				cmdString = "UPDATE PRESCRIPTIONS SET DOSAGE='"+pDosage
						+"', REFILLS='"+pRefills+"', ORDERED=false WHERE PATIENTID='"
						+healthID+"' AND NAME='"+pName+"'";
				updateCount = st1.executeUpdate(cmdString);
				result = checkWarning(st1, updateCount);
			} catch (Exception e)
			{
				result = processSQLError(e);
			}

		} else
		{
			try
			{
				cmdString = "INSERT INTO PRESCRIPTIONS VALUES('"+healthID+"', '"
						+pName+"', '"+pDosage+"', "+pRefills+", false)";
				updateCount = st1.executeUpdate(cmdString);
				result = checkWarning(st1, updateCount);
			} catch (Exception e)
			{
				result = processSQLError(e);
			}
		}
		return result;
	}

	public Prescription getPrescription(String pName, String healthID)
	{
		String name, dosage;
		int refills;
		boolean status;
		Prescription result = null;

		try
		{
			cmdString = "SELECT * from PRESCRIPTIONS where PATIENTID='"+healthID
					+"' AND NAME='"+pName+"'";
			rs3 = st1.executeQuery(cmdString);

			while (rs3.next())
			{
				name = rs3.getString("NAME");
				dosage = rs3.getString("DOSAGE");
				refills = rs3.getInt("REFILLS");
				status = rs3.getBoolean("ORDERED");
				result = new Prescription(name, dosage, refills, status);
			}
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return result;
	}
	
	public List<PatientPrescription> getPatientPrescriptions( String healthID )
	{
		String name, dosage;
		int refills;
		boolean status;
		String result = null;
		List<PatientPrescription> prescList = new ArrayList<PatientPrescription>();
		PatientPrescription presc =null;

		try
		{
			cmdString = "SELECT * from PRESCRIPTIONS where PATIENTID='"+healthID+"'";
				
			rs3 = st1.executeQuery(cmdString);

			while (rs3.next())
			{
				name = rs3.getString("NAME");
				dosage = rs3.getString("DOSAGE");
				refills = rs3.getInt("REFILLS");
				status = rs3.getBoolean("ORDERED");
				presc = new PatientPrescription(healthID,name, dosage, refills, status);
				prescList.add(presc);
			}
		} catch (Exception e)
		{
			processSQLError(e);
		}
		return prescList;
	}

	public String setPrescriptionStatus(Prescription prescription,
			String healthID)
	{
		String values, where;

		try
		{
			values = "ORDERED='true'";
			where = " where PATIENTID='"+healthID+"' AND NAME='"
					+prescription.getPrescriptionName()+"'";
			cmdString = "UPDATE PRESCRIPTIONS SET "+values+where;
			updateCount = st1.executeUpdate(cmdString);
			result = checkWarning(st1, updateCount);
		} catch (Exception e)
		{
			result = processSQLError(e);
		}
		return result;

	}

	public boolean getPrescriptionStatus(Prescription pres, String healthID)
	{
		boolean ordered = false;
		try
		{
			cmdString = "Select * from PRESCRIPTIONS where PATIENTID='"+healthID
					+"' AND NAME='"+pres.getPrescriptionName()+"'";
			rs2 = st1.executeQuery(cmdString);
		} catch (Exception e)
		{
			processSQLError(e);
		}
		try
		{
			while (rs2.next())
			{
				ordered = rs2.getBoolean("ORDERED");
			}
		} catch (Exception e)
		{
			processSQLError(e);
		}

		return ordered;
	}

	public String checkWarning(Statement st, int updateCount)
	{
		String result;

		result = null;

		try
		{
			SQLWarning warning = st.getWarnings();
			if (warning!=null)
			{
				result = warning.getMessage();
			}
		} catch (Exception e)
		{
			result = processSQLError(e);
		}
		if (updateCount!=1)
		{
			result = "Tuple not inserted correctly.";
		}
		return result;
	}

	public String processSQLError(Exception e)
	{
		String result = "*** SQL Error: "+e.getMessage();
		e.printStackTrace();
		return result;
	}

}
