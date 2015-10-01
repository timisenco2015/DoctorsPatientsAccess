package comp3350.dpa.objects;

public class DoctorPatients
{
	private String doctorID;
	private String patientID;

	public DoctorPatients(String newDoctorID, String newPatientID)
	{
		doctorID = newDoctorID;
		patientID = newPatientID;
	}

	public String getDoctorID()
	{
		return doctorID;
	}

	public String getPatientID()
	{
		return patientID;
	}

	public String toString()
	{
		return "DoctorPatient: "+" "+doctorID+" "+patientID;
	}

	public boolean equals(Object object)
	{
		boolean result = false;
		DoctorPatients dp;

		if (object instanceof DoctorPatients)
		{
			dp = (DoctorPatients)object;
			if ((((dp.patientID==null)&&(patientID==null))||((dp.patientID!=null)&&(dp.patientID
					.equals(patientID))))
					&&(((dp.doctorID==null)&&(doctorID==null))||((dp.doctorID!=null)&&(dp.doctorID
							.equals(doctorID)))))
			{
				result = true;
			}
		}
		return result;
	}
}
