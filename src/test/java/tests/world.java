package tests;

public class world {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one="Hello";

		String two="Worldweef";

		String result = "";

		for(int i=0;i<one.length() | i<two.length();i++)

		{

		if (i < one.length())

		result =result+ one.charAt(i);

		if (i < two.length())

		result = result+two.charAt(i);

		}

		System.out.println(result);

		}
	}


