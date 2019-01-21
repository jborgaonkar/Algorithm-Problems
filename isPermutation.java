import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isPermutation {

	public static void main(String[] args) throws IOException {

		String s1,s2;		
		System.out.println("Enter the string 1");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		System.out.println("Enter the string 2");
		s2 = br.readLine();
		System.out.println("Input: " + s1 + " - " + s2);
		System.out.println("IsPermutation: " + IsPermutation2(s1,s2));	
	}
	
	public static boolean IsPermutation(String s1, String s2){
		
		char[] s1Array = s1.toCharArray();	
		char[] s2Array = s2.toCharArray();
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		String s1sorted = String.valueOf(s1Array);
		String s2sorted = String.valueOf(s2Array);
		if( s1sorted.equals(s2sorted) )
			return true;
		else
			return false;		
	}	

	
	public static boolean IsPermutation2(String s1, String s2){
		
		if(s1.length() != s2.length()) return false;
		Map<Character, Integer> m = new HashMap<Character, Integer>();		
		char[] s1Array = s1.toCharArray();	
		char[] s2Array = s2.toCharArray();
		
		for(int i=0; i<s1Array.length; i++){
			if(m.containsKey(s1Array[i])){
				m.put(s1Array[i], Integer.valueOf(1) + m.get(s1Array[i]));
			}
			else {
				m.put(s1Array[i], Integer.valueOf(1));
			}
		}

		for(int i=0; i<s2Array.length; i++){
			if(m.containsKey(s2Array[i])){
				m.put(s2Array[i], m.get(s2Array[i])-Integer.valueOf(1) );
			}
			else {
				m.put(s2Array[i], Integer.valueOf(-1) );
			}
		}		
		
		for(Map.Entry<Character, Integer> entry : m.entrySet()) {
			if( entry.getValue() != 0)
				return false;
		}
		return true;	
		
	}	
	

}
