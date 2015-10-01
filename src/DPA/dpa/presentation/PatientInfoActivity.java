package comp3350.dpa.presentation;

import java.util.ArrayList;

import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.objects.Prescription;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;
import comp3350.dpa.R;
import comp3350.dpa.objects.Patient;

public class PatientInfoActivity extends Activity
{
	private ArrayList<Prescription> prescriptions;
	private ArrayAdapter<Prescription> prescriptionsArrayAdapter;
	private Patient patient;
	private String patientID;
	private AccessPatients accessPatients;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_info);

		accessPatients = new AccessPatients();

		String patientName = "";
		String patientId = "";
		String patientDob = "";
		String patientAddress = "";
		String patientPostalCode = "";
		String patientPhone = "";
		String patientAllergies = "";
		String processedPatientAllergies = "";
		String delimiter = ",";
		String[] allergies;
		int counter = 0;

		Intent intent = getIntent();
		patientID = intent.getStringExtra("patientID");
		patient = accessPatients.getPatientByID(patientID);

		final ListView listview = (ListView)findViewById(R.id.listPrescriptions);

		prescriptions = patient.getPrescriptions();
		prescriptionsArrayAdapter = new ArrayAdapter<Prescription>(this,
				android.R.layout.simple_list_item_activated_2, android.R.id.text1,
				prescriptions)
		{
			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				View view = super.getView(position, convertView, parent);

				TextView text1 = (TextView)view.findViewById(android.R.id.text1);
				TextView text2 = (TextView)view.findViewById(android.R.id.text2);

				text1.setText(prescriptions.get(position).getPrescriptionName()
						+" ("+prescriptions.get(position).getPrescriptionDosage()+")");
				text2.setText("Remaining refills: "
						+prescriptions.get(position).getPrescriptionRefills());

				return view;
			}
		};

		listview.setAdapter(prescriptionsArrayAdapter);

		patientName = patient.getFirstName()+" "+patient.getLastName();
		patientId = patient.getHealthID();
		patientDob = patient.getBirthDate();
		patientAddress = patient.getAddress();
		patientPostalCode = patient.getPostalCode();
		patientPhone = patient.getPhoneNumber();
		patientAllergies = patient.getAllergies();

		TextView nameTxt = (TextView)findViewById(R.id.patientName);
		nameTxt.setText(patientName);

		TextView hIdTxt = (TextView)findViewById(R.id.patienthID);
		hIdTxt.setText(patientId);

		TextView dobTxt = (TextView)findViewById(R.id.patientDOB);
		dobTxt.setText(patientDob);

		TextView addressTxt = (TextView)findViewById(R.id.patientAddress);
		addressTxt.setText(patientAddress);

		TextView postalCodeTxt = (TextView)findViewById(R.id.patientPC);
		postalCodeTxt.setText(patientPostalCode);

		TextView phoneTxt = (TextView)findViewById(R.id.patientPhoneNum);
		phoneTxt.setText(patientPhone);

		if (patientAllergies==null||patientAllergies.equals(""))
		{
			TextView allergiesTxt = (TextView)findViewById(R.id.patientAllergiestv);
			allergiesTxt.setText("None on file");
		} else
		{
			TextView allergiesTxt = (TextView)findViewById(R.id.patientAllergiestv);
			allergies = patientAllergies.split(delimiter);

			for (int i = 0; i<allergies.length; i++)
			{
				if ((counter+allergies[i].length())<30||counter==0)
				{
					processedPatientAllergies += allergies[i];
				} else
				{
					counter = 0;
					processedPatientAllergies += "\n"+allergies[i];
				}

				if (i<(allergies.length-1))
				{
					processedPatientAllergies += ", ";
				}

				counter = counter+allergies[i].length();
			}

			allergiesTxt.setText(processedPatientAllergies);
		}

	}

	public void buttonNewPrescriptionOnClick(View v)
	{
		Intent patientIntent = new Intent(PatientInfoActivity.this,
				AddPrescriptionActivity.class);
		patientIntent.putExtra("patientID", patient.getHealthID());
		startActivity(patientIntent);
		finish();
	}

	@Override
	public void onRestart()
	{
		super.onRestart();
	}

	@Override
	public void onResume()
	{
		super.onRestart();
	}
}
