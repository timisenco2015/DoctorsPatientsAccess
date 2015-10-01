package comp3350.dpa.presentation;

import comp3350.dpa.R;
import comp3350.dpa.business.AccessPrescriptions;
import comp3350.dpa.objects.Prescription;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderPrescriptionActivity extends Activity
{
	private AccessPrescriptions accessPrescription;
	private Prescription prescription;
	private String prescriptionName;
	private Button orderButton;
	private String healthID;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_prescription);

		accessPrescription = new AccessPrescriptions();

		orderButton = (Button)findViewById(R.id.buttonAdd);

		Intent intent = getIntent();
		prescriptionName = intent.getStringExtra("prescriptionName");
		healthID = intent.getStringExtra("healthID");

		prescription = accessPrescription.getPrescription(prescriptionName,
				healthID);

		if (prescription!=null)
		{
			String prescriptionName = "";
			String prescriptionDosage = "";
			String prescriptionRefills = "";
			String orderStatus = "";

			prescriptionName = prescription.getPrescriptionName();
			prescriptionDosage = prescription.getPrescriptionDosage();
			prescriptionRefills = String.valueOf(prescription
					.getPrescriptionRefills());

			if (accessPrescription.getOrderStatus(prescription, healthID))
			{
				orderStatus = "Ordered";
				orderButton.setEnabled(false);
			} else
			{
				orderStatus = "Not Ordered";
				orderButton.setEnabled(true);

			}

			TextView prscNameTxt = (TextView)findViewById(R.id.prescName);
			prscNameTxt.setText(prescriptionName);

			TextView presDosageTxt = (TextView)findViewById(R.id.prescDosage);
			presDosageTxt.setText(prescriptionDosage);

			TextView prescRefillTxt = (TextView)findViewById(R.id.prescRefills);
			prescRefillTxt.setText(prescriptionRefills);

			TextView prescStatus = (TextView)findViewById(R.id.prescStatus);
			prescStatus.setText(orderStatus);
		}
	}

	public void buttonOrderPrescriptionOnClick(View v)
	{
		String result = accessPrescription.setOrderStatus(prescription, healthID);
		String orderStatus = "";
		if (result==null)
		{
			if (accessPrescription.getOrderStatus(prescription, healthID))
			{
				orderStatus = "Ordered";
				orderButton.setEnabled(false);
			} else
			{
				orderStatus = "Not Ordered";
			}

			Messages.success(this, "Your Order has been successfully submitted!");

			TextView prescStatus = (TextView)findViewById(R.id.prescStatus);
			prescStatus.setText(orderStatus);
		} else
		{
			Messages.warning(this, "Prescription order has failed!"+result+"!!");
		}

	}
}
