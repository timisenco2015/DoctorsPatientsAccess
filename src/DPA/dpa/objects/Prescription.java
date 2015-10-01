package comp3350.dpa.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Prescription implements Serializable
{
	private String name;
	private String dosage;
	private int refills;
	boolean ordered;

	public Prescription(String pName, String pDosage, int pRefills)
	{
		name = pName;
		dosage = pDosage;
		refills = pRefills;
		ordered = false;
	}

	public Prescription(String pName, String pDosage, int pRefills,
			boolean pOrdered)
	{
		name = pName;
		dosage = pDosage;
		refills = pRefills;
		ordered = pOrdered;
	}

	public String getPrescriptionName()
	{
		return name;
	}

	public String getPrescriptionDosage()
	{
		return dosage;
	}

	public void setPrescriptionDosage(String newDosage)
	{
		dosage = newDosage;
	}

	public int getPrescriptionRefills()
	{
		return refills;
	}

	public void setPrescriptionRefills(int newRefills)
	{
		refills = newRefills;
	}

	public boolean getOrderStatus()
	{
		return ordered;
	}

	public void setOrderStatus(boolean newStatus)
	{
		ordered = newStatus;
	}
	
	public String toString()
	{
		String result = "";

		result = result+"Name: "+ name;
		result = result+"\nDosage: " + dosage;
		result = result+"\nRefills: "+ refills;

		result = result+"\n\n_______________________\n";

		return result;
	}
}
