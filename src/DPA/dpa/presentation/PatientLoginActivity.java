package comp3350.dpa.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.validator.routines.EmailValidator;

import comp3350.dpa.R;
import comp3350.dpa.objects.Patient;
import comp3350.dpa.presentation.Messages;
import comp3350.dpa.business.AccessEmail;

public class PatientLoginActivity extends Activity
{
	private AccessEmail accessEmail;
	private Patient patient;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_login);

	}

	public void buttonLoginOnClick(View v)
	{
		accessEmail = new AccessEmail();
		EditText editEmail = (EditText)findViewById(R.id.email);
		String email = editEmail.getText().toString();
		boolean valid = EmailValidator.getInstance().isValid(email);

		if (valid)
		{
			patient = accessEmail.getEmail(email);
			if (patient!=null)
			{
				Intent intent = new Intent(PatientLoginActivity.this,
						PatientInfoViewActivity.class);
				intent.putExtra("patientID", patient.getHealthID());
				startActivity(intent);
			} else
			{
				Messages.warning(this, "Email not found");
			}
		} else
		{
			Messages.warning(this, "Invalid email");
		}
	}

}
