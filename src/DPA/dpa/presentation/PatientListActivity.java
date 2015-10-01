package comp3350.dpa.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.dpa.R;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.objects.DoctorPatients;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.business.AccessDoctorPatients;
import comp3350.dpa.business.AccessDoctors;
import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.business.SearchPatients;
import comp3350.dpa.presentation.Messages;

public class PatientListActivity extends Activity
{
	private AccessDoctorPatients accessDocPat;
	private AccessDoctors accessDoctor;
	private AccessPatients accessPatient = new AccessPatients();
	private ArrayList<DoctorPatients> docPatList;
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayAdapter<Patient> patientArrayAdapter;
	private String doctorID;
	private Doctor doctor;
	private Patient patient;
	private String patientID;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_list);

		accessDocPat = new AccessDoctorPatients();
		accessDoctor = new AccessDoctors();

		Intent intent = getIntent();
		doctorID = intent.getStringExtra("doctorID");
		doctor = accessDoctor.getDoctorByID(doctorID);

		docPatList = new ArrayList<DoctorPatients>();
		docPatList = (ArrayList<DoctorPatients>)accessDocPat
				.getDoctorPatientsByDoctorID(doctor.getID());

		if (docPatList!=null)
		{
			for (int i = 0; i<docPatList.size(); i++)
			{
				patientID = docPatList.get(i).getPatientID();
				patient = accessPatient.getPatientByID(patientID);
				if (patient!=null)
				{
					patientList.add(patient);
				}
			}
		}

		if (patientList==null)
		{
			Messages.fatalError(this, "Error");
		} else
		{
			patientArrayAdapter = new ArrayAdapter<Patient>(this,
					android.R.layout.simple_list_item_activated_2,
					android.R.id.text1, patientList)
			{
				@Override
				public View getView(int position, View convertView, ViewGroup parent)
				{
					View view = super.getView(position, convertView, parent);

					TextView text1 = (TextView)view.findViewById(android.R.id.text1);
					TextView text2 = (TextView)view.findViewById(android.R.id.text2);

					text1.setText(patientList.get(position).getFirstName()+" "
							+patientList.get(position).getLastName());
					text2.setText(patientList.get(position).getHealthID());

					return view;
				}
			};

			final ListView listView = (ListView)findViewById(R.id.listPatients);
			listView.setAdapter(patientArrayAdapter);

			listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
				{
					Patient temp = (Patient)listView.getItemAtPosition(position);
					Intent intent = new Intent(PatientListActivity.this,
							PatientInfoActivity.class);
					intent.putExtra("patientID", temp.getHealthID());
					startActivity(intent);
				}
			});
		}
	}

	public void buttonSearch(View v)
	{
		SearchPatients searching;
		String result;

		EditText editSearch = (EditText)findViewById(R.id.editSearch);
		String searchText = editSearch.getText().toString();

		result = validateSearchData(searchText);

		if (result==null)
		{
			searching = new SearchPatients(searchText);
			final ArrayList<Patient> searchPatientList = searching
					.getPatientsByNames();

			ArrayAdapter<Patient> searchArrayAdapter = new ArrayAdapter<Patient>(
					this, android.R.layout.simple_list_item_activated_2,
					android.R.id.text1, searchPatientList)
			{
				@Override
				public View getView(int position, View convertView, ViewGroup parent)
				{
					View view = super.getView(position, convertView, parent);

					TextView text1 = (TextView)view.findViewById(android.R.id.text1);
					TextView text2 = (TextView)view.findViewById(android.R.id.text2);

					text1.setText(searchPatientList.get(position).getFirstName()+" "
							+searchPatientList.get(position).getLastName());
					text2.setText(searchPatientList.get(position).getHealthID());
					return view;
				}
			};

			final ListView listView = (ListView)findViewById(R.id.listPatients);
			listView.setAdapter(searchArrayAdapter);

		} else
		{
			Messages.warning(this, result);
		}

	}

	private String validateSearchData(String searchText)
	{
		SearchPatients valid = new SearchPatients(searchText);
		if (valid.validCheck()==1)
		{
			return "Please enther a name";
		} else if (valid.validCheck()==2)
		{
			return "Please only use letters";
		} else if (valid.validCheck()==3)
		{
			return "Please enter both first and last name";
		}
		return null;
	}
}