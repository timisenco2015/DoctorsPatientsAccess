package comp3350.dpa.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import comp3350.dpa.R;

public class Messages
{
	public static void fatalError(final Activity owner, String message)
	{
		AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

		alertDialog.setTitle(owner.getString(R.string.fatalError));
		alertDialog.setMessage(message);
		alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
		{
			public void onCancel(DialogInterface dialog)
			{
				owner.finish();
			}
		});

		alertDialog.show();
	}

	public static void warning(Activity owner, String message)
	{
		AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

		alertDialog.setTitle(owner.getString(R.string.warning));
		alertDialog.setMessage(message);

		alertDialog.show();
	}

	public static void success(Activity owner, String message)
	{
		AlertDialog successDialog = new AlertDialog.Builder(owner).create();

		successDialog.setTitle(owner.getString(R.string.success));
		successDialog.setMessage(message);
		successDialog.show();
	}
}
