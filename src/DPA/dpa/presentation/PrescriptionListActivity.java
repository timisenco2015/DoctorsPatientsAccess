package comp3350.dpa.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.dpa.R;
import comp3350.dpa.business.AccessPatientPrescriptions;
import comp3350.dpa.business.AccessPatients;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.objects.PatientPrescription;
import comp3350.dpa.objects.Prescription;

public class PrescriptionListActivity extends Activity
{
	private ArrayAdapter<PatientPrescription> prescriptionArrayAdapter;
	private List<PatientPrescription>  patientPrescs;
	private Prescription prescriptions;
	private Patient patient;
	private String patientID;
	private AccessPatientPrescriptions accessPatientsPresc;
    private String pp;
    ArrayList<PatientPrescription> elemenents;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prescriptionlist);
		elemenents = new ArrayList<PatientPrescription>();
		accessPatientsPresc = new AccessPatientPrescriptions();
		elemenents = null;
		Intent intent = getIntent();
		patientID = intent.getStringExtra("patientID");
		
		patientPrescs =accessPatientsPresc.PatientPresc(patientID);
		

		//if (pp!=null&&!pp.isEmpty())
		//{
			prescriptionArrayAdapter = new ArrayAdapter<PatientPrescription>(this,
					android.R.layout.simple_list_item_activated_2,
					android.R.id.text1, patientPrescs)
			{
				@Override
				public View getView(int position, View convertView, ViewGroup parent)
				{
					View view = super.getView(position, convertView, parent);

					TextView text1 = (TextView)view.findViewById(android.R.id.text1);
					TextView text2 = (TextView)view.findViewById(android.R.id.text2);

					text1.setText(patientPrescs.get(position).getprescName());
					text2.setText(Integer.toString(patientPrescs.get(position).getprescRefills()));

					return view;
				}
			};

			final ListView listView = (ListView)findViewById(R.id.prescriptionList);
			listView.setAdapter(prescriptionArrayAdapter);

			listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
				{
					PatientPrescription temp = (PatientPrescription)listView
							.getItemAtPosition(position);
					Intent intent = new Intent(PrescriptionListActivity.this,
							OrderPrescriptionActivity.class);
					intent.putExtra("prescriptionName", temp.getprescName());
					intent.putExtra("healthID",patientID);
					startActivity(intent);
				}
			});

		//}		
	}
}