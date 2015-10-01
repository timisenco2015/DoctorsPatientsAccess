package comp3350.dpa.objects;

public class PatientPrescription {
	
	private String prescName;
	private String patientID;
	private String presDosage;
	private int prescRefills;
	private boolean prescStatus;

	public PatientPrescription(String newPatientID, String prescrpName, String prescDoasage)
	{
		prescName = prescrpName;
		patientID = newPatientID;
		presDosage = prescDoasage;
		prescRefills = 0;
		prescStatus = false;
	}




	public PatientPrescription (String newPatientID, String prescrpName, String prescDoasage, int reFills, boolean status)
	{
		prescName = prescrpName;
		patientID = newPatientID;
		presDosage = prescDoasage;
		prescRefills = reFills;
		prescStatus = status;
	}

	public String getPatientID()
	{
		return (patientID);
	}

	public String getprescName()
	{
		return (prescName);
	}

	public String getpresDosage()
	{
		return (presDosage);
	}

	public int getprescRefills()
	{
		return (prescRefills);
	}
	
	public boolean getStatus()
	{
		return (prescStatus);
	}
	

	

	public String toString()
	{
		return "PatientPrescription: " +prescName +" " +presDosage +" " +prescRefills+prescStatus;
	}
	
	public boolean equals(Object object)
	{
		boolean result;
		PatientPrescription pp;
		
		result = false;
		
		if (object instanceof PatientPrescription)
		{
			pp = (PatientPrescription) object;
			if ((((pp.patientID == null) && (patientID == null)) || ((pp.patientID != null) && (pp.patientID.equals(patientID))))
			 && (((pp.prescName == null)  && (prescName == null))  || ((pp.prescName != null)  && (pp.prescName.equals(prescName))))
			  && (((pp.presDosage == null)  && (presDosage == null))  || ((pp.presDosage != null)  && (pp.presDosage.equals(presDosage)))))
			{
				result = true;
			}
		}
		return result;
	}
}
