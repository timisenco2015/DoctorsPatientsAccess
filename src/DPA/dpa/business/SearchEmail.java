package comp3350.dpa.business;

import java.util.ArrayList;

import comp3350.dpa.objects.Patient;
import comp3350.dpa.persistence.DataAccess;

public class SearchEmail
{
	public static Patient search(String key, DataAccess db)
	{
		DataAccess temp = db;
		String email;
		String result;
		Patient finalResult = null;
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		result = temp.getAllPatients(patientList);

		if (result==null)
		{
			for (int i = 0; i<patientList.size(); i++)
			{
				email = patientList.get(i).getEmail();
				if (email.equals(key))
				{
					finalResult = patientList.get(i);
				}
			}
		}
		return finalResult;
	}

}