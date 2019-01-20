import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Object;
import java.lang.reflect.Array;
import java.util.Arrays;

public class IsUnique {

	public static void main(String[] args) throws IOException{
		String input;		
		System.out.println("Enter the string value");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		System.out.println("Input: " + input);
		System.out.println("IsUnique: " + isUnique3(input));		
	}
	
	/*
	 * Function using int array as extra memory O(n)
	 */
	public static boolean isUnique(String input){
		
		int[] charCount = new int[128];		
		for(int i=0; i<input.length(); i++){
			charCount[input.charAt(i)]++;
			if(charCount[input.charAt(i)]>1)
				return false;			
		}
		return true;			
	}
	
	/*
	 * function using Set extra memory to find is string with unique ch O(n)
	 */
	public static boolean isUnique2(String input){
		
		Set<Character> s = new HashSet<Character>();		
		for(int i=0; i<input.length(); i++){
			if(!s.add(input.charAt(i)))
				return false;			
		}
		return true;			
	}	

	/*
	 * function using no extra memory but time O(nlog)
	 */
	public static boolean isUnique3(String input){
		
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray); 
		for(int i=0; i<input.length()-1; i++){
			if(Character.toUpperCase(inputArray[i])==(Character.toUpperCase(inputArray[i+1])))
				return false;			
		}
		return true;			
	}	

}
