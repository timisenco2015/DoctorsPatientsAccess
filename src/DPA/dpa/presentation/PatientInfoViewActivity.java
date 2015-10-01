package comp3350.dpa.presentation;

import comp3350.dpa.R;
import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.objects.Patient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PatientInfoViewActivity extends Activity
{
	private Patient patient;
	private AccessPatients accessPatients;
	private String patientID;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_info_view);

		accessPatients = new AccessPatients();

		Intent intent = getIntent();
		patientID = intent.getStringExtra("patientID");
		patient = accessPatients.getPatientByID(patientID);

		if (patient!=null)
		{
			if (patient.getFirstName()!=null&&patient.getLastName()!=null)
			{
				String patientName = patient.getFirstName()+" "
						+patient.getLastName();
				TextView nameTxt = (TextView)findViewById(R.id.patientName);
				nameTxt.setText(patientName);
			}

			if (patient.getHealthID()!=null)
			{
				String patientId = patient.getHealthID();
				TextView hIdTxt = (TextView)findViewById(R.id.patienthID);
				hIdTxt.setText(patientId);
			}
			if (patient.getBirthDate()!=null)
			{
				String patientDob = patient.getBirthDate();
				TextView dobTxt = (TextView)findViewById(R.id.patientDOB);
				dobTxt.setText(patientDob);
			}
			if (patient.getAddress()!=null)
			{
				String patientAddress = patient.getAddress();
				TextView addressTxt = (TextView)findViewById(R.id.patientAddress);
				addressTxt.setText(patientAddress);
			}
			if (patient.getPostalCode()!=null)
			{
				String patientPostalCode = patient.getPostalCode();
				TextView postalCodeTxt = (TextView)findViewById(R.id.patientPC);
				postalCodeTxt.setText(patientPostalCode);
			}
			if (patient.getPhoneNumber()!=null)
			{
				String patientPhone = patient.getPhoneNumber();
				TextView phoneTxt = (TextView)findViewById(R.id.patientPhoneNum);
				phoneTxt.setText(patientPhone);
			}
		}
	}

	public void buttonViewPresOnClick(View v)
	{
		if (patient.getPrescriptions()!=null)
		{
			Intent intent = new Intent(PatientInfoViewActivity.this,
					PrescriptionListActivity.class);
			intent.putExtra("patientID", patient.getHealthID());
			startActivity(intent);
		} else
		{
			Messages.warning(this, "You have no prescriptions");
		}
	}
}