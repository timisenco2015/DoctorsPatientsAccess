package comp3350.dpa.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.dpa.R;
import comp3350.dpa.application.Main;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		copyDatabaseToDevice();

		Main.startUp();

		setContentView(R.layout.activity_home);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();

		Main.shutDown();
	}

	public void buttonDoctorOnClick(View v)
	{
		Intent doctorIntent = new Intent(HomeActivity.this,
				DoctorLoginActivity.class);
		HomeActivity.this.startActivity(doctorIntent);
	}

	public void buttonPatientOnClick(View v)
	{
		Intent patientIntent = new Intent(HomeActivity.this,
				PatientLoginActivity.class);
		HomeActivity.this.startActivity(patientIntent);
	}

	private void copyDatabaseToDevice()
	{
		final String DB_PATH = "db";

		String[] assetNames;
		Context context = getApplicationContext();
		File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
		AssetManager assetManager = getAssets();

		try
		{
			assetNames = assetManager.list(DB_PATH);
			for (int i = 0; i<assetNames.length; i++)
			{
				assetNames[i] = DB_PATH+"/"+assetNames[i];
			}

			copyAssetsToDirectory(assetNames, dataDirectory);

			Main.setDBPathName(dataDirectory.toString()+"/"+Main.dbName);

		} catch (IOException ioe)
		{
			Messages.warning(this,
					"Unable to access application data: "+ioe.getMessage());
		}
	}

	public void copyAssetsToDirectory(String[] assets, File directory)
			throws IOException
	{
		AssetManager assetManager = getAssets();

		for (String asset : assets)
		{
			String[] components = asset.split("/");
			String copyPath = directory.toString()+"/"
					+components[components.length-1];
			char[] buffer = new char[1024];
			int count;

			File outFile = new File(copyPath);

			if (!outFile.exists())
			{
				InputStreamReader in = new InputStreamReader(
						assetManager.open(asset));
				FileWriter out = new FileWriter(outFile);

				count = in.read(buffer);
				while (count!=-1)
				{
					out.write(buffer, 0, count);
					count = in.read(buffer);
				}

				out.close();
				in.close();
			}
		}
	}
}
