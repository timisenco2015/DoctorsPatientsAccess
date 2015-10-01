package comp3350.dpa.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Doctor implements Serializable
{
	private String doctorID;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Doctor(String firstN, String lastN)
	{
		firstName = firstN;
		lastName = lastN;
	}

	public Doctor(String id, String fName, String lName, String phoneNum)
	{
		doctorID = id;
		firstName = fName;
		lastName = lName;
		phoneNumber = phoneNum;
	}

	public String getID()
	{
		return doctorID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public boolean equals(Object obj)
	{
		boolean equals;
		Doctor p;

		equals = false;

		if (obj instanceof Doctor)
		{
			p = (Doctor)obj;
			if (p.doctorID.equals(doctorID))
			{
				equals = true;
			}
		}
		return equals;
	}

	public String toString()
	{
		String result = "";

		result = result+"Name: "+firstName+" "+lastName;
		result = result+"\nDoctor ID: "+doctorID;
		result = result+"\nPhone Number: "+phoneNumber;

		result = result+"\n\n_______________________\n";

		return result;
	}

}
