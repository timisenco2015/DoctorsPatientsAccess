package comp3350.dpa.presentation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import comp3350.dpa.business.AccessDoctors;
import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.business.AccessPrescriptions;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.Prescription;

public class CLI // command-line interface
{
	public static BufferedReader console;
	public static String inputLine;
	public static String[] inputTokens;

	public static Patient currentPatient;
	public static Doctor currentDoctor;
	public static Prescription currentPrescription;
	public static ArrayList<Doctor> allDoctors;
	public static ArrayList<Patient> allPatients;
	public static ArrayList<Prescription> allPrescriptions;
	

	public static String patientID;
	public static String doctorID;
	public static String prescriptionName;

	public static String indent = "  ";

	public static void run()
	{
		try
		{
			console = new BufferedReader(new InputStreamReader(System.in));
			process();
			console.close();
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	public static void process()
	{
		readLine();
		while ((inputLine!=null)&&(!inputLine.equalsIgnoreCase("exit"))
				&&(!inputLine.equalsIgnoreCase("quit"))
				&&(!inputLine.equalsIgnoreCase("q"))
				&&(!inputLine.equalsIgnoreCase("bye")))
		{ // use cntl-c or exit to exit
			inputTokens = inputLine.split("\\s+");
			parse();
			readLine();
		}
	}

	public static void readLine()
	{
		try
		{
			System.out.print(">");
			inputLine = console.readLine();
		} catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	public static void parse()
	{
		if (inputTokens[0].equalsIgnoreCase("get"))
		{
			processGet();
		} else
		{
			System.out.println("Invalid command.");
		}
	}

	public static void processGet()
	{
		if (inputTokens.length<3)
		{
			System.out
					.println("Invalid command. \nUsage: \n\tget patient [patient ID]\n\tget doctor [doctor ID]\n\tget prescription [patient ID] [drug name]"
							+ "\n\tget all patients\n\tget all doctors\n\n");
		} 
		else if (inputTokens[1].equalsIgnoreCase("Patient"))
		{
			processGetPatient();
		} 
		else if (inputTokens[1].equalsIgnoreCase("Doctor"))
		{
			processGetDoctor();
		}
		else if (inputTokens[1].equalsIgnoreCase("Prescription"))
		{
			processGetPrescription();
		}
		else if (inputTokens[1].equalsIgnoreCase("all"))
		{
			processGetAll();
		}
		else
		{
			System.out
			.println("Invalid data type. \nUsage: \n\tget patient [patient ID]\n\tget doctor [doctor ID]\n\tget prescription [patient ID] [drug name]"
					+ "\n\tget all patients\n\tget all doctors\n\n");		}
	}

	public static void processGetPatient()
	{
		AccessPatients accessPatient = new AccessPatients();

		patientID = inputTokens[2];
		currentPatient = accessPatient.getPatientByID(patientID);
		if (currentPatient==null)
		{
			System.out.println("Invalid Patient ID! \n");
		} else
		{
			System.out.println(currentPatient);
		}

	}
	
	public static void processGetDoctor()
	{
		AccessDoctors accessDoctor = new AccessDoctors();
		
		doctorID = inputTokens[2];
		currentDoctor = accessDoctor.getDoctorByID(doctorID);
		if (currentDoctor == null)
		{
			System.out.println("Invalid Doctor ID!\n");
		}
		else
		{
			System.out.println(currentDoctor);
		}
	}
	
	public static void processGetPrescription()
	{
		AccessPrescriptions accessPrescription = new AccessPrescriptions();
		
		patientID = inputTokens[2];
		prescriptionName = inputTokens[3];
		currentPrescription = accessPrescription.getPrescription(prescriptionName, patientID);
		if (currentPrescription == null)
		{
			System.out.println("Invalid Patient/Prescription!\n");
		}
		else
		{
			System.out.println(currentPrescription);
		}
	}
	
	public static void processGetAll()
	{
		if (inputTokens[2].equalsIgnoreCase("patients"))
		{
			processGetAllPatients();
		}
		else if (inputTokens[2].equalsIgnoreCase("doctors"))
		{
			processGetAllDoctors();
		}
		else
		{
			System.out
			.println("Invalid data type. \nUsage: \n\tget patient [patient ID]\n\tget doctor [doctor ID]\n\tget prescription [patient ID] [drug name]"
					+ "\n\tget all patients\n\tget all doctors\n\n");
		}
	}
	
	public static void processGetAllPatients()
	{
		AccessPatients accessPatients = new AccessPatients();
		String result;
		allPatients = new ArrayList<Patient>();
		result = accessPatients.getPatients(allPatients);
		
		if (result == null)
		{
			for (int i = 0; i < allPatients.size(); i++)
			{
				System.out.println(allPatients.get(i));
				System.out.println("-----------------");
			}
		}
		else
		{
			System.out.println("Sorry, could not retrieve patients!");
		}
	}

	public static void processGetAllDoctors()
	{
		AccessDoctors accessDoctors = new AccessDoctors();
		String result;
		allDoctors = new ArrayList<Doctor>();
		result = accessDoctors.getDoctors(allDoctors);
		
		if (result == null)
		{
			for (int i = 0; i < allDoctors.size(); i++)
			{
				System.out.println(allDoctors.get(i));
				System.out.println("-----------------");
			}
		}
		else
		{
			System.out.println("Sorry, could not retrieve patients!");
		}
		
	}
	
}