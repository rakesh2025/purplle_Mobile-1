package tests;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Rakesh";
		String t="Pradhanvy";
		String p="";
	for(int i=0;i<s.length() | i<t.length();i++) {
		if(i<s.length())
			p=p+s.charAt(i);
		if(i<t.length()) 
			p=p+t.charAt(i);
		
	}
	System.out.println(p);

}
}
