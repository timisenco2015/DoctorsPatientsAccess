package comp3350.dpa.business;

import java.util.ArrayList;

import comp3350.dpa.objects.Patient;
import comp3350.dpa.persistence.DataAccess;
import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;

public class SearchPatients
{
	static int currentIndex;
	String firstName = null;
	String lastName = null;
	String fullName = null;

	String[] tokens;
	DataAccess patientNames = Services.getDataAccess(Main.dbName);
	ArrayList<Patient> patientsList = new ArrayList<Patient>();
	private ValidationCheck validate;

	public SearchPatients(String fullName)
	{
		this.fullName = fullName;

		validate = new ValidationCheck();
	}

	private boolean splitPatientFullName()
	{
		boolean check = false;

		if (!validate.EmptyValue(fullName)&&!validate.invalidCharacters(fullName))
		{
			tokens = validate.splitStringValue(fullName);

			if (tokens.length>1)
			{
				lastName = tokens[1];
				firstName = tokens[0];

			} else
			{
				check = true;

			}
		}
		return check;
	}

	public int validCheck()
	{
		int valid = 0;
		if (validate.EmptyValue(fullName))
		{
			valid = 1;
		}

		else if (validate.invalidCharacters(fullName))
		{
			valid = 2;
		} else if (splitPatientFullName())
		{
			valid = 3;
		}

		return valid;
	}

	public ArrayList<Patient> getPatientsByNames()
	{
		DataAccess temp = patientNames;
		String result;
		boolean firstNameMatches;
		boolean lastNameMatches;
		ArrayList<Patient> patients = new ArrayList<Patient>();
		String dbFirstName;
		String dbLastName;

		result = temp.getAllPatients(patients);
		if (validCheck()==0&&result==null)
		{
			for (int i = 0; i<patients.size(); i++)
			{
				dbFirstName = patients.get(i).getFirstName();
				dbLastName = patients.get(i).getLastName();

				firstNameMatches = dbFirstName.equalsIgnoreCase(firstName);
				lastNameMatches = dbLastName.equalsIgnoreCase(lastName);

				if (firstNameMatches&&lastNameMatches)
				{
					patientsList.add(patients.get(i));
				}
			}

		}
		return patientsList;
	}

}