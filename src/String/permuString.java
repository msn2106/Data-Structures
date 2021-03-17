/** This is a program to find all possible different permutations of words possible using characters of a given string.
 *  One more condition here is all the words are of same size as the provided string.
 */
package string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author msn2106
 */
public class permuString {

	public static void main(String[] args) {
		String s = "bac";
		ArrayList<String> n = new ArrayList<String>(); 
		permuS(s, "",n);
		
		System.out.print(n);
		
		String[] s2 = new String[n.size()];
		
		//way 1 - converting ArrayList to string array
//		Object[] objects = n.toArray();
//		int i=0;
//		for(Object obj : objects) {
//			s2[i++] = (String)obj;
//		}
		
		//way 2
//		for(int i=0;i<n.size();i++) {
//			s2[i]= n.get(i);
//		}
		
		//way 3
		Object[] obj = n.toArray();
		s2 = Arrays.copyOf(obj, obj.length, String[].class); 
		
		String[] s3 = lexSorting.lexSort(s2);
		
		System.out.println();
		System.out.print("Lexicographical order of permutation:");
		for(String s4: s3) System.out.print(s4+" ");
	}

	private static ArrayList<String> permuS(String s, String ans,ArrayList<String> per) {
		//ArrayList<String> per = new ArrayList<String>();
		// If string is empty 
        if (s.length() == 0) { 
            per.add(ans);
        } 
  
        for (int i = 0; i < s.length(); i++) { 
  
            // ith character of s 
            char ch = s.charAt(i); 
  
            // Rest of the string after excluding the ith character 
            String ros = s.substring(0, i) + s.substring(i + 1); 
  
            // Recursive call 
            permuS(ros, ans + ch,per); 
        } 
		return per;
	}

}
