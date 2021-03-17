/** This is a program to sort a given string array in lexicographical order.
 * 
 */
package string;

/**
 * @author msn2106
 */
public class lexSorting {

	public static void main(String[] args) {
		String[] strings = {"She", "had", "been", "told", "time", "and", "time", "again", "that", "the", "most", "important"};
		
		String[] lexs = lexSort(strings);
		
		for(String s: lexs) System.out.print(s+" ");
	}
	
	//function to lexicographically sort the String array
	public static String[] lexSort(String[] s) {
		int sl = s.length;
		
		for(int i=0;i<sl-1;i++) {
			int flag = 0;
			
			for(int j=0;j<sl-1-i;j++) {
				
				if(s[j].compareTo(s[j+1]) > 0) {
					
					String temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
					flag = 1;
				}
			}
			
			if(flag == 0) break;			
		}
		return s;
	}
}

