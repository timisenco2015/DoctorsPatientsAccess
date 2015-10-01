package comp3350.dpa.business;

public class ValidationCheck
{

	public ValidationCheck()
	{

	}

	public boolean EmptyValue(String value)
	{
		boolean check = false;

		value = value.trim();
		if (value.length()==0||value==null)
		{
			check = true;

		}

		return check;
	}

	public boolean invalidCharacters(String value)
	{
		value = value.trim();
		value = value.toLowerCase();
		char[] chars = value.toCharArray();
		boolean check = false;
		for (int i = 0; i<chars.length&&!check; i++)
		{

			if (!Character.isLetter(chars[i])&&chars[i]!=' ')
			{
				check = true;
			}
		}
		return check;
	}

	public boolean checkAlphaNumeric(String value)
	{
		value = value.trim();
		value = value.toLowerCase();
		char[] chars = value.toCharArray();
		boolean check = false;
		for (int i = 0; i<chars.length&&!check; i++)
		{

			if (!Character.isLetter(chars[i])&&!Character.isDigit(chars[i])
					&&chars[i]==' ')
			{
				check = true;
			}

		}
		return check;
	}

	public boolean checkStartWithNumericValue(String value)
	{
		boolean check = false;
		if (value.charAt(0)=='1')
		{
			check = true;
		}
		return check;
	}

	public String[] splitStringValue(String value)
	{

		String tokens[];
		tokens = value.split("\\s+");

		return tokens;
	}

	public boolean checkIfIntValue(String value)
	{
		boolean check = true;
		char[] chars = value.toCharArray();
		for (int i = 0; i<chars.length; i++)
		{
			if (!Character.isDigit(chars[i]))
			{
				check = false;
			}
		}

		return check;
	}

}
