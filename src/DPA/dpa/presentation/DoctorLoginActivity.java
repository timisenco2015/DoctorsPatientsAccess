package comp3350.dpa.presentation;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import comp3350.dpa.R;
import comp3350.dpa.objects.Doctor;
import comp3350.dpa.presentation.Messages;
import comp3350.dpa.business.AccessDoctors;

public class DoctorLoginActivity extends Activity
{
	AccessDoctors accessDoc = new AccessDoctors();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_login);
	}

	public void buttonDoctorLoginOnClick(View v)
	{
		Doctor doctor;
		EditText editID = (EditText)findViewById(R.id.doctorID);
		String docID = editID.getText().toString();

		boolean valid = StringUtils.isNumeric(docID);

		if (valid)
		{
			doctor = accessDoc.getDoctorByID(docID);

			if (doctor!=null)
			{
				Intent intent = new Intent(DoctorLoginActivity.this,
						PatientListActivity.class);
				intent.putExtra("doctorID", doctor.getID());
				startActivity(intent);
			} else
			{
				Messages.warning(this, "ID not found");
			}
		} else
		{
			Messages.warning(this, "Invalid ID");
		}

	}
}