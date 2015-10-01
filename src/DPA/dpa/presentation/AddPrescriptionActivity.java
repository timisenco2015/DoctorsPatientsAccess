package comp3350.dpa.presentation;

import comp3350.dpa.R;
import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.business.AccessPrescriptions;
import comp3350.dpa.objects.Patient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPrescriptionActivity extends Activity
{

	Patient patient;
	String patientID;
	AccessPatients accessPatients;
	AccessPrescriptions addPresc;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prescription);

		accessPatients = new AccessPatients();
		addPresc = new AccessPrescriptions();

		Intent intent = getIntent();
		patientID = intent.getStringExtra("patientID");
		patient = accessPatients.getPatientByID(patientID);

	}

	public void buttonAddPrescOnClick(View v)
	{
		String result;
		String result2 = null;

		EditText editPrescName = (EditText)findViewById(R.id.editPrescName);
		String prescName = editPrescName.getText().toString();
		EditText editPrescDosage = (EditText)findViewById(R.id.editPrescDosage);
		String prescDosage = editPrescDosage.getText().toString();
		EditText editPrescFills = (EditText)findViewById(R.id.editPrescFills);
		String prescFills = editPrescFills.getText().toString();

		result = validateSearchData(prescName, prescDosage, prescFills);

		if (result==null)
		{
			int prescFillsToInt = Integer.parseInt(prescFills);

			result2 = addPresc.addPrescription(prescName, prescDosage,
					prescFillsToInt, patient.getHealthID());

			Intent patientIntent = new Intent(AddPrescriptionActivity.this,
					PatientInfoActivity.class);
			patientIntent.putExtra("patientID", patient.getHealthID());
			AddPrescriptionActivity.this.startActivity(patientIntent);
			finish();

		} else
		{
			Messages.warning(this, result);
		}

	}

	private String validateSearchData(String prescName, String prescDosage,
			String prescFills)
	{

		int valid[] = addPresc.checkInputData(prescName, prescDosage, prescFills);
		String errorMesage = null;
		if (valid[0]==1)
		{
			errorMesage = "Please check the Prescription Name you entered";
		} else if (valid[1]==2)
		{
			errorMesage = "Please check the Prescription Dosage you entered";
		} else if (valid[4]==5&&valid[3]==4&&valid[4]==5)
		{
			errorMesage = "Please enter value in all the fields";
		} else if (valid[3]==4)
		{
			errorMesage = "Please prescription name cannot be empty";
		} else if (valid[4]==5)
		{
			errorMesage = "Please prescription dosage cannot be empty";
		} else if (valid[5]==6)
		{
			errorMesage = "Please prescription refills cannot be empty";
		} else if (valid[2]==3&&valid[5]==0)
		{
			errorMesage = "Please only digit value allowed for the refills";
		}

		return errorMesage;
	}

}
