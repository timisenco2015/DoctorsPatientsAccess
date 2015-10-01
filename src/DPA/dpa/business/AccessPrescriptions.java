package comp3350.dpa.business;

import comp3350.dpa.application.Main;
import comp3350.dpa.application.Services;
import comp3350.dpa.objects.*;
import comp3350.dpa.persistence.DataAccess;

public class AccessPrescriptions
{
	private DataAccess accessPatient;
	private ValidationCheck validate;

	public AccessPrescriptions()
	{
		accessPatient = Services.getDataAccess(Main.dbName);
		validate = new ValidationCheck();
	}

	public String addPrescription(String pName, String pDosage, int pRefills,
			String healthID)
	{
		return accessPatient.addPrescription(pName, pDosage, pRefills, healthID);
	}

	public Prescription getPrescription(String pName, String healthID)
	{
		return accessPatient.getPrescription(pName, healthID);
	}

	public String setOrderStatus(Prescription pres, String healthID)
	{
		return accessPatient.setPrescriptionStatus(pres, healthID);

	}

	public boolean getOrderStatus(Prescription pres, String healthID)
	{
		return accessPatient.getPrescriptionStatus(pres, healthID);
	}

	public int[] checkInputData(String pName, String pDosage, String pRefills)
	{
		int valid[] = new int[6];

		if (validate.checkAlphaNumeric(pName))
		{
			valid[0] = 1;
		}
		if (validate.checkAlphaNumeric(pDosage))
		{
			if (!validate.checkStartWithNumericValue(pDosage))
			{
				valid[1] = 2;
			}
		}
		if (!validate.checkIfIntValue(pRefills))
		{
			valid[2] = 3;
		}

		if (validate.EmptyValue(pName))
		{
			valid[3] = 4;
		}
		if (validate.EmptyValue(pDosage))
		{
			valid[4] = 5;
		}
		if (validate.EmptyValue(pRefills))
		{
			valid[5] = 6;
		}

		return valid;
	}

}
