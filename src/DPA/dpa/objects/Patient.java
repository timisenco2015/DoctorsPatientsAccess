package comp3350.dpa.objects;

import java.util.ArrayList;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Patient implements Serializable
{
	private String patientID;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String address;
	private String postalCode;
	private String phoneNumber;
	private String allergies;
	private String email;
	private ArrayList<Prescription> prescriptions;

	public Patient(String firstN, String lastN)
	{
		firstName = firstN;
		lastName = lastN;
	}

	public Patient(String card, String fName, String lName, String bDate,
			String addr, String pCode, String phoneNum, String allergs,
			String patientEmail)
	{
		

		patientID = card;
		firstName = fName;
		lastName = lName;
		birthDate = bDate;
		address = addr;
		postalCode = pCode;
		phoneNumber = phoneNum;
		allergies = allergs;
		email = patientEmail;

	

	}

	public String getHealthID()
	{
		return patientID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public String getAddress()
	{
		return address;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public String getAllergies()
	{
		String result = "";
		if (allergies!=null&&!allergies.equals(""))
		{
			result = allergies;
		}
		return result;
	}

	public ArrayList<Prescription> getPrescriptions()
	{
		ArrayList<Prescription> result = new ArrayList<Prescription>();

		if (prescriptions!=null&&!prescriptions.isEmpty())
		{
			result = prescriptions;
		}

		return result;
	}

	

	public boolean equals(Object obj)
	{
		boolean equals;
		Patient p;

		equals = false;

		if (obj instanceof Patient)
		{
			p = (Patient)obj;
			if (p.patientID.equals(patientID))
			{
				equals = true;
			}
		}
		return equals;
	}

	public String toString()
	{
		String result = "";
		String[] allergs;
		String delimiter = ",";

		result = result+"Name: "+firstName+" "+lastName;
		result = result+"\nHealth Card Number: "+patientID;
		result = result+"\nBirth Date: "+birthDate;
		result = result+"\nAddress: "+address;
		result = result+"\nPostal Code: "+postalCode;
		result = result+"\nPhone Number: "+phoneNumber;

		allergs = allergies.split(delimiter);

		if (allergs.length!=0&&allergs[0]!="")// if it's not empty
		{
			result = result+"\n\nAllergies:";

			for (int i = 0; i<allergs.length&&allergs[i]!=null; i++)
			{
				result = result+"\n"+allergs[i];
			}
		} else
		{
			result = result+"\n\nNo allergies reported.";
		}

	

		result = result+"\n\n_______________________\n";

		return result;
	}

}
